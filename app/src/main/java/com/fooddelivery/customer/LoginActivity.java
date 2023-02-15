package com.fooddelivery.customer;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fooddelivery.customer.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();
    }

    private void initListeners() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editEmail.getText().toString();
                String password = binding.editPassword.getText().toString();
                if (email.equals("") || password.equals("")) {
                    binding.editEmail.setError("empty email");
                    binding.editPassword.setError("empty password");
                    Toast.makeText(LoginActivity.this, "Please Don't Leave Empty Fields", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }
}
