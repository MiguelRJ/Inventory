package com.example.inventory.ui.login;

/**
 * Created by usuario on 10/11/17.
 * Contiene los metodos necesarios/expuestos para la comunicacion del presentador con la vista
 */

public interface LoginView {

    void navigateToHome();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordError();
}
