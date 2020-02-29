package com.digitalhouse.desafioandroid.views;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.adapter.CardapioRecyclerViewAdapter;
import com.digitalhouse.desafioandroid.interfaces.CardapioListener;
import com.digitalhouse.desafioandroid.model.CardapioModel;
import com.digitalhouse.desafioandroid.model.RestaurantModel;
import com.digitalhouse.desafioandroid.repository.CardapioRepository;
import com.digitalhouse.desafioandroid.repository.RepositoryFactory;
import java.util.List;
import static com.digitalhouse.desafioandroid.views.MenuFragment.RESTAURANT_KEY;

public class CardapioFragment extends Fragment implements CardapioListener {

    public static final String CARDAPIO_KEY = "cardapio";
    private RecyclerView mRecyclerViewCardapio;
    private CardapioRecyclerViewAdapter adapterCardapio;
    private ImageView imageViewRestaurante;
    private CardapioRepository cardapioRepository;

    public CardapioFragment() {
        this.cardapioRepository = RepositoryFactory.getCardapioRepository();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);
        mRecyclerViewCardapio = view.findViewById(R.id.cardapio_list);
        adapterCardapio = new CardapioRecyclerViewAdapter(getMyCardapiorList(), this);
        mRecyclerViewCardapio.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerViewCardapio.setAdapter(adapterCardapio);
        imageViewRestaurante = view.findViewById(R.id.imageViewRestaurantCardapio);

        if (getArguments() != null){
            Bundle bundle = getArguments();
            RestaurantModel restaurantModel = bundle.getParcelable(RESTAURANT_KEY);
            imageViewRestaurante.setImageResource(restaurantModel.getImage());
        }
        return view;
    }

    @Override
    public void enviaCardapio(CardapioModel cardapioModel) {
        Fragment fragment = new PratoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CARDAPIO_KEY, cardapioModel);
        fragment.setArguments(bundle);
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction().addToBackStack(null).replace(R.id.container, fragment)
                .commit();
    }

    private List<CardapioModel> getMyCardapiorList(){
        return cardapioRepository.getCardapioList();
    }
}
