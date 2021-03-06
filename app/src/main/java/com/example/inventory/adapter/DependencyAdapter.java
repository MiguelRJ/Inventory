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
import com.example.inventory.data.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          DependencyAdapter adaptara la dependencia a una elemento view para mostrarlo en la interfaz.
 *          Esta es la solucion buena (La buena, la mala y la fea)
 *
 *          DependencyHolder dependencyHolder Para que posea las variables de los view
 *
 *          view = convertView Para que no este creando en memoria mas vies de la cuenta
 *
 *          if(view==null) Si es null (No hay elementos view fuera de la vista de la app)
 *              Obtengo el servicio inflater para crear elementos en la vista
 *
 *              Creo los elementos en memoria con el layout (item_layout) con el que ya especifico como se veran
 *
 *          else Si no es null (Hay elementos view fuera de la vistade la app)
 *              El objeto DependencyHolder sera el que le asignamos con view.getTag sus variables
 *
 *
 *          Los elementos view que se hayan creado se iran cambiando sus valores
 *              Inicializo las variables de lo definido en el layout (item_layout)
 *
 *              Mostrar los datos del ArrayList mediante position
 * @date 26/10/17
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    //private ArrayList<Dependency> dependencies;

    /**
     * Se crea una copia del ArrayList que se tiene en DependencyRepository
     * para tener una copia local en el adapter que se pueda moficar sin cambiar los datos originales
     * @param context
     */
    public DependencyAdapter(@NonNull Context context) {
        //super(context, R.layout.item_dependency, new ArrayList<>(DependencyRepository.getInstance().getDependencies())); // para mostrar los datos de innitializate
        //sort(new Dependency.DependencyOrderByShortName());
        //dependencies = new ArrayList<>(DependencyRepository.getInstance().getDependencies());// Para tener un array list distinto del que sea ha hecho sort
        super(context,R.layout.item_dependency,new ArrayList<Dependency>());// para mostrar la lista vacia al principio
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view = convertView;

        if (view == null) {// Solo se crea el objeto view cuando sean las 9 primeras veces de ese objeto
            //1. Obtener el servicio del sistema Latout Inflate en el contexto.
            // Acceder al servicio de layout inflater de dos formas distintas
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. Inflar la vista. Crea en memoria el objeto con todos los widget del xml item_dependency.xml
            view = inflater.inflate(R.layout.item_dependency, null);// null porque ya hemos establecido la vista en item_dependency
            dependencyHolder = new DependencyHolder();

            //3. Inicializar las variables a los objetos ya creados de los widget del xml.¡¡ CUIDADO View.findViewById!!
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvSortName = (TextView) view.findViewById(R.id.txvSortName);
            /*Typeface typeface = Typeface.createFromAsset(parent.getResources().getAssets(),"font/fontchristmas.ttf");
            dependencyHolder.txvName.setTypeface(typeface);
            dependencyHolder.txvName.setTextSize(40);*/
            view.setTag(dependencyHolder);// Se guarda como Tag la clase DependencyHolder con el valor de sus variables
        } else {
            dependencyHolder = (DependencyHolder) view.getTag();// El objeto dependencyHolder sera el que le asignamos al view
        }

        //4. Mostrar los datos del ArrayList mediante position
        dependencyHolder.icon.setLetter(getItem(position).getSortName().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvSortName.setText(getItem(position).getSortName());
        return view;
    }

    public DependencyAdapter orderByShortName(){
        sort(new Dependency.DependencyOrderByShortName());
        return this;
    }

    /**
     * Esta clase se usa para tener las instancias de los View ya creadas y solo asignarlas mediante view.getTag()
     */
    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvSortName;
    }
}
