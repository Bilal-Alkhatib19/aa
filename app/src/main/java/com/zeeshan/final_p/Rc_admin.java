package com.zeeshan.final_p;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//3333
import com.zeeshan.final_p.databinding.ActivityRcAdminBinding;

import java.util.ArrayList;
import java.util.List;

public class Rc_admin extends AppCompatActivity implements OnItemEdit {

    ActivityRcAdminBinding binding;
    Context context = Rc_admin.this;
    List<ProdctModel> models;

    Rc_adbter rcAdbter;
    DataBases dataBases;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRcAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBases = new DataBases(context);

        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==101){
                            readProducts();
                        }else if (result.getResultCode()==102){
                            readProducts();
                        }
                    }
                }
        );

        if (dataBases.getItem()!=null){
            models=dataBases.getItem();
            rcAdbter = new Rc_adbter(models, context,this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            binding.rcAdmin.setAdapter(rcAdbter);
            binding.rcAdmin.setLayoutManager(layoutManager);

        }else Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(context,Home_Activity.class));
            }
        });




        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminAdd.class);
                startActivity(intent);
            }
        });

    }
//هذا الانترفيس لنقل البيانات
    @Override
    public void onItemEdit(int pos) {
        int id=models.get(pos).getId();
        Intent intent= new Intent(context,Edit_Prodect_Activity_Admin.class);
                intent.putExtra("pos",pos);
                intent.putExtra("productId",id);
                 launcher.launch(intent);


    }
//للتعديل edit
    private void readProducts(){
        if (!(dataBases.getItem()==null)){
            models=dataBases.getItem();
            rcAdbter=new Rc_adbter(models, context,this);
            binding.rcAdmin.setAdapter(rcAdbter);
            binding.rcAdmin.setLayoutManager(new LinearLayoutManager(context));
        }
        else Toast.makeText(context, "There are no products added", Toast.LENGTH_SHORT).show();
    }
}