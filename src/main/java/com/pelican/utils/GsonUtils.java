package com.pelican.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Artem
 * Date: 3/9/14 6:02 PM.
 */
public class GsonUtils {
    public static final Gson gson;

    static {
        gson = new GsonBuilder().create();
    }
}
