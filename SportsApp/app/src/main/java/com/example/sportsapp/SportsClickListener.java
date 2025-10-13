package com.example.sportsapp;

import android.view.View;

@FunctionalInterface
public interface SportsClickListener {
    void onClick(View view, int pos);
}
