package com.digitalhouse.desafioandroid.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.adapter.MyAdapter;
import com.digitalhouse.desafioandroid.interfaces.RestaurantListener;
import com.digitalhouse.desafioandroid.model.RestauranteModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements RestaurantListener {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    public static final String RESTAURANTE_KEY = "restaurant";


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false); //ok

        mRecyclerView = view.findViewById(R.id.recyclerView); //ok

        myAdapter = new MyAdapter(getContext(), getMyList()); //ok
        mRecyclerView.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()); //ok
        mRecyclerView.setLayoutManager(layoutManager);
        return view;
    }

    private List<RestauranteModel> getMyList(){
        List<RestauranteModel> models = new ArrayList<>();

        RestauranteModel m = new RestauranteModel();
        m.setTitleRestaurant("Tony Roma's");
        m.setDescriptionAddress("Av. Lavandisca, 717 - Indianópolis, São Paulo");
        m.setDescriptionClose("Fecha às 22:00");
        m.setImage(R.drawable.androidum);
        models.add(m);

        m = new RestauranteModel();
        m.setTitleRestaurant("Aoyama - Moema");
        m.setDescriptionAddress("Alameda dos Arapanés, 532 - Moema");
        m.setDescriptionClose("Fecha às 00:00");
        m.setImage(R.drawable.androiddois);
        models.add(m);

        m = new RestauranteModel();
        m.setTitleRestaurant("Outback - Moema");
        m.setDescriptionAddress("Av. Moaci, 187, 187 - Moema, São Paulo");
        m.setDescriptionClose("Fecha às 00:00");
        m.setImage(R.drawable.androidtres);
        models.add(m);

        m = new RestauranteModel();
        m.setTitleRestaurant("Sí Señor!");
        m.setDescriptionAddress("Alameda Jauaperi, 626 - Moema");
        m.setDescriptionClose("Fecha às 01:00");
        m.setImage(R.drawable.androidquatro);
        models.add(m);

        return models;

    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void sendRestaurant(RestauranteModel restauranteModel) {
    }
}
