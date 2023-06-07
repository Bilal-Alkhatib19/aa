package com.zeeshan.final_p;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zeeshan.final_p.databinding.ActivityHomeBinding;

import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;

public class Home_Activity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private Context context;
    private ActivityHomeBinding binding;
    private ArrayList<ProdctModel> models;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = Home_Activity.this;

        models = generateRandomData(); // Generate random data for demonstration

        adapter = new Adapter(context, models, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        binding.recylicleView.setLayoutManager(layoutManager);
        binding.recylicleView.setAdapter(adapter);

        binding.HomeCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, cart_Activity.class));
            }
        });

        binding.HomeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, profile_person_Activity.class));
            }
        });

        binding.editOneSearch.clearFocus();
        binding.editOneSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });
    }

    private void fileList(String text) {
        ArrayList<ProdctModel> list = new ArrayList<>();
        for (ProdctModel model : models) {
            if (model.getName().toLowerCase().contains(text.toLowerCase())) {
                list.add(model);
            }
        }
        if (list.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(list);
        }
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(context, ditals_Activty.class);
        intent.putExtra("pos", position);
        Log.e("TAG", "Position: " + position);
        startActivity(intent);
    }


    private ArrayList<ProdctModel> generateRandomData() {
        ArrayList<ProdctModel> data = new ArrayList<>();
        Random random = new Random();

        int[] imageResources = {
                R.drawable.klothes1,
                R.drawable.klothes2,
                R.drawable.klothes3,
                R.drawable.klothes4,
                R.drawable.klothes5,
                R.drawable.klothes6,
                R.drawable.klothes7,
                R.drawable.klothes8,
                R.drawable.klothes9
        };

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(imageResources.length);
            int drawableId = imageResources[randomIndex];
            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), drawableId);

            ProdctModel product = new ProdctModel();
            product.setName("منتج " + (i + 1));
            product.setDic("وصف المنتج " + (i + 1));
            product.setQun(String.valueOf(random.nextInt(100)));
            product.setPrice("$" + random.nextInt(100));
            product.setImage(imageBitmap);

            data.add(product);
        }

        return data;
    }



}
