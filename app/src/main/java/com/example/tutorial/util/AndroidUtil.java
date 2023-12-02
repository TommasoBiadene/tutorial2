package com.example.tutorial.util;

import android.content.Context;
import android.widget.Toast;

public class AndroidUtil {
    public  static void showtoast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
