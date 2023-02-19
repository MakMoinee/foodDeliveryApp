package com.fooddelivery.customer.interfaces;

public interface SimpleListener {
    default void onSuccess() {
        /**
         * Default implementation
         */
    }

    void onError(Exception e);
}
