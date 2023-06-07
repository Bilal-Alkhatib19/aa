package com.zeeshan.final_p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan.final_p.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class cart_Activity extends AppCompatActivity {
    ActivityCartBinding binding;
    DataBases dataBases;
    Context context = cart_Activity.this;
    Rc_Cart cart;
    List<Cart_Modle> list = new ArrayList<>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBases = new DataBases(context);


        Cursor cursor = dataBases.getCart();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
            @SuppressLint("Range") String price = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            @SuppressLint("Range") String quntity = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3)));
            @SuppressLint("Range") byte[] image = cursor.getBlob(cursor.getColumnIndex(cursor.getColumnName(4)));
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            list.add(new Cart_Modle(price, name, quntity, bitmap));

        }
        cart = new Rc_Cart(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        binding.recyclerViewCart.setLayoutManager(manager);
        binding.recyclerViewCart.setAdapter(cart);
        binding.floatingButtonList.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                Cursor cursor1 = dataBases.getCart();
                StringBuilder builder = new StringBuilder();
                int total = 0;
                int t = 0;
                String name;
                while (cursor.moveToNext()) {
                    name = cursor1.getColumnName(1);
                    int count = Integer.parseInt(cursor1.getColumnName(3));
                    int price = Integer.parseInt(cursor1.getColumnName(2));
                    total = price * count;
                    t += total;
                    builder.append(name + " || ");


                }

                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setTitle("الفاتورة");
                builder1.setMessage("أسماء المنتجات:" + builder + "\n" + "المجموع:" + t);
                builder1.show();
            }
        });
    }
}






