package com.zeeshan.final_p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan.final_p.databinding.CostomProdactBinding;

import java.util.ArrayList;
import java.util.List;

public class Home_Adapter_ReciclerView extends RecyclerView.Adapter<Home_Adapter_ReciclerView.ViewHolder> {

    Context context;
    List<Home_Rcycler_view> list;
    CostomProdactBinding binding;



    public Home_Adapter_ReciclerView(Context context, List<Home_Rcycler_view> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CostomProdactBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        byte[] image = list.get(position).getIamge();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder1.binding.imageItem.setImageBitmap(bitmap);
        holder1.binding.tvName.setText(list.get(position).getName());
        holder1.binding.tvQaun.setText(list.get(position).getQaun());
        holder1.binding.tvPrice.setText(list.get(position).getPrice());
        holder1.binding.tvDic.setText(list.get(position).getDic());

        holder1.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "SJAnkjs,d", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CostomProdactBinding binding;

        public ViewHolder(CostomProdactBinding binding) {

            super(binding.getRoot());
            this.binding = binding;


        }
    }

}

