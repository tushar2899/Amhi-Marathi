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


public class FamilyFragments extends Fragment {

    private ArrayList<Word> numbers;
    private MediaPlayer media;
    public FamilyFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_family, container, false);
        numbers =new ArrayList<Word>();
        numbers.add(new Word(R.drawable.family_father,"Father","वडील (Vaḍīla)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_mother,"Mother","आई (Ā'ī)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_son,"Son","मुलगा (MulagA)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_daughter,"Daughter", "मुलगी (Mulagī)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_older_brother,"Older Brother","मोठा भाऊ (Mōṭhā bhā'ū)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_younger_brother,"Younger Brother","धाकटा भाऊ (Dhākaṭā bhā'ū )",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_older_sister,"Older Sister","मोठी बहीण (Mōṭhī bahīṇa)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_younger_sister,"Younger Sister","धाकटी बहीण (Dhākaṭī bahīṇa )",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_grandmother,"Grandmother","आजी (Ājī)",R.raw.number_one));
        numbers.add(new Word(R.drawable.family_grandfather,"Grandfather","आजोबा (Ājōbā )",R.raw.number_one));

        FamilyAdapter itemsAdapter = new FamilyAdapter(getActivity(), numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.list_family);
        listView.setBackgroundColor(listView.getResources().getColor(R.color.green));

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=numbers.get(position);
                media=MediaPlayer.create(getActivity(), word.getDataAudio());
                media.start();
                //ref.setImageResource(R.drawable.pause);
                Toast.makeText(getActivity(),word.getMarathiTranslation().toString(),Toast.LENGTH_LONG).show();
                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        media.release();
                        //ref.setImageResource(R.drawable.resume);
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
