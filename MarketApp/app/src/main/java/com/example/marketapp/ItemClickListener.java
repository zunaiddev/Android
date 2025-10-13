package com.example.marketapp;

import android.view.View;

@FunctionalInterface
public interface ItemClickListener {
    void onClick(View view, int pos);
}
