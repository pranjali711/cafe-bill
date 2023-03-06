package com.karan.cafebill.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.karan.cafebill.R;
import com.karan.cafebill.orderlist;

import java.util.ArrayList;

public class OrderviewActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView1,lottieAnimationView2,lottieAnimationView3,lottieAnimationView4,lottieAnimationView5,lottieAnimationView6,lottieAnimationView7,lottieAnimationView8,lottieAnimationView9,lottieAnimationView10,lottieAnimationView11,lottieAnimationView12,lottieAnimationView13;
    boolean flag1=false,flag2=false,flag3=false,flag4=false,flag5=false,flag6=false,flag7=false,flag8=false,flag9=false,flag10=false,flag11=false,flag12=false,flag13=false;
    ArrayList<orderlist> items =new ArrayList<orderlist>();
    Button addtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);
        lottieAnimationView1 = findViewById(R.id.item_101);
        lottieAnimationView2 = findViewById(R.id.item_102);
        lottieAnimationView3 = findViewById(R.id.item_103);
        lottieAnimationView4 = findViewById(R.id.item_104);
        lottieAnimationView5 = findViewById(R.id.item_105);
        lottieAnimationView6 = findViewById(R.id.item_106);
        lottieAnimationView7 = findViewById(R.id.item_107);
        lottieAnimationView8 = findViewById(R.id.item_108);
        lottieAnimationView9 = findViewById(R.id.item_109);
        lottieAnimationView10 = findViewById(R.id.item_110);
        lottieAnimationView11 = findViewById(R.id.item_111);
        lottieAnimationView12 = findViewById(R.id.item_112);
        lottieAnimationView13 = findViewById(R.id.item_113);
        addtocart=findViewById(R.id.add_to_cart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(OrderviewActivity.this,CartviewActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("arraylist",items);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }
    public void addtocart(View view){
        switch(view.getId())
        {
            case R.id.item_101:
                orderlist obj1=new orderlist(80,40,"Veg briyani");
                if(flag1==false)
                {
                    items.add(obj1);
                    lottieAnimationView1.setSpeed(1);
                    lottieAnimationView1.playAnimation();
                    flag1=true;
                }
                else{
                    lottieAnimationView1.setSpeed(-1);
                    lottieAnimationView1.playAnimation();
                    items.remove(obj1);
                    flag1=false;
                }
                break;
            case R.id.item_102:
                orderlist obj2=new orderlist(120,80,"Chicken briyani");
                if(flag2==false)
                {
                    items.add(obj2);
                    lottieAnimationView2.setSpeed(1);
                    lottieAnimationView2.playAnimation();
                    flag2=true;
                }
                else{
                    lottieAnimationView2.setSpeed(-1);
                    lottieAnimationView2.playAnimation();
                    items.remove(obj2);
                    flag2=false;
                }
                break;
            case R.id.item_103:
                orderlist obj3=new orderlist(120,80,"Mutton briyani");
                if(flag3==false)
                {

                    items.add(obj3);
                    lottieAnimationView3.setSpeed(1);
                    lottieAnimationView3.playAnimation();
                    flag3=true;
                }
                else{
                    lottieAnimationView3.setSpeed(-1);
                    lottieAnimationView3.playAnimation();
                    items.remove(obj3);
                    flag3=false;
                }
                break;
            case R.id.item_104:
                orderlist obj4=new orderlist(60,35,"Spring roll");
                if(flag4==false)
                {

                    items.add(obj4);
                    lottieAnimationView4.setSpeed(1);
                    lottieAnimationView4.playAnimation();
                    flag4=true;
                }
                else{
                    lottieAnimationView4.setSpeed(-1);
                    lottieAnimationView4.playAnimation();
                    items.remove(obj4);
                    flag4=false;
                }
                break;
            case R.id.item_105:
                orderlist obj5=new orderlist(80,45,"Chicken momos");
                if(flag5==false)
                {

                    items.add(obj5);
                    lottieAnimationView5.setSpeed(1);
                    lottieAnimationView5.playAnimation();
                    flag5=true;
                }
                else{
                    lottieAnimationView5.setSpeed(-1);
                    lottieAnimationView5.playAnimation();
                    items.remove(obj5);
                    flag5=false;
                }
                break;
            case R.id.item_106:
                orderlist obj6=new orderlist(50,25,"Veg momos");
                if(flag6==false)
                {
                    items.add(obj6);
                    lottieAnimationView6.setSpeed(1);
                    lottieAnimationView6.playAnimation();
                    flag6=true;
                }
                else{
                    lottieAnimationView6.setSpeed(-1);
                    lottieAnimationView6.playAnimation();
                    items.remove(obj6);
                    flag6=false;
                }
                break;
            case R.id.item_107:
                orderlist obj7=new orderlist(80,45,"Gravy rolls");
                if(flag7==false)
                {
                    items.add(obj7);
                    lottieAnimationView7.setSpeed(1);
                    lottieAnimationView7.playAnimation();
                    flag7=true;
                }
                else{
                    lottieAnimationView7.setSpeed(-1);
                    lottieAnimationView7.playAnimation();
                    items.remove(obj7);
                    flag7=false;
                }
                break;
            case R.id.item_108:
                orderlist obj8=new orderlist(120,60,"Chicken rolls");
                if(flag8==false)
                {
                    items.add(obj8);
                    lottieAnimationView8.setSpeed(1);
                    lottieAnimationView8.playAnimation();
                    flag8=true;
                }
                else{
                    lottieAnimationView8.setSpeed(-1);
                    lottieAnimationView8.playAnimation();
                    items.remove(obj8);
                    flag8=false;
                }
                break;
            case R.id.item_109:
                orderlist obj9=new orderlist(80,45,"Pasta");
                if(flag9==false)
                {
                    items.add(obj9);
                    lottieAnimationView9.setSpeed(1);
                    lottieAnimationView9.playAnimation();
                    flag9=true;
                }
                else{
                    lottieAnimationView9.setSpeed(-1);
                    lottieAnimationView9.playAnimation();
                    items.remove(obj9);
                    flag9=false;
                }
                break;
            case R.id.item_110:
                orderlist obj10=new orderlist(20,10,"Soda");
                if(flag10==false)
                {
                    items.add(obj10);
                    lottieAnimationView10.setSpeed(1);
                    lottieAnimationView10.playAnimation();
                    flag10=true;
                }
                else{
                    lottieAnimationView10.setSpeed(-1);
                    lottieAnimationView10.playAnimation();
                    items.remove(obj10);
                    flag10=false;
                }
                break;
            case R.id.item_111:
                orderlist obj11=new orderlist(40,15,"Coke");
                if(flag11==false)
                {
                    items.add(obj11);
                    lottieAnimationView11.setSpeed(1);
                    lottieAnimationView11.playAnimation();
                    flag11=true;
                }
                else{
                    lottieAnimationView11.setSpeed(-1);
                    lottieAnimationView11.playAnimation();
                    items.remove(obj11);
                    flag11=false;
                }
                break;
            case R.id.item_112:
                orderlist obj12=new orderlist(50,20,"Cold coffee");
                if(flag12==false)
                {
                    items.add(obj12);
                    lottieAnimationView12.setSpeed(1);
                    lottieAnimationView12.playAnimation();
                    flag12=true;
                }
                else{
                    lottieAnimationView12.setSpeed(-1);
                    lottieAnimationView1.playAnimation();
                    items.remove(obj12);
                    flag12=false;
                }
                break;
            case R.id.item_113:
                orderlist obj13=new orderlist(20,15,"Mineral water");
                if(flag13==false)
                {
                    items.add(obj13);
                    lottieAnimationView13.setSpeed(1);
                    lottieAnimationView13.playAnimation();
                    flag13=true;
                }
                else{
                    lottieAnimationView13.setSpeed(-1);
                    lottieAnimationView13.playAnimation();
                    items.remove(obj13);
                    flag13=false;
                }
                break;
        }
    }
}