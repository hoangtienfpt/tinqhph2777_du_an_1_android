package com.example.du_an_1_android_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.du_an_1_android_test.Model.Category;
import com.example.du_an_1_android_test.R;

import java.util.List;

public class Emptyadapter extends RecyclerView.Adapter<Emptyadapter.viewHolder>{
private List<Category> list ;
private Context context;

public Emptyadapter(List<Category> list, Context context) {
        this.list = list;
        this.context = context;
        }

@NonNull
@Override
public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category , parent , false);
        return new viewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        }

@Override
public int getItemCount() {
        return list.size();
        }

public class viewHolder extends RecyclerView.ViewHolder {
    ImageView imageView ;
    TextView name;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img_cat1);
        name  =itemView.findViewById(R.id.txtcat1);
    }
}
}

