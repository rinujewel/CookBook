package com.cook.cookingassistant.Activity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cook.cookingassistant.Adapter.RecipeListAdapter;
import com.cook.cookingassistant.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView iv_NonVeg;
    RecyclerView rv_recipesList;
    RecipeListAdapter recipeListAdapter;
    SearchView searchView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // rv_recipesList = root.findViewById(R.id.rv_recipesList);
        searchView=root.findViewById(R.id.searchView);
        searchView.requestFocus();

        // final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });
      /*  recipeListAdapter=new RecipeListAdapter(getActivity());
        rv_recipesList.setAdapter(recipeListAdapter);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        rv_recipesList.setLayoutManager(layoutManager);*/
        return root;
    }
}