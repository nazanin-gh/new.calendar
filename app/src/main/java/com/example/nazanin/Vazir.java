package com.example.nazanin;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class Vazir extends AppCompatTextView {
    public Vazir (Context context){
        super(context);
    }
    public Vazir (Context context, AttributeSet attrs){
        super(context, attrs);
        Typeface vazir = Typeface.createFromAsset(context.getAssets(), "Vazir-Light.ttf");
        this.setTypeface(vazir);
    }
}
