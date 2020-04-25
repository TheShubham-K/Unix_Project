package com.example.a1adda4u.ui.canteen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1adda4u.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private ArrayList<String> mItems;
    private int resID;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> Items,int resourceID, Context Context) {
        Log.d(TAG, "RecyclerViewAdapter: pasted the arguments");
        mItems = Items;
        mContext = Context;
        resID = resourceID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.canteen_d_layout_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolder: Created Views");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Dynamically set the images value as per requirement
        holder.image.setImageResource(resID);
        holder.textView.setText(mItems.get(position));
        holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Clicked Item "+(position+1), Toast.LENGTH_SHORT).show();
                }
            });
        Log.d(TAG, "onBindViewHolder: Binded the View");
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textView;
        MaterialCardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.recyclerImage);
            textView = itemView.findViewById(R.id.recyclerTextView);
            card = itemView.findViewById(R.id.parent_layout);
            Log.d(TAG, "ViewHolder: ViewHolder is called");
        }
    }
}
