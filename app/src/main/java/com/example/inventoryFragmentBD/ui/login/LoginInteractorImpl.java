package com.example.inventoryFragmentBD.ui.login;

import android.text.TextUtils;

import com.example.inventoryFragmentBD.ui.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(user)) {
            listener.onUserEmptyError();
        }else if (TextUtils.isEmpty(password)) {
            listener.onPasswordEmptyError();
        }else if (!CommonUtils.isPasswordValid(password)) {
            listener.onPasswordError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            listener.onSuccess();
        }

        //Y es correcto
    }
}
