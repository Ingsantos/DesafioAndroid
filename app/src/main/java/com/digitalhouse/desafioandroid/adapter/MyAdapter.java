package com.digitalhouse.desafioandroid.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalhouse.desafioandroid.R;
import com.digitalhouse.desafioandroid.model.RestauranteModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context context;
    List<RestauranteModel> restauranteModels;

    public MyAdapter(Context context, List<RestauranteModel> restauranteModels) {
        this.context = context;
        this.restauranteModels = restauranteModels;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final RestauranteModel restaurante = restauranteModels.get(position);
        holder.bindView(restaurante);

//        holder.mTitleRestaurant.setText(restauranteModels.get(position).getTitleRestaurant());
//        myHolder.mDescriptionAddress.setText(restauranteModels.get(position).getDescriptionAddress());
//        myHolder.mDescriptionClose.setText(restauranteModels.get(position).getDescriptionClose());
//        myHolder.mImageView.setImageResource(restauranteModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return restauranteModels.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView mImageView;
        public TextView mTitleRestaurant, mDescriptionAddress, mDescriptionClose;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            this.mImageView = itemView.findViewById(R.id.imageViewRestaurant);
            this.mTitleRestaurant = itemView.findViewById(R.id.textViewRestaurantName);
            this.mDescriptionAddress = itemView.findViewById(R.id.textViewAddress);
            this.mDescriptionClose = itemView.findViewById(R.id.textViewTimeClose);
        }

        public void bindView (RestauranteModel restauranteModel){
            mTitleRestaurant.setText(restauranteModel.getTitleRestaurant());
            mDescriptionAddress.setText(restauranteModel.getDescriptionAddress());
            mDescriptionClose.setText(restauranteModel.getDescriptionClose());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(restauranteModel.getImage());
                mImageView.setImageDrawable(drawable);
            }
        }

        public void onClick (View view){

        }
    }
}
