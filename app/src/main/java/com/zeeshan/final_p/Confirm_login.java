package com.zeeshan.final_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.zeeshan.final_p.databinding.ActivityConfirmLoginBinding;

public class Confirm_login extends AppCompatActivity {
    ActivityConfirmLoginBinding binding;
     DB_SIGNIN db_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConfirmLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db_signin=new DB_SIGNIN(this);

        binding.buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =binding.confirmName.getText().toString();
                String password =binding.confirmPassword.getText().toString();
                String Email =binding.confirmEmail.getText().toString();
                String phonNumbers =binding.confirmPhonNumber.getText().toString();

                UserSignIn userSignIn = new UserSignIn(name,password);

                //if (db_signin.insatrData(userSignIn)){
                    Intent intent=new Intent(Confirm_login.this,Home_Activity.class);
                    startActivity(intent);
                //}else Toast.makeText(Confirm_login.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}