package com.example.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *     Pantalla login.
 *     Pantalla Dashboard de la aplicación con los siguientes iconos: inventario, producto, dependencias, secciones y preferencias
 *     Alta/Edición de un inventario
 *     Alta/Edición de un producto
 */

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        gridDashboard=(GridLayout)findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendra el id de las imagenes
        // Inventory, Product, Dependencias, Secciones, Preferencias.
        int[] images ={R.drawable.inventory,R.drawable.monitor, R.drawable.closet, R.drawable.table, R.drawable.cpu};

        // En Java/Android no se utilizan arrays de objetos, se utilizan vector o colecciones
        // ImageView[] imageViews = new ImageView[images.length]; los arrays de objeto no son eficientes
        // No utilizamos la clase vector porque no trabajamos con hilos y n ose requiere sincronizacion
        // Vector<ImageView> vectorImageViews = new Vector<ImageView>();
        // ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();
        listenerDashboard = new ClickListenerDashboard();
        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);


        for (int i=0; i<images.length; i++){
            imageView = new ImageView(this);
            imageView.setId(images[i]);
            imageView.setImageResource(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=(int)width;
            params.height=(int)height;
            params.rowSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashboard);
            gridDashboard.addView(imageView);
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.drawable.inventory:
                    intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.monitor:
                    intent = new Intent(DashBoardActivity.this, ProductsActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.closet:
                    intent = new Intent(DashBoardActivity.this,DependencyActivity.class);
                    startActivity(intent);
                    break;
            }
            //startActivity(intent);
        }
    }
}
