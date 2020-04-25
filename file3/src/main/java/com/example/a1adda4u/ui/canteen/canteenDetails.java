package com.example.a1adda4u.ui.canteen;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a1adda4u.ui.transitions.DetailsTransition;
import com.example.a1adda4u.R;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class canteenDetails extends Fragment {

    private int canteen;
    private ArrayList<String> mItems;

    public canteenDetails() {
        //Default Constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Shared Element Transition
        setSharedElementEnterTransition(new DetailsTransition());
        setSharedElementReturnTransition(new DetailsTransition());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: Started onCreate function");
        View v = inflater.inflate(R.layout.canteen_details_f, container, false);



        canteen = getArguments().getInt("items");

        //Setting toolbar values
        Toolbar toolbar = v.findViewById(R.id.toolbarCollapsed);
        toolbar.setTitle(getResources().getString(R.string.canteenName) + " " + (canteen + 1));

        //Dynamically setting the image
        ImageView imageView = v.findViewById(R.id.canteenImage);
        int resID;

        switch (canteen)
        {
            case 0:
                imageView.setImageResource(R.mipmap.coffee_foreground);
                resID = R.mipmap.coffee_round;
                break;
            case 1:
                imageView.setImageResource(R.mipmap.roll_foreground);
                resID = R.mipmap.roll_round;
                break;
            case 2:
                imageView.setImageResource(R.mipmap.poori_foreground);
                resID = R.mipmap.poori_round;
                break;
            default:
                imageView.setImageResource(R.mipmap.noodles_foreground);
                resID = R.mipmap.noodles_round;
        }

        //Setting the items for RecyclerView
        mItems = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            mItems.add("Item - " + i);
        }

        //Recycler for ListView

        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(mItems,resID, getContext()));

        return v;
    }
}
