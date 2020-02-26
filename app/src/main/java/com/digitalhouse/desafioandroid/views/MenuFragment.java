package com.digitalhouse.desafioandroid.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.adapter.RestaurantRecyclerViewAdapter;
import com.digitalhouse.desafioandroid.interfaces.RestaurantListener;
import com.digitalhouse.desafioandroid.model.RestaurantModel;
import com.digitalhouse.desafioandroid.repository.RepositoryFactory;
import com.digitalhouse.desafioandroid.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements RestaurantListener {

    public static final String RESTAURANT_KEY = "restaurante";
    private RecyclerView mRecyclerView;
    private RestaurantRecyclerViewAdapter adapter;
    private RestaurantRepository restaurantRepository;

    public MenuFragment() {
        // Required empty public constructor
        this.restaurantRepository = RepositoryFactory.getRestaurantRepository();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        mRecyclerView = view.findViewById(R.id.rv_list);

        adapter = new RestaurantRecyclerViewAdapter(getMyList(), this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void enviaRestaurante(RestaurantModel restaurantModel) {

        Fragment fragment = new CardapioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANT_KEY, restaurantModel);
        fragment.setArguments(bundle);

        replaceFragment(fragment);

    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.container, fragment)
                .commit();
    }

    private List<RestaurantModel> getMyList(){
//        List<RestaurantModel> restaurantes = new ArrayList<>();
//
//        restaurantes.add(new RestaurantModel("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00",R.drawable.image0));
//        restaurantes.add(new RestaurantModel("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00",R.drawable.image1));
//        restaurantes.add(new RestaurantModel("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo","Fecha às 00:00",R.drawable.image2));
//        restaurantes.add(new RestaurantModel("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00",R.drawable.image3));
//
//        return restaurantes;
        return restaurantRepository.getRestaurantList();
    }
}
