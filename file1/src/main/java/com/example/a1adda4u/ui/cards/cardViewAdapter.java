package com.example.a1adda4u.ui.cards;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1adda4u.R;

import java.util.ArrayList;

public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.cardView>
{
    private ArrayList<Integer> imageViews ;

    public cardViewAdapter(ArrayList<Integer> imageViews) {
        this.imageViews = imageViews;
    }

    @NonNull
    @Override
    public cardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.offer_cards,parent,false);
        return new cardView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardView holder, int position) {
        holder.imageView.setImageResource(imageViews.get(position));
    }

    @Override
    public int getItemCount() {
        return imageViews.size();
    }

    public class cardView extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public cardView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewCard);
        }
    }


}
