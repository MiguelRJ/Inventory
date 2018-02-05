package com.example.inventory.ui.products.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventory.R;
import com.example.inventory.adapter.ProductAdapter;
import com.example.inventory.data.db.model.Product;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.products.contract.ListProductContract;
import com.example.inventory.ui.products.presenter.ListProductPresenter;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductFragment extends ListFragment implements ListProductContract.View {

    public static final String TAG = "ListProductFragment";
    private ListProductListener callback;
    private ProductAdapter adapter;
    private ListProductContract.Presenter presenter;

    private ListView listView;
    private Toolbar toolbar;
    private ProgressDialog progress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new ProductAdapter(getActivity());
        this.presenter = new ListProductPresenter(this);
        setRetainInstance(true);
        progress = new ProgressDialog(getActivity());
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setMessage("Conectando . . .");
        progress.setCancelable(false);
    }

    @Override
    public void showDependency(List<Product> list) {
        adapter.clear();
        adapter.addAll(list);
    }

    public interface ListProductListener {
        void addNewProduct(Bundle bundle);
    }
    public static Fragment newInstance(Bundle bundle) {
        ListProductFragment listProduct= new ListProductFragment();
        if (bundle != null) {
            listProduct.setArguments(bundle);
        }
        return listProduct;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListProductListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be implements ListProductListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_product,container,false);
        // Como se encuentra en el fragment usamos rootview
        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        // Si el FloatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        toolbar = rootView.findViewById(R.id.toolbar);
        listView = rootView.findViewById(android.R.id.list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listView.setNestedScrollingEnabled(true);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        //Log.d("DA","antes del setonclick");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
                callback.addNewProduct(null);
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadProduct();
        //setListAdapter(new DependencyAdapter(getActivity()));
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Product.TAG,(Product)adapterView.getItemAtPosition(position));
                callback.addNewProduct(bundle);
                //Toast.makeText(getActivity(), ((Product)adapterView.getItemAtPosition(position)).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //activar el modo multichoice en la lista

        //registerForContextMenu(getListView()); //se ha comentado porque hemos cambio a mode multichoice  // OnCreateContextMenu
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }
}
