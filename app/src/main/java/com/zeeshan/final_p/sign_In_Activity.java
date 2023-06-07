package com.zeeshan.final_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.zeeshan.final_p.databinding.ActivitySignInBinding;

public class sign_In_Activity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private DB_SIGNIN db_signin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Context context = sign_In_Activity.this;
        db_signin = new DB_SIGNIN(context);
        sharedPreferences = getSharedPreferences("saveLogin", MODE_PRIVATE);

        boolean isLogin = sharedPreferences.getBoolean("login", false);
        String name = sharedPreferences.getString("name", "");

        if (isLogin) {
            Intent intent = new Intent(context, Home_Activity.class);
            intent.putExtra("name", name);
            startActivity(intent);
            finish();
        }

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Confirm_login.class);
                startActivity(intent);
            }
        });

        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.editName.getText().toString().trim();
                String password = binding.editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(sign_In_Activity.this, "يرجى إدخال اسم المستخدم وكلمة المرور", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.equals("iamadmin") && password.equals("iamadmin")) {
                    Intent intent = new Intent(context, Rc_admin.class);
                    startActivity(intent);
                    finish();
                } else if (db_signin.checkUsername(username, password)) {
                    Intent intent = new Intent(context, Home_Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent1 = new Intent(context, Home_Activity.class);
                    startActivity(intent1);
                }
            }
        });

        binding.chekeBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("login", isChecked);
                editor.putString("name", binding.editName.getText().toString().trim());
                editor.apply();
            }
        });
    }
}
