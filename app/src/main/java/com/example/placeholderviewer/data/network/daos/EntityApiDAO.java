package com.example.placeholderviewer.data.network.daos;

import android.content.Context;

import java.util.List;

public interface EntityApiDAO<T> {

    List<T> get(Context context);

    T get(Context context, Long idItem);

}
