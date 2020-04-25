package com.example.a1adda4u.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import com.example.a1adda4u.R;
import com.example.a1adda4u.ui.cards.cardViewAdapter;
import com.example.a1adda4u.ui.transitions.DetailsTransition;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private static final String TAG = "HomeFragment";
    private ArrayList<Integer> mImage= new ArrayList<>();

    private NavController controller;
    private  View root;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        //Shared Element Transition
        //setSharedElementEnterTransition(new DetailsTransition());
        //setSharedElementReturnTransition(new DetailsTransition());

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.home_main_f, container, false);

        controller = NavHostFragment.findNavController(this);

        for(int i=0;i<10;i++) {
            mImage.add(R.mipmap.offers_foreground);
        }

        //Recycler for CardView
        RecyclerView cardView = root.findViewById(R.id.recyclerViewCards);

        cardView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        cardView.setAdapter(new cardViewAdapter(mImage));


        root.findViewById(R.id.card1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFragment(0);
            }
        });

        root.findViewById(R.id.card2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFragment(1);
            }
        });

        root.findViewById(R.id.card3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFragment(2);
            }
        });

        root.findViewById(R.id.card4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFragment(3);
            }
        });

        return root;
    }

    private void newFragment(int cardNo)
    {
        Bundle items = new Bundle();
        items.putInt("items",cardNo);
        FragmentNavigator.Extras extras; //= new FragmentNavigator.Extras.Builder().addSharedElement(root.findViewById(R.id.canteenImage),"canteenImage").build();;
        switch (cardNo)
        {
            case 0:
                 extras = new FragmentNavigator.Extras.Builder().addSharedElement(root.findViewById(R.id.canteenImage0),"canteenImage").build();
                break;
            case 1:
                extras = new FragmentNavigator.Extras.Builder().addSharedElement(root.findViewById(R.id.canteenImage1),"canteenImage").build();
                break;
            case 2:
                extras = new FragmentNavigator.Extras.Builder().addSharedElement(root.findViewById(R.id.canteenImage2),"canteenImage").build();
                break;
            default:
                extras = new FragmentNavigator.Extras.Builder().addSharedElement(root.findViewById(R.id.canteenImage3),"canteenImage").build();
                break;
        }
        controller.navigate(R.id.action_home_to_details,items,null,extras);
    }
}