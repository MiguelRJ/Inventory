package com.example.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        gridDashboard=(GridLayout)findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendra el id de las imagenes
        int[] images ={R.drawable.chair,R.drawable.closet,R.drawable.cpu,
                R.drawable.inventory,R.drawable.keyboard,R.drawable.monitor,
                R.drawable.mouse,R.drawable.printer,R.drawable.proyector,
                R.drawable.table,R.drawable.whiteboard};

        // En Java/Android no se utilizan arrays de objetos, se utilizan vector o colecciones
        // ImageView[] imageViews = new ImageView[images.length]; los arrays de objeto no son eficientes
        // No utilizamos la clase vector porque no trabajamos con hilos y n ose requiere sincronizacion
        // Vector<ImageView> vectorImageViews = new Vector<ImageView>();
        // ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();
        ImageView imageView;
        int width=(int)getResources().getDimension(R.dimen.imgDashboardWidth);
        int height=(int)getResources().getDimension(R.dimen.imgDashboardHeight);


        for (int i=0; i<images.length; i++){
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=width;
            params.height=height;
            params.rowSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            imageView.setLayoutParams(params);
            gridDashboard.addView(imageView);
        }
    }
}
