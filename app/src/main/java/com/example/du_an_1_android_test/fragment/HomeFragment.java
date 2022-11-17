package com.example.du_an_1_android_test.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.example.du_an_1_android_test.Adapter.Emptyadapter;
import com.example.du_an_1_android_test.Adapter.recommended_adapter;
import com.example.du_an_1_android_test.Model.Category;
import com.example.du_an_1_android_test.Model.Food;
import com.example.du_an_1_android_test.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView  , recyclerView2;
    List<Category> list;
    recommended_adapter adapter ;
    List<Food> foodList;
    BottomNavigationView view ;
    Emptyadapter emptyadapter ;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView2 = view.findViewById(R.id.rcv_popular);
        recyclerView =view.findViewById(R.id.View);
        list = new ArrayList<>();
        list.add(new Category(R.drawable.cat_1 , "Pizza"));
        list.add(new Category(R.drawable.cat_2 , "Burger"));
        list.add(new Category(R.drawable.cat_3 , "Hotdog"));
        list.add(new Category(R.drawable.cat_4 , "Drink"));
        list.add(new Category(R.drawable.cat_5 , "Donut"));
        emptyadapter = new Emptyadapter(list , getActivity());

        recyclerView.setAdapter(emptyadapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        listRecommended();

        return view;
    }
    public void listRecommended(){
        foodList = new ArrayList<>();
        foodList.add(new Food(R.drawable.pizza1 , "pepeperoni pizza" , 13.0 , R.drawable.plus_circle));
        foodList.add(new Food(R.drawable.burger , "cheese burger" , 15.2 , R.drawable.plus_circle));
        foodList.add(new Food(R.drawable.pizza3 , "vegetable pizza" , 11.0 , R.drawable.plus_circle));
        adapter = new recommended_adapter(getActivity() , foodList);
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.HORIZONTAL , false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setNestedScrollingEnabled(false);





    }
}