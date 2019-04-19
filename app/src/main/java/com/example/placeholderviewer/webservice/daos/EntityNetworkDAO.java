package com.example.placeholderviewer.webservice.daos;

import android.content.Context;

import java.util.List;

public interface EntityNetworkDAO<T> {

    List<T> get(Context context);

    T get(Context context, Long idItem);

}
