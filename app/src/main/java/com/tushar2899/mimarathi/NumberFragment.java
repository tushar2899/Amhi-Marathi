package com.tushar2899.mimarathi;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumberFragment extends Fragment {
    private MediaPlayer media;

    private ArrayList<Word> numbers;
    public NumberFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_number, container, false);
        numbers=new ArrayList<Word>();
        numbers.add(new Word(R.drawable.number_one,"One","एक (ek)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_two,"Two","दोन (don)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_three,"Three","तीन (tIn)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_four,"Four", "चार (chAr)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_five,"Five","पाच (pAch)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_six,"Six","सहा (sahA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_seven,"Seven","सात (sAt)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_eight,"Eight","आठ (ATh )",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_nine,"Nine","नऊ (naU)",R.raw.number_one));
        numbers.add(new Word(R.drawable.number_ten,"Ten","दहा (dahA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_evelven,"Eleven","अकरा (akarA)",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_twelve,"Twelve","बारा (bArA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_thirteen,"Thirteen","तेरा (terA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_fourteen,"Fourteen","चौदा (chaudA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_fifteen,"Fifteen"," पंधरा (paMdharA)",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_sixteen,"Sixteen","सोळा (soLA)",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_seventeen,"Seventeen","सतरा (satarA )",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_eighteen,"Eighteen","अठरा (aTharA)",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_ninteen,"Nineteen","एकोणीस (ekoNIs)",R.raw.number_one));
        numbers.add(new Word(R.drawable.numbers_twenty,"Twenty","वीस (vIs)",R.raw.number_one));


        final WordAdapter itemsAdapter = new WordAdapter(getActivity(), numbers);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=numbers.get(position);
                media=MediaPlayer.create(getActivity(), word.getDataAudio());
                media.start();
                //ref.setImageResource(R.drawable.pause);
                Toast.makeText(getActivity(),word.getMarathiTranslation().toString(),Toast.LENGTH_SHORT).show();
                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        media.release();
                        // ref.setImageResource(R.drawable.resume);
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
