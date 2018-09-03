package com.tushar2899.mimarathi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsAdapter extends ArrayAdapter<Word> {


    public ColorsAdapter(Activity context, ArrayList<Word> numbers) {
        super(context,0,numbers);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.colors_view, parent, false);
        }
        Word newWord=getItem(position);
        TextView mr=listItemView.findViewById(R.id.mrText1);
        mr.setTextColor(mr.getResources().getColor(R.color.white));
        mr.setText(newWord.getMarathiTranslation());

        TextView eng=listItemView.findViewById(R.id.engText1);
        eng.setTextColor(eng.getResources().getColor(R.color.white));
        eng.setText(newWord.getDefaultTranslation());

        ImageView img=listItemView.findViewById(R.id.col);
        img.setBackgroundResource(newWord.getDataImage());

        return listItemView;
    }

}
