package com.zeeshan.final_p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan.final_p.databinding.CostomProdactBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ProductViewHolder> {
    private Context context;
    private ArrayList<ProdctModel> list;
    private OnItemClickListener onItemClickListener;

    public Adapter(Context context, ArrayList<ProdctModel> items, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = items;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CostomProdactBinding binding = CostomProdactBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProdctModel product = list.get(position);
        holder.bindData(product);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setFilteredList(ArrayList<ProdctModel> filteredList) {
        this.list = filteredList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, price, dic, qun;
        private ImageView productImg;

        public ProductViewHolder(@NonNull CostomProdactBinding binding) {
            super(binding.getRoot());
            name = binding.tvName;
            price = binding.tvPrice;
            qun = binding.tvQaun;
            dic = binding.tvDic;
            productImg = binding.imageItem;

            itemView.setOnClickListener(this);
        }

        public void bindData(ProdctModel product) {
            name.setText(product.getName());
            dic.setText(product.getDic());
            qun.setText(product.getQun());
            price.setText(product.getPrice());
            productImg.setImageBitmap(product.getImage());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(position);
            }
        }
    }
}
