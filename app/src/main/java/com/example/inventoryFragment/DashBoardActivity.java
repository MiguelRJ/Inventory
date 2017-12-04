package com.example.inventoryFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.inventoryFragment.data.prefs.AppPreferencesHelper;
import com.example.inventoryFragment.ui.dependency.DependencyActivity;
import com.example.inventoryFragment.ui.inventory.InventoryActivity;
import com.example.inventoryFragment.ui.inventory.InventoryApplication;
import com.example.inventoryFragment.ui.prefs.AccountSettingActivity;
import com.example.inventoryFragment.ui.products.GeneralSettingActivity;
import com.example.inventoryFragment.ui.products.ProductsActivity;
import com.example.inventoryFragment.ui.sector.SectorActivity;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *      DashBoardActivity
 *      Una vez logeado nos encontramos con esta Activity
 *      Donde estaran los iconos de las distintas funciones de la aplicacion
 *      Dashboard contara con los siguientes iconos:
 *      Inventario, Producto, Dependencias, Sectores, Preferencias
 *      Inventory, Products, Dependencies, Sectors, Preferences
 */

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendra el id de las imagenes
        // Inventory, Products, Dependencies, Sectors, Preferences
        int[] images = {R.drawable.inventory, R.drawable.monitor, R.drawable.closet, R.drawable.table, R.drawable.cpu};

        // En Java/Android no se utilizan arrays de objetos, se utilizan vector o colecciones
        // ImageView[] imageViews = new ImageView[images.length]; los arrays de objetos no son eficientes
        // No utilizamos la clase vector porque no trabajamos con hilos y no se requiere sincronizacion
        // Vector<ImageView> vectorImageViews = new Vector<ImageView>();
        // ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();
        listenerDashboard = new ClickListenerDashboard();
        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);

        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setId(images[i]);// Asignamos un ID que sera la referencia que designa el sistema
            imageView.setImageResource(images[i]);// Asignamos una de las imagenes del array creado anteriormente
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;// Asignamos el width definido en dimens.xml
            params.height = (int) height;// Asignamos el height definido en dimens.xml
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);// Asignamos que ocupe el maximo posible en la fila
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);// Asignamos que ocupe el maximo posible en la columna
            imageView.setLayoutParams(params);// Establecemos los parametros asignados antes
            imageView.setOnClickListener(listenerDashboard);// Asignamos el OnClickListener a la imagen
            gridDashboard.addView(imageView);// Anadimos la imagen al grid
        }
    }

    class ClickListenerDashboard implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.drawable.inventory:
                    intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.monitor:
                    intent = new Intent(DashBoardActivity.this, ProductsActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.closet:
                    intent = new Intent(DashBoardActivity.this, DependencyActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.table:
                    intent = new Intent(DashBoardActivity.this, SectorActivity.class);
                    startActivity(intent);
                    break;
            }
            //startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_settings:
                startActivity(new Intent(DashBoardActivity.this,AccountSettingActivity.class));
                break;
            case R.id.action_general_settings:
                startActivity(new Intent(DashBoardActivity.this,GeneralSettingActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showAppPreferences();
    }

    private void showAppPreferences() {
        AppPreferencesHelper appPreferencesHelper=((InventoryApplication)getApplicationContext()).getAppPreferencesHelper();
        appPreferencesHelper.setCurrentUserName("Miguel");
        String message = "Tu usuario de sesion es"+ appPreferencesHelper.getCurrentUserName();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
