package com.tushar2899.mimarathi;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {
    private ArrayList<Word> colors;
    private MediaPlayer media;

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_colors, container,false);
        colors=new ArrayList<Word>();
        colors.add(new Word(R.drawable.color_red,"Red","लाल (Lāla)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_green,"Green","हिरवा (Hiravā)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_brown,"Brown","तपकिरी (तपकिरी)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_gray,"Gray", "राखाडी (Rākhāḍī)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_black,"Black" ,"काळा (Kāḷā)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_white,"White","पांढरा (Pāṇḍharā )",R.raw.number_one));
        colors.add(new Word(R.drawable.color_dusty_yellow,"Dusty Yellow","धुळीचा पिवळा (Dhuḷīcā pivaḷā)",R.raw.number_one));
        colors.add(new Word(R.drawable.color_mustard_yellow,"Mustard Yellow","मोहरी पिवळा (Mōharī pivaḷā )",R.raw.number_one));
        colors.add(new Word(R.color.orange,"Orange","नारिंगी (Nāriṅgī)",R.raw.number_one));
        colors.add(new Word(R.color.pink,"Pink","गुलाबी (Gulābī )",R.raw.number_one));
        colors.add(new Word(R.color.blue,"Blue","निळा (Niḷā)",R.raw.number_one));

        ColorsAdapter itemsAdapter = new ColorsAdapter(getActivity(), colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list_colors);


        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=colors.get(position);
                media = MediaPlayer.create(getActivity(), word.getDataAudio());
                media.start();

                Toast.makeText(getActivity(),word.getMarathiTranslation().toString(),Toast.LENGTH_SHORT).show();
                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        media.release();


                    }
                });
            }
        });
        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
        if(media!=null){
            media.release();
        }
    }
}
