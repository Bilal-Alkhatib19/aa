package com.zeeshan.final_p;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
//2222

import com.zeeshan.final_p.databinding.CostomProdact2Binding;

import java.util.List;

public class Rc_adbter extends RecyclerView.Adapter<Rc_adbter.AdminProductViewHolder> {
    List<ProdctModel> models;
    Context context;
    CostomProdact2Binding binding1;
    OnItemEdit onItemEdit;

    public Rc_adbter(List<ProdctModel> models, Context context,   OnItemEdit onItemEdit) {
        this.models = models;
        this.context = context;
        this.onItemEdit=onItemEdit;
    }

    @NonNull
    @Override
    public AdminProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CostomProdact2Binding binding=CostomProdact2Binding.inflate(LayoutInflater.from(context),parent,false);
        return new AdminProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminProductViewHolder holder, int position) {
        ProdctModel p=models.get(position);
        holder.name.setText(p.getName());
        holder.price.setText(p.getPrice());
        holder.quantity.setText(p.getQun());
        holder.image.setImageBitmap(p.getImage());
        holder.editeIv.setOnClickListener( v->{
                 onItemEdit.onItemEdit(holder.getAdapterPosition());
        });

    }
    @Override
    public int getItemCount() {
        return models.size();
    }

    //    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        binding1 =CostomProdact2Binding.inflate(LayoutInflater.from(context),parent,false);
//        return new ViewHolder(binding1);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ViewHolder holder1 = (ViewHolder) holder;
//
//        holder1.binding.imageItem.setImageBitmap(models.get(position).getImage());
//        holder1.binding.tvName.setText(models.get(position).getName());
//        holder1.binding.tvPrice.setText(models.get(position).getPrice());
//        holder1.binding.tvDic.setText(models.get(position).getDic());
//        holder1.binding.tvQaun.setText(models.get(position).getQun());
//
//
//        holder1.binding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder=new AlertDialog.Builder(context);
//                builder.setTitle("اختر خيار");
//                builder.setMessage("انقر اذا كنت تريد الحذف او التعديل");
//                builder.setPositiveButton("حذف", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                builder.setNegativeButton("تعديل", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                builder.show();
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return models.size();
//    }
//    private class ViewHolder extends RecyclerView.ViewHolder{
//       // CostomProdact2Binding binding;
//        public ViewHolder(CostomProdact2Binding binding1) {
//            super(binding1.getRoot());
//            this.binding=binding1;
//        }
//    }
public class AdminProductViewHolder extends RecyclerView.ViewHolder{
    TextView name,price,quantity,dic;
    ImageView image,editeIv;

    public AdminProductViewHolder(@NonNull CostomProdact2Binding binding) {
        super(binding.getRoot());
        this.name=binding.tvName;
        this.price=binding.tvPrice;
        this.image=binding.imageItem;
        this.quantity=binding.tvQaun;
        this.editeIv=binding.imageCartView;
    }
}
}

