package com.digitalhouse.desafioandroid.repository;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.model.RestaurantModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantRepository {

    List<RestaurantModel> restaurantes = null;

    public RestaurantRepository(){
        List<RestaurantModel> restaurantes = new ArrayList<>();
        restaurantes.add(new RestaurantModel("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00", R.drawable.image0));
        restaurantes.add(new RestaurantModel("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00",R.drawable.image1));
        restaurantes.add(new RestaurantModel("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo","Fecha às 00:00",R.drawable.image2));
        restaurantes.add(new RestaurantModel("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00",R.drawable.image3));
        this.restaurantes = Collections.unmodifiableList(restaurantes);
    }

    public List getRestaurantList(){

        return this.restaurantes;
    }

}
