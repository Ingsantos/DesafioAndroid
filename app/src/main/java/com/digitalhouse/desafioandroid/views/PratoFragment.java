package com.digitalhouse.desafioandroid.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.model.CardapioModel;

import static com.digitalhouse.desafioandroid.views.CardapioFragment.CARDAPIO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class PratoFragment extends Fragment {

    private ImageView imageViewPrato;
    private TextView textViewPrato;

    public PratoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prato, container, false);

        imageViewPrato = view.findViewById(R.id.imageViewRestaurantCardapioPrato);
        textViewPrato = view.findViewById(R.id.textViewDescriptionCardapioPrato);

        if (getArguments() != null){
            Bundle bundle = getArguments();
            CardapioModel cardapioModel = bundle.getParcelable(CARDAPIO_KEY);
            imageViewPrato.setImageResource(cardapioModel.getImageFood());
            textViewPrato.setText(cardapioModel.getDescriptionCardapio());
        }

        return view;
    }
}
