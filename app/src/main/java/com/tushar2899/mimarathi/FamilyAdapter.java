package com.tushar2899.mimarathi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FamilyAdapter extends ArrayAdapter<Word> {

    public FamilyAdapter(Activity context, ArrayList<Word> numbers) {
        super(context,0,numbers);

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview, parent, false);
        }
        listItemView.setBackgroundColor(listItemView.getResources().getColor(R.color.category_family));
        Word newWord=getItem(position);
        TextView mr=listItemView.findViewById(R.id.mrText);
        mr.setText(newWord.getMarathiTranslation());
        mr.setTextColor(mr.getResources().getColor(R.color.white));
        mr.setTextSize(16);

        TextView eng=listItemView.findViewById(R.id.engText);
        eng.setText(newWord.getDefaultTranslation());
        eng.setTextColor(eng.getResources().getColor(R.color.white));
        eng.setTextSize(16);

        ImageView img=listItemView.findViewById(R.id.dataimg);
        img.setImageResource(newWord.getDataImage());

        return listItemView;
    }

}
