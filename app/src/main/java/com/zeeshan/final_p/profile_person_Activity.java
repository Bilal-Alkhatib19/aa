package com.zeeshan.final_p;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
// 1111
import com.zeeshan.final_p.databinding.ActivityProfilePersonBinding;

public class profile_person_Activity extends AppCompatActivity {
Context context=profile_person_Activity.this;
ActivityProfilePersonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfilePersonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();

        binding.faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });

        binding.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0595151668"));
                startActivity(intent);
            }
        });


        binding.ModifyProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent1 = new Intent(context,Confirm_login.class);
            startActivity(intent1);

        }
    });

   binding.logout.setOnClickListener(new View.OnClickListener() {
       @Override

       public void onClick(View v) {
           finish();
       }
   });






    }
}