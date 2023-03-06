package com.karan.cafebill.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karan.cafebill.History;
import com.karan.cafebill.HistoryAdapter;
import com.karan.cafebill.R;

import java.util.ArrayList;

public class RevenueviewActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<History> eventList;
    HistoryAdapter mainAdapter;
    int total=0,our=0;
    TextView totalamount,totalcost,minus,revenuetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenueview);
        totalamount=findViewById(R.id.total_amount_textview);
        totalcost=findViewById(R.id.total_cost_textview);
        revenuetext=findViewById(R.id.text_revenue);
        minus=findViewById(R.id.text_minus);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("history");
        loadPosts();
    }
    private void loadPosts() {
        //path of all posts
        if (myRef != null) {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    eventList = new ArrayList<History>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        History modelEvent = ds.getValue(History.class);
                        eventList.add(modelEvent);
                    }




                    for(History h:eventList){
                        total+=Integer.parseInt(h.getTotalamount());
                        our+=Integer.parseInt(h.getOuramount());
                    }
                    totalamount.setText(""+total);
                    totalcost.setText(""+our);
                    minus.setText(total+" - "+our);
                    revenuetext.setText(total-our+"");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //in case of error
                    Toast.makeText(RevenueviewActivity.this,""+databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}