package com.example.du_an_1_android_test.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_1_android_test.MainActivity;
import com.example.du_an_1_android_test.Model.Food;
import com.example.du_an_1_android_test.R;
import com.example.du_an_1_android_test.ShowdetailActivity;

import java.util.List;

public class recommended_adapter extends RecyclerView.Adapter<recommended_adapter.viewHolder> {
    private Context context ;
    private List<Food> list ;


    public recommended_adapter(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended , parent , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageanh.setImageResource(list.get(position).getImge());
        holder.imagebutton.setImageResource(list.get(position).getResource_image());
        holder.txttitle.setText(list.get(position).getTitle());
        holder.txtmoney.setText(String.valueOf(list.get(position).getMoney()));
        holder.imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:

                        Intent intent = new Intent(context , ShowdetailActivity.class);
                        context.startActivity(intent);
                        Intent intent1 = new Intent(context , ShowdetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putDouble("money_piza1" , list.get(position).getMoney());
                        intent1.putExtra("dulieu",bundle);
                        context.startActivity(intent1);
                        break;
                    case 1:
                        Toast.makeText(context, "anh1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context, "anh2", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(context, "khog co ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txttitle  , txtmoney;
        ImageView imageanh , imagebutton;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.txttitle);
            txtmoney = itemView.findViewById(R.id.txtmoney);
            imageanh = itemView.findViewById(R.id.image_recommended);
            imagebutton = itemView.findViewById(R.id.float_add);


        }
    }
}
