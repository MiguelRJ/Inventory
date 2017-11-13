package com.example.inventoryMaterial.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        //Si el password es vacio
        if(false) {
            listener.onPasswordEmptyError();
        }else if(false) {
            listener.onUserEmptyError();
        }else if(false) {
            listener.onPasswordError();
        } else {
            listener.onSuccess();
        }

        //Y es correcto
    }
}
