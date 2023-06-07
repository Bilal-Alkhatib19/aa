package com.zeeshan.final_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//5555
import com.zeeshan.final_p.databinding.ActivitySplashScreenBinding;

public class splash_screen extends AppCompatActivity {
ActivitySplashScreenBinding binding;
Context context = splash_screen.this  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,sign_In_Activity.class);
                startActivity(intent);

            }
        });
    }
}