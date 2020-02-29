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

    private String hambuguerDescription = "Um hamburguer bem feito pode ser uma refeição tão saborosa quanto um " +
            "prato de restaurante. Mas para isso, é preciso abandonar a conveniência de fast food e dos" +
            " bifes de hamburguer congelados - para um hamburguer realmente gostoso, você precisa fazer o seu bife";

    private String japonesDescription = "Comida japonesa já caiu no gosto do brasileiros! Quem não gosta de um " +
            "deliciosos sushi, sashimi ou tempurás!? E você sabia que pode preparar essas delícias em casa? Sim! " +
            "Com algumas dicas e truques essenciais, você prepara diversos pratos dessa culinária rica em texturas e sabores.";

    private String mexicanDescription = "Simples, alegre e colorida, a comida mexicana é bem familiar para nós " +
            "brasileiros. Muito além de tacos com queijo, há petiscos, pratos completos e até sobremesas, tudo com " +
            "a marca do sabor intenso, das mordidas deliciosas e do equilíbrio. Há picância, frescor, acidez, " +
            "cremosidade, crocância. Escolha suas receitas de comida mexicana preferidas e entre para essa festa de sabores.";

    private String fondueDescription = "Fondue (fundida) é um prato de origem suíça, originalmente à base de queijo aquecido sobre " +
            "uma lamparina, também conhecida como espiriteira ou rechaud, ou outra fonte de calor pouco " +
            "intenso e do qual as pessoas se servem diretamente.";


    public CardapioRepository(){
        List<CardapioModel> cardapio = new ArrayList<>();

        cardapio.add(new CardapioModel("Fresh Salad", R.drawable.imagem05, saladaDescription));
        cardapio.add(new CardapioModel("Baked Potato", R.drawable.imagem09, potatoDescription));
        cardapio.add(new CardapioModel("Japonese", R.drawable.imagem08, japonesDescription));
        cardapio.add(new CardapioModel("Cheese Stuffed Burger", R.drawable.imagem04, hambuguerDescription));
        cardapio.add(new CardapioModel("TexMex delicious", R.drawable.imagem07,mexicanDescription ));
        cardapio.add(new CardapioModel("Fondue", R.drawable.imagem06, potatoDescription));

        this.cardapioModelList = Collections.unmodifiableList(cardapio);

    }

    public List getCardapioList(){
        return this.cardapioModelList;
    }

}
