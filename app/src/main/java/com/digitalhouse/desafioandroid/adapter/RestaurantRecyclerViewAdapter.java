package com.digitalhouse.desafioandroid.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.interfaces.RestaurantListener;
import com.digitalhouse.desafioandroid.model.RestaurantModel;

import java.util.List;


public class RestaurantRecyclerViewAdapter extends RecyclerView.Adapter<RestaurantRecyclerViewAdapter.ViewHolder> {
    private List<RestaurantModel> restaurantModelsList;
    private RestaurantListener restaurantListener;

    public RestaurantRecyclerViewAdapter(List<RestaurantModel> restaurantModels, RestaurantListener restaurantListener) {
        this.restaurantModelsList = restaurantModels;
        this.restaurantListener = restaurantListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.restaurant_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestaurantModel restaurantModel = restaurantModelsList.get(position);
        holder.onBind(restaurantModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantListener.enviaRestaurante(restaurantModel);
            }
        });
    }

    @Override
    public int getItemCount() {

        return restaurantModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTitleRestaurant, mDescriptionAddress, mDescriptionClose;
        //public CardView mCardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageViewRestaurant);
            mTitleRestaurant = itemView.findViewById(R.id.textViewRestaurantName);
            mDescriptionAddress = itemView.findViewById(R.id.textViewAddress);
            mDescriptionClose = itemView.findViewById(R.id.textViewTimeClose);
            //mCardView = itemView.findViewById(R.id.cardview_id);
        }

        public void onBind(RestaurantModel restaurantModel) {
            mTitleRestaurant.setText(restaurantModel.getTitleRestaurant());
            mDescriptionAddress.setText(restaurantModel.getDescriptionAddress());
            mDescriptionClose.setText(restaurantModel.getDescriptionClose());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(restaurantModel.getImage());
                mImageView.setImageDrawable(drawable);
            }
        }
    }
}



