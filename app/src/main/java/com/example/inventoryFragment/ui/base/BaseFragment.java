package com.example.inventoryFragment.ui.base;

import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.inventoryFragment.R;

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
