package com.example.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSignIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignIN=(Button)findViewById(R.id.btnSignIn);
        btnSignIN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnSignIN){
            startActivity(new Intent(this,DashBoardActivity.class));
        }
    }
}
