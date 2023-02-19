package com.fooddelivery.customer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fooddelivery.customer.auth.LocalAuth;
import com.fooddelivery.customer.databinding.ActivityLoginBinding;
import com.fooddelivery.customer.interfaces.SimpleListener;
import com.fooddelivery.customer.models.Users;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    LocalAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
        initListeners();
    }

    private void initialize() {
        auth = new LocalAuth(LoginActivity.this);
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
                    Users users = new Users();
                    users.setEmail(email);
                    users.setPassword(password);
                    auth.login(users, new SimpleListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(Exception e) {
                            if (e != null) {
                                Log.e("ERROR_LOGIN", e.getMessage());
                            }
                            Toast.makeText(LoginActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
