package com.emmbi.mobile.example.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.emmbi.R;

/**
 * Created by mbagliojr on 6/8/15.
 */
public class ImageButton extends RelativeLayout {

    private TextView label;
    private ImageView icon;

    public ImageButton(Context context) {
        super(context);
        init(context, null);
    }

    public ImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.image_button, this);
        this.label = (TextView)findViewById(R.id.button_label);
        this.icon = (ImageView)findViewById(R.id.button_icon);

        if(attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageButton);
            String text = a.getString(R.styleable.ImageButton_button_label);

            this.label.setText(text);
            this.icon.setImageDrawable(a.getDrawable(R.styleable.ImageButton_button_icon));

            a.recycle();
        }

    }


}
