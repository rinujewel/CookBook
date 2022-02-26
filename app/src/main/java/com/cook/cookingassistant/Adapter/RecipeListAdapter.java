package com.cook.cookingassistant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cook.cookingassistant.Activity.ProcedureActivity;
import com.cook.cookingassistant.R;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyHolder> {
    Context context;

    public RecipeListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        //View view = layoutInflater.inflate(R.layout.row_recipes_list, viewGroup, false);
        View listItem = layoutInflater.inflate(R.layout.row_recipes_list, viewGroup, false);
        MyHolder viewHolder = new MyHolder(listItem);
        return (viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.ll_row_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProcedureActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_row_recipe;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ll_row_recipe = itemView.findViewById(R.id.row_recipeLayout);
        }
    }
}
