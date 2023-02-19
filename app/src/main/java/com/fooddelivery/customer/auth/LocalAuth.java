package com.fooddelivery.customer.auth;

import android.content.Context;

import com.fooddelivery.customer.interfaces.SimpleListener;
import com.fooddelivery.customer.models.Users;
import com.google.firebase.auth.FirebaseAuth;

public class LocalAuth {
    Context context;
    FirebaseAuth auth;

    public LocalAuth(Context context) {
        this.context = context;
        auth = FirebaseAuth.getInstance();
    }

    public void login(Users users, SimpleListener listener) {
        auth.signInWithEmailAndPassword(users.getEmail(), users.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        listener.onSuccess();
                    } else {
                        listener.onError(new Exception("something happen"));
                    }
                })
                .addOnFailureListener(e -> listener.onError(e));
    }
}
