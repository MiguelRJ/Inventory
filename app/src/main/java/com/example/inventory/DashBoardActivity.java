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
        int width=(int)getResources().getDimension(R.dimen.imgDashboardWidth);
        int height=(int)getResources().getDimension(R.dimen.imgDashboardHeight);
        ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();
        for (int i=0; i<images.length; i++){
            arrayImageViews.add(new ImageView(this));
            arrayImageViews.get(i).setImageResource(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=width;
            params.height=height;
            params.rowSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec=GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            arrayImageViews.get(i).setLayoutParams(params);
            gridDashboard.addView(arrayImageViews.get(i));
        }
    }
}
