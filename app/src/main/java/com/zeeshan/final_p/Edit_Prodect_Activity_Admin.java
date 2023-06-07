package com.zeeshan.final_p;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.zeeshan.final_p.databinding.ActivityEditProdectAdminBinding;

import java.io.IOException;
import java.util.ArrayList;

public class Edit_Prodect_Activity_Admin extends AppCompatActivity {
    ActivityEditProdectAdminBinding binding;
    DataBases dataBases;
    ArrayList<ProdctModel>list;
    Bitmap imgBitmap;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityEditProdectAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBases=new DataBases(this);

        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getData() != null){
                            Uri adminImg=result.getData().getData();
                            try {
                                // Convert Uri to Bitmap
                                imgBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), adminImg);
                                binding.profileImage.setImageBitmap(imgBitmap);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
        );
        moveProdectData();

        binding.btnSave.setOnClickListener(v->{
            String productPrice="";
            String productQuantity="0";
            try {
                productPrice=binding.edPrice.getText().toString();
                productQuantity=binding.editQuery.getText().toString();

            }catch (NumberFormatException e){
                binding.edPrice.setError("Empty Field");
                binding.editQuery.setError("Empty Field");
            }
            String productName=binding.edName.getText().toString();
            String productDes=binding.editDic.getText().toString();
            if (TextUtils.isEmpty(productName))
                binding.edName.setError("Empty Filed!");
            else if (TextUtils.isEmpty(binding.edPrice.getText().toString()))
                binding.edPrice.setError("Empty Filed!");
            else if (TextUtils.isEmpty(binding.editQuery.getText().toString()))
                binding.editQuery.setError("Empty Filed!");
            else if (TextUtils.isEmpty(productDes))
                binding.editDic.setError("Empty Filed!");
            else {
                ProdctModel product = new ProdctModel(productName,productPrice,productQuantity,productDes,imgBitmap);
                product.setId(getIntent().getIntExtra("productId",-1));
                if (dataBases.updateProduct(product)){
                dataBases.updateProduct(product);
                Log.e("TAB","string"+product);
                setResult(102,new Intent());
                finish();
                }else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });



        binding.profileImage.setOnClickListener(v-> {
            Intent intent1=new Intent(Intent.ACTION_GET_CONTENT);
            intent1.setType("image/*");
            launcher.launch(intent1);
        });
    }

    private void moveProdectData(){
        Intent intent=getIntent();

        int  pos=intent.getIntExtra("pos",-1);
            if (dataBases.getItem()!=null){
        ArrayList<ProdctModel> products=dataBases.getItem();
        ProdctModel p=products.get(pos);
        imgBitmap=p.getImage();
        binding.edName.setText(p.getName());
        binding.edPrice.setText(String.valueOf(p.getPrice()));
        binding.editDic.setText(p.getDic());
        binding.editQuery.setText(String.valueOf(p.getQun()));
        Toast.makeText(this, "id = "+p.getId(), Toast.LENGTH_SHORT).show();}
            else {
                Toast.makeText(this, "Abed Error", Toast.LENGTH_SHORT).show();
            }
    }
}