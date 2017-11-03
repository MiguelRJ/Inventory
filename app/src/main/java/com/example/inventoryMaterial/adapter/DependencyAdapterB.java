package com.example.inventoryMaterial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          DependencyAdapter adaptara la dependencia a una elemento view para mostrarlo en la interfaz.
 *          Esta es la solucion fea (La buena, la mala y la fea)
 *
 *          view = convertView Para que no este creando en memoria mas vies de la cuenta
 *
 *          if(view==null) Si es null (no hay elementos view fuera de la vista de la app)
 *              Obtengo el servicio inflater para crear elementos en la vista
 *
 *              Creo los elementos en memoria con el layout (item_layout) con el que ya especifico como se veran
 *
 *          Los elementos view que se hayan creado se iran cambiando sus valores
 *              Inicializo las variables de lo definido en el layout (item_layout)
 *
 *              Mostrar los datos del ArrayList mediante position
 * @date 26/10/17
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency> {
    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvSortName;
        View view = convertView;

        if (view == null) {// Solo se crea el objeto view cuando sean las 9 primeras veces de ese objeto
            //1. Obtener el servicio del sistema Latout Inflate en el contexto.
            // Acceder al servicio de layout inflater de dos formas distintas
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. Inflar la vista. Crea en memoria el objeto con todos los widget del xml item_dependency.xml
            view = inflater.inflate(R.layout.item_dependency, null);// null porque ya hemos establecido la vista en item_dependency
        }
        //3. Inicializar las variables a los objetos ya creados de los widget del xml.¡¡ CUIDADO View.findViewById!!
        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvName = (TextView) view.findViewById(R.id.txvNameSector);
        txvSortName = (TextView) view.findViewById(R.id.txvSortName);

        //4. Mostrar los datos del ArrayList mediante position
        icon.setLetter(getItem(position).getSortName().substring(0, 1));
        txvName.setText(getItem(position).getName());
        txvSortName.setText(getItem(position).getSortName());
        return view;
    }
}
