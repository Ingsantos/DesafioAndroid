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
import java.util.List;

public class MenuFragment extends Fragment implements RestaurantListener {

    public static final String RESTAURANT_KEY = "restaurante";
    private RecyclerView mRecyclerView;
    private RestaurantRecyclerViewAdapter adapter;
    private RestaurantRepository restaurantRepository;

    public MenuFragment() {
        this.restaurantRepository = RepositoryFactory.getRestaurantRepository();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mRecyclerView = view.findViewById(R.id.rv_list);
        adapter = new RestaurantRecyclerViewAdapter(getMyRestaurantList(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);

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
                .beginTransaction().addToBackStack(null).replace(R.id.container, fragment)
                .commit();
    }

    private List<RestaurantModel> getMyRestaurantList(){
        return restaurantRepository.getRestaurantList();
    }
}
