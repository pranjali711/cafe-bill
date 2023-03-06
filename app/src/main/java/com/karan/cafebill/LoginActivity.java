package com.karan.cafebill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText text_email,text_password;
    Button btn_login;
    String id[]= new String[]{"100200","100201","100202","100203","100204","100205","100206"};
    String pass[]= new String[]{"password","12345678","helloworld","qwerty","android","cafe101","password"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text_email=findViewById(R.id.editText_email);
        text_password=findViewById(R.id.editText_password);
        btn_login=findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String empid=text_email.getText().toString().trim();
                String password=text_password.getText().toString().trim();
                int len=id.length;
                for(int i=0;i<len;i++)
                {
                    if(empid.equals(id[i])){
                        if(password.equals(pass[i]))
                        {
                            saveData(id[i]);
                        }
                        else {
                            text_password.setError("Invalid password");
                            text_password.setFocusable(true);
                        }
                    }
                    else{
                        if(i==len-1)
                        {
                            text_email.setError("Invalid Id");
                            text_email.setFocusable(true);
                        }
                    }
                }
                text_password.setText("");
                text_email.setText("");
            }
        });
    }

    void saveData(final String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loginCounter", true);
        editor.putString("userEmail", email);
        editor.apply();
        SharedPreferences sharedPreferences1 = getSharedPreferences("order", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.putBoolean("orderCounter", false);
        editor1.putInt("counter",101);
        editor1.apply();
        Intent intent= new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}