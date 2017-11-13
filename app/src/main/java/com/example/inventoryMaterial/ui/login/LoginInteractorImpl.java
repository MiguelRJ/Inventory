package com.example.inventoryMaterial.ui.login;

import android.text.TextUtils;

import com.example.inventoryMaterial.data.db.repository.UserRepository;
import com.example.inventoryMaterial.ui.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(user)) {
            listener.onPasswordEmptyError();
        }else if (TextUtils.isEmpty(password)) {
            listener.onUserEmptyError();
        }else if (!CommonUtils.isPasswordValid(password)) {
            listener.onPasswordError();
        } else if (UserRepository.getInstance().validateCredentials(user, password)){
            listener.onSuccess();
        }

        //Y es correcto
    }
}
