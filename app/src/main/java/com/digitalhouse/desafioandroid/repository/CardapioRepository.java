package com.digitalhouse.desafioandroid.repository;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.model.CardapioModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardapioRepository {

    List<CardapioModel> cardapioModelList = null;

    private String saladaDescription = "Saladas, de maneira geral, são grandes aliadas das dietas. " +
            "Os ingredientes mais comumente usados são ricos em benefícios à saúde e pouco calóricos, " +
            "como o tomate, alface, rúcula, cebola e outros. Porém, o acompanhamento desses alimentos " +
            "é que vai determinar se a salada ajuda a emagrecer ou não. ";

    private String potatoDescription = "A batata (Solanum tuberosum L.) faz parte de diversas receitas e " +
            "é um alimento bastante presente nas mesas dos brasileiros. De acordo com a Associação Brasileira " +
            "da Batata, ela é o quarto alimento mais consumido no mundo, ficando atrás apenas do arroz, trigo e milho.";

    public CardapioRepository(){
        List<CardapioModel> cardapio = new ArrayList<>();

        cardapio.add(new CardapioModel("SALAD", R.drawable.splash, saladaDescription));
        cardapio.add(new CardapioModel("BEEF", R.drawable.splash, potatoDescription));
        cardapio.add(new CardapioModel("JUICE", R.drawable.splash, "LLILILILILILILILILILILILILILILILILILILILILILILILILILILI"));
        cardapio.add(new CardapioModel("ORANGE", R.drawable.splash, "LOLOLOLOLOLOLOLOLOLOOLOLOLOLOLOLOLLOLOLOLOLOLOLLOLOLOLOLOLOLOLOLOLOLOLOL"));

        this.cardapioModelList = Collections.unmodifiableList(cardapio);

    }

    public List getCardapioList(){
        return this.cardapioModelList;
    }

}
