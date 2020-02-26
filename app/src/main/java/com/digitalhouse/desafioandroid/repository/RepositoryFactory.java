package com.digitalhouse.desafioandroid.repository;

public class RepositoryFactory {
    static RestaurantRepository restaurantRepository;
    static CardapioRepository cardapioRepository;

    private RepositoryFactory(){
        super();
    }

    public static RestaurantRepository getRestaurantRepository(){
        if(restaurantRepository==null){
            restaurantRepository = new RestaurantRepository();
        }
        return restaurantRepository;
    }

    public static CardapioRepository getCardapioRepository(){
        if(cardapioRepository==null){
            cardapioRepository = new CardapioRepository();
        }
        return cardapioRepository;
    }


}
