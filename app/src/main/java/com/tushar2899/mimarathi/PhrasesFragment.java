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
public class PhrasesFragment extends Fragment {
    private ArrayList<Phrases> phrases;
    private MediaPlayer media;

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.activity_phrases,container,false);
        phrases= new ArrayList<Phrases>();
        phrases.add(new Phrases("What is your name?","तुझं नाव काय आहे? (Tujhaṁ nāva kāya āhē?)",R.raw.number_one));
        phrases.add(new Phrases("My name is andro","माझे नाव अँड्रॉ आहे (Mājhē nāva am̐ḍrŏ āhē)",R.raw.number_one));
        phrases.add(new Phrases("Where are you going?","आपण कोठे जात आहात? (Āpaṇa kōṭhē jāta āhāta?)",R.raw.number_one));
        phrases.add(new Phrases("How are you feeling?", "तुला कसे वाटत आहे? (Tulā kasē vāṭata āhē?)",R.raw.number_one));
        phrases.add(new Phrases("I’m feeling good.","मला बरं वाटतेय. (Malā baraṁ vāṭatēya.)",R.raw.number_one));
        phrases.add(new Phrases("Are you coming?","तू येत आहेस का? (Tū yēta āhēsa kā?)",R.raw.number_one));
        phrases.add(new Phrases("Yes, I’m coming.","होय, मी येत आहे (Hōya, mī yēta āhē)",R.raw.number_one));
        phrases.add(new Phrases("I’m coming.","मी येतोय. (Mī yētōya.",R.raw.number_one));
        phrases.add(new Phrases("Let’s go.","चल जाऊया. (Cala jā'ūyā.)",R.raw.number_one));
        phrases.add(new Phrases("Come here.","इकडे ये. (Ikaḍē yē.)",R.raw.number_one));

        PhrasesAdapter itemsAdapter = new PhrasesAdapter(getActivity(), phrases);
        final ListView listView = (ListView) rootView.findViewById(R.id.list_phrases);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phrases phr=phrases.get(position);
                media= MediaPlayer.create(getActivity(),phr.getDataAudio());
                media.start();
                Toast.makeText(getActivity(),phr.getMarathiTranslation().toString(),Toast.LENGTH_SHORT).show();
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
