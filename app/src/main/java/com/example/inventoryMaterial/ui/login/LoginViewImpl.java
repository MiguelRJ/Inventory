package com.example.inventoryMaterial.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inventoryMaterial.DashBoardActivity;
import com.example.inventoryMaterial.R;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *          LoginViewImpl
 *          El login de nuestra aplicacion con usuario y contraseña
 */

public class LoginViewImpl extends AppCompatActivity implements View.OnClickListener {

    private Button btnSignIN;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignIN = (Button) findViewById(R.id.btnSignIn);
        btnSignIN.setOnClickListener(this);
        loginPresenter.validateCredentials("Miguel","123");
    }

    @Override
    public void onClick(View v) {
        if (v == btnSignIN) {
            startActivity(new Intent(this, DashBoardActivity.class));
        }
    }
}
