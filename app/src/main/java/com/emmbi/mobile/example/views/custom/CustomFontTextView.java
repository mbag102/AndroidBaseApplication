package com.emmbi.mobile.example.views.custom;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.emmbi.mobile.example.Constants;
import com.emmbi.R;

public class CustomFontTextView extends TextView {

    public CustomFontTextView(Context context) {
        super(context);
        String fontPath = "fonts/" + Constants.baseFont;
        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), fontPath);
        this.setTypeface(tf);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        String fontPath = a.getString(R.styleable.CustomFontButton_fontType);
        a.recycle();

        if(fontPath == null) {
            fontPath = Constants.baseFont;
        }

        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), "fonts/" + fontPath);
        this.setTypeface(tf);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        String fontPath = a.getString(R.styleable.CustomFontButton_fontType);
        a.recycle();

        if(fontPath == null) {
            fontPath = Constants.baseFont;
        }

        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), "fonts/" + fontPath);
        this.setTypeface(tf);
    }

}