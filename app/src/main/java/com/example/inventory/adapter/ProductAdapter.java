package com.example.inventory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.data.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    
    public ProductAdapter(@NonNull Context context) {
        super(context, R.layout.item_product, new ArrayList<Product>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ProductHolder productHolder;
        View view = convertView;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.item_product, null);
            productHolder = new ProductHolder();

            productHolder.txvName = (TextView) view.findViewById(R.id.txvName);

            view.setTag(productHolder);

        } else {

            productHolder = (ProductHolder) view.getTag();

        }

        productHolder.txvName.setText(getItem(position).getName());
        return view;

    }

    class ProductHolder {
        TextView txvName;
    }
}
