package org.actionaid.actnow;

// Slightly inspired by https://stackoverflow.com/a/8166802/3605357

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ArticleData> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<ArticleData> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.article_item, null);
        }

        ArticleData p = getItem(position);

        if (p != null) {
            TextView date = (TextView) v.findViewById(R.id.date);
            date.setTextColor(Color.rgb(201,24,34));
            date.setTextSize(33);
            TextView title = (TextView) v.findViewById(R.id.title);
            title.setTextColor(Color.BLACK);
            title.setTextSize(20);
            TextView body = (TextView) v.findViewById(R.id.body);

            if (date != null) {
                date.setText(p.getDate());
                title.setText(p.getTitle());
                body.setText(p.getBody());
            }
        }

        return v;
    }

}