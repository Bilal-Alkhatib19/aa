package com.zeeshan.final_p;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.zeeshan.final_p.databinding.CartLayoutBinding;

import java.util.List;

public class Rc_Cart extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Cart_Modle> list;
    CartLayoutBinding binding;

    public Rc_Cart(Context context, List<Cart_Modle> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=CartLayoutBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyView view = (MyView) holder;
        view.binding.textNameCart.setText(list.get(position).getName_cart());
        view.binding.tvPriceCart.setText(list.get(position).getPrice_cart());
        view.binding.tvQuneCart.setText(list.get(position).getQuntity_cart());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private class  MyView extends RecyclerView.ViewHolder{
        CartLayoutBinding binding;
        public MyView(CartLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
