package com.zeeshan.final_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zeeshan.final_p.databinding.ActivityDitalsActivtyBinding;

public class ditals_Activty extends AppCompatActivity {
    ActivityDitalsActivtyBinding binding;
    DataBases dataBases;
    int count = 0;
    Context context = ditals_Activty.this;
    ProdctModel product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDitalsActivtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBases = new DataBases(context);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos", 0);
        if (dataBases.getItem() != null) {
            product = dataBases.getItem().get(pos);
            binding.imageViewDetalis.setImageBitmap(product.getImage());
            binding.priceDetalis.setText(product.getPrice());
            binding.nameDetalis.setText(product.getName());
            binding.distributionDetalis.setText(product.getDic());
            binding.quantityDetalis.setText(product.getQun());
        }

        binding.distributionDetalisPluss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count >= Integer.parseInt(product.getQun())) {
                    Toast.makeText(context, "The entered value is greater than the existing value", Toast.LENGTH_SHORT).show();
                } else {
                    count++;
                    binding.distributionDetalisNum.setText(String.valueOf(count));
                }
            }
        });

        binding.distributionDetalisMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if (count < 0) {
                    count = 0;
                }
                binding.distributionDetalisNum.setText(String.valueOf(count));
            }
        });

        binding.bpttonShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataBases.insertCart(new Cart_Modle(product.getPrice(), product.getName(), String.valueOf(count), product.getImage()))) {
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
