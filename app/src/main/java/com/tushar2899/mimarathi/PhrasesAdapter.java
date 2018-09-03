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

public class PhrasesAdapter extends ArrayAdapter<Phrases> {


    public PhrasesAdapter(Activity context, ArrayList<Phrases> numbers) {
        super(context,0,numbers);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.phrase_view, parent, false);
        }
        Phrases newWord=getItem(position);
        TextView mr=listItemView.findViewById(R.id.mrText);
        mr.setText(newWord.getMarathiTranslation());

        TextView eng=listItemView.findViewById(R.id.engText);
        eng.setText(newWord.getDefaultTranslation());

        return listItemView;
    }

}
