package com.emmbi.mobile.example.views.custom;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.emmbi.mobile.example.Constants;
import com.emmbi.R;

public class CustomFontCheckboxView extends CheckBox {

    public CustomFontCheckboxView(Context context) {
        super(context);
        String fontPath = "fonts/" + Constants.baseFont;
        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), fontPath);
        this.setTypeface(tf);
        final float scale = this.getResources().getDisplayMetrics().density;
        this.setPadding(this.getPaddingLeft() + (int)(13.0f * scale + 0.5f),
                this.getPaddingTop(),
                this.getPaddingRight(),
                this.getPaddingBottom());
    }

    public CustomFontCheckboxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontCheckboxView);
        String fontPath = a.getString(R.styleable.CustomFontButton_fontType);
        a.recycle();

        if(fontPath == null) {
            fontPath = Constants.baseFont;
        }

        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), "fonts/" + fontPath);
        this.setTypeface(tf);
        final float scale = this.getResources().getDisplayMetrics().density;
        this.setPadding(this.getPaddingLeft() + (int)(10.0f * scale + 0.5f),
                this.getPaddingTop(),
                this.getPaddingRight(),
                this.getPaddingBottom());
    }

    public CustomFontCheckboxView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontCheckboxView);
        String fontPath = a.getString(R.styleable.CustomFontButton_fontType);
        a.recycle();

        if(fontPath == null) {
            fontPath = Constants.baseFont;
        }

        Typeface tf = Typeface.createFromAsset(this.getResources().getAssets(), "fonts/" + fontPath);
        this.setTypeface(tf);

        final float scale = this.getResources().getDisplayMetrics().density;
        this.setPadding(this.getPaddingLeft() + (int)(10.0f * scale + 0.5f),
                this.getPaddingTop(),
                this.getPaddingRight(),
                this.getPaddingBottom());
    }

}