package com.karan.cafebill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.karan.cafebill.view.CartviewActivity;
import com.karan.cafebill.view.HistoryviewActivity;
import com.karan.cafebill.view.OrderviewActivity;
import com.karan.cafebill.view.RevenueviewActivity;

public class DashboardActivity extends AppCompatActivity {
    TextView displayname,logoutview;
    String id[]= new String[]{"100200","100201","100202","100203","100204","100205","100206"};
    String name[]= new String[]{"Gaurav","Komal","Priya","Atul","Siddhant","Pranjal","Ishika"};
    LottieAnimationView cartview,orderview,historyview,revenueview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        displayname=findViewById(R.id.display_name);
        logoutview=findViewById(R.id.txtlogout);

        //view
        cartview=findViewById(R.id.cart_view);
        orderview=findViewById(R.id.order_view);
        historyview=findViewById(R.id.history_view);
        revenueview=findViewById(R.id.revenue_view);


        logoutview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                checkuserstatus();
            }
        });
        cartview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, CartviewActivity.class));
            }
        });
        orderview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, OrderviewActivity.class));
            }
        });
        historyview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, HistoryviewActivity.class));
            }
        });
        revenueview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, RevenueviewActivity.class));
            }
        });
    }

    protected void onStart() {

        checkuserstatus();
        super.onStart();
    }
    void loadSavedData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
        String userid= (sharedPreferences.getString("userEmail", String.valueOf(MODE_PRIVATE)));
        for(int i=0;i<id.length;i++)
        {
            if(userid.equals(id[i]))
            {
                displayname.setText(name[i]);
            }
        }
    }
    private void checkuserstatus(){
        SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
        Boolean counter=sharedPreferences.getBoolean("loginCounter",Boolean.valueOf(String.valueOf(MODE_PRIVATE)));
        if(counter)
        {
            loadSavedData();
        }
        else{
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            finish();
        }
    }
}