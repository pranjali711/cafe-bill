package com.karan.cafebill.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class HistoryviewActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    RecyclerView recyclerView;
    ArrayList<History> eventList;
    HistoryAdapter mainAdapter;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyview);


        //recycler view and its prop
        recyclerView = findViewById(R.id.recycler_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //show newest post first, for this load from last

        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        //set layout to recyclerview
        recyclerView.setLayoutManager(layoutManager);

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
                        mainAdapter = new HistoryAdapter(eventList);
                        //set adapter to recycler view
                        recyclerView.setAdapter(mainAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //in case of error
                     Toast.makeText(HistoryviewActivity.this,""+databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}