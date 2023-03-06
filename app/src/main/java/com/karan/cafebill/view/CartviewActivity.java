package com.karan.cafebill.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.karan.cafebill.MainAdapter;
import com.karan.cafebill.OrderComplete;
import com.karan.cafebill.R;
import com.karan.cafebill.orderlist;

import java.util.ArrayList;
import java.util.HashMap;

public class CartviewActivity extends AppCompatActivity {

    ArrayList<orderlist> items = new ArrayList<orderlist>();
    Button order;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    TextView price;
    DatabaseReference myRef;
    FirebaseDatabase database;
    int totalamount=0,ouramount=0,orderno=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartview);
        order=findViewById(R.id.order_now);
        price=findViewById(R.id.total_price);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("history");
        try{
            Bundle bundle=getIntent().getExtras();
            items = (ArrayList<orderlist>) bundle.getSerializable("arraylist");
            for(int i = 0; i < items.size(); i++){
                totalamount+=items.get(i).getPrice();
                ouramount+=items.get(i).getOurprice();
            }
            recyclerView=findViewById(R.id.cart_recycleview);
            layoutManager = new LinearLayoutManager(this);
            adapter=new MainAdapter(items);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            price.setText(totalamount+"");
        }catch (Exception e){
            if(items.size()==0)
            {
                order.setEnabled(false);
            }
        }


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderno=getorder();
               uploadData(orderno,totalamount,ouramount);
            }
        });
    }
    private int getorder()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("order", MODE_PRIVATE);
        int orderno=sharedPreferences.getInt("counter", Integer.valueOf(MODE_PRIVATE));
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        orderno+=1;
        editor1.putInt("counter",orderno);
        editor1.apply();
        return orderno;
    }
    private void uploadData(int orderno,int totalamount,int ouramount) {

        HashMap<Object,String> cust=new HashMap<>();
        cust.put("orderno",orderno+"");
        cust.put("Totalamount",totalamount+"");
        cust.put("Ouramount",ouramount+"");
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference("history");
        ref.child(String.valueOf(orderno)).setValue(cust).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(CartviewActivity.this, OrderComplete.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CartviewActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}