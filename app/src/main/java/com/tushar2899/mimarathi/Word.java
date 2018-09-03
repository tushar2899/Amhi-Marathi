package com.tushar2899.mimarathi;

import android.media.Image;

public class Word {
    private String mDefaultTranslation;
    private int mDataImg;
    private int mDataAudio;

    private String mMarathiTranslation;
    public Word(int img, String defaultTranslation, String marathiTranslation, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMarathiTranslation = marathiTranslation;
        mDataImg = img;
        mDataAudio = audio;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMarathiTranslation() {
        return mMarathiTranslation;
    }

    public int getDataImage(){
        return mDataImg;
    }
    public int getDataAudio(){
        return mDataAudio;
    }

}

