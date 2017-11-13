package com.example.inventoryMaterial.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.inventoryMaterial.DashBoardActivity;
import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.base.BaseActivity;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *          LoginViewImpl
 *          El login de nuestra aplicacion con usuario y contraseña
 */

public class LoginViewImpl extends BaseActivity implements LoginView {

    private Button btnSignIN;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenterImpl(this);
        btnSignIN = findViewById(R.id.btnSignIn);
        btnSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials("Miguel","Miguel1");
            }
        });
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImpl.this, DashBoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPasswordLength);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
