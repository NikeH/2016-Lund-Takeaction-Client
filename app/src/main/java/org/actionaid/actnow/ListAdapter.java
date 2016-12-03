package org.actionaid.actnow;

// Slightly inspired by https://stackoverflow.com/a/8166802/3605357

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<String> items) {
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

        String p = getItem(position);

        if (p != null) {
            TextView date = (TextView) v.findViewById(R.id.date);
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView body = (TextView) v.findViewById(R.id.body);
            Button button = (Button) v.findViewById(R.id.actButton);

            if (date != null) {
                date.setText(p);
                title.setText(p);
                body.setText(p);
            }
/*
            if (tt2 != null) {
                tt2.setText(p.getCategory().getId());
            }

            if (tt3 != null) {
                tt3.setText(p.getDescription());
            }*/
        }

        return v;
    }

}