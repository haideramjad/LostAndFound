package com.example.haider.networking;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by haider on 5/20/17.
 */

public class CustomViewAdapter extends ArrayAdapter<MessagePojo> {
    Context context;
    Activity activity;
    List<MessagePojo> messages;


    public CustomViewAdapter(@NonNull Context context, @NonNull List<MessagePojo> objects) {
        super(context, 0, objects);
        activity = (Activity) context;
        this.context = context;
        this.messages = objects;
    }

    public static class ViewHolder {
        TextView title;
        ImageView product;
        TextView message;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        MessagePojo messagePojo = getItem(position);

        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(activity);
        convertView = inflater.inflate(R.layout.customlistiewlayout, parent, false);
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);
        viewHolder.product = (ImageView) convertView.findViewById(R.id.img);
        viewHolder.message = (TextView) convertView.findViewById(R.id.messagedesc);

        viewHolder.title.setText(messages.get(position).getTitle());
        viewHolder.message.setText(messages.get(position).getProduct());
        viewHolder.product.setImageResource(R.drawable.ic_menu_gallery);

        return convertView;
    }
}
