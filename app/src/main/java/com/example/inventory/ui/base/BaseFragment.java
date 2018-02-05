package com.example.inventory.ui.base;

import android.app.Fragment;
import android.support.design.widget.Snackbar;

/**
 * Created by usuario on 24/11/17.
 */

public class BaseFragment extends Fragment {
    public void showMessage(String message){
        Snackbar.make(getActivity().findViewById(android.R.id.content),message,Snackbar.LENGTH_SHORT).show();
    }
    public void OnError(String message){

    }
}
