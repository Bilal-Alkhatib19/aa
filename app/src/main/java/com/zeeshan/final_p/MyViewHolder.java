package com.zeeshan.final_p;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan.final_p.databinding.CostomProdactBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    CostomProdactBinding binding;

    public MyViewHolder(CostomProdactBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }
}