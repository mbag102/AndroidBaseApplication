package com.emmbi.mobile.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.emmbi.R;
import com.emmbi.mobile.example.model.view.IconLabel;

import java.util.List;

/**
 * Created by mbagliojr on 2/11/15.
 */
public class IconLabelViewListAdapter extends ArrayAdapter<IconLabel> {

    Context mContext;
    int layoutResourceId;
    List<IconLabel> data = null;

    public IconLabelViewListAdapter(Context mContext, int layoutResourceId, List<IconLabel> data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    /*
     * The convertView argument is essentially a "ScrapView" as described is Lucas post
     * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
     * It will have a non-null value when ListView is asking you recycle the row layout.
     * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
     */
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        IconLabel objectItem = data.get(position);

        TextView imageView = (TextView) convertView.findViewById(R.id.icon_label_icon);
        imageView.setText(mContext.getString(objectItem.getIcon()));

        TextView textView = (TextView) convertView.findViewById(R.id.icon_label_label);
        textView.setText(objectItem.getLabel());

        return convertView;

    }

}
