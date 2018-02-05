package com.example.inventory.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.inventory.DashBoardActivity;
import com.example.inventory.R;
import com.example.inventory.ui.base.BaseActivity;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *          LoginViewImpl
 *          El login de nuestra aplicacion con usuario y contraseña
 */

public class LoginViewImpl extends BaseActivity implements LoginView {

    private Button btnSignIN;
    private EditText edtUser,edtPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenterImpl(this);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIN = findViewById(R.id.btnSignIn);
        btnSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loginPresenter.validateCredentials("Miguel","Miguel1");
                loginPresenter.validateCredentials(edtUser.getText().toString(),edtPassword.getText().toString());
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
