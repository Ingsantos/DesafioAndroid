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
import com.digitalhouse.desafioandroid.interfaces.CardapioListener;
import com.digitalhouse.desafioandroid.model.CardapioModel;

import java.util.List;


public class CardapioRecyclerViewAdapter extends RecyclerView.Adapter<CardapioRecyclerViewAdapter.OtherViewHolder>{

    private List<CardapioModel> cardapioModelList;
    private CardapioListener cardapioListener;

    public CardapioRecyclerViewAdapter(List<CardapioModel> cardapioModelList, CardapioListener cardapioListener) {
        this.cardapioModelList = cardapioModelList;
        this.cardapioListener = cardapioListener;
    }

    @NonNull
    @Override
    public OtherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.cardapio_reclycer_view, parent, false);
        return new OtherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherViewHolder holder, int position) {
        final CardapioModel cardapioModel = cardapioModelList.get(position);
        holder.onBindOther(cardapioModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardapioListener.enviaCardapio(cardapioModel);
            }
        });


    }

    @Override
    public int getItemCount() {
        return cardapioModelList.size();
    }

    public class OtherViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageViewCardapio;
        public TextView mTextViewCardapio;

        public OtherViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageViewCardapio = itemView.findViewById(R.id.imageViewCardapio);
            mTextViewCardapio = itemView.findViewById(R.id.textViewCardapio);
        }

        public void onBindOther(CardapioModel cardapioModel) {
            mTextViewCardapio.setText(cardapioModel.getTitleFood());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(cardapioModel.getImageFood());
                mImageViewCardapio.setImageDrawable(drawable);
            }
        }
    }
}
