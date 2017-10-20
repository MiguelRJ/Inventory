package com.example.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;g
import android.view.View;
import android.widget.ImageView;


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
        int[] images ={R.drawable.inventory,R.drawable.closet, R.drawable.whiteboard, R.drawable.table, R.drawable.cpu};

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
            //Log.d("id", String.valueOf(imageView.getId()));
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //Log.d("Switch", String.valueOf(view.getId()) + view.toString());
            Intent intent = null;
            switch (view.getId()){
                case R.drawable.inventory:
                    //Log.d("Switch", String.valueOf(view.getId()));
                    intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.closet:
                    //Log.d("Switch", String.valueOf(view.getId()));
                    intent = new Intent(DashBoardActivity.this, ProductsActivity.class);
                    startActivity(intent);
                    break;
            }
            //startActivity(intent);
        }
    }
}
