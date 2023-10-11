package com.example.babygrowthmonitor;

import androidx.annotation.NonNull;

public class Item {

    String title;

    Item(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return title ;
    }
}
