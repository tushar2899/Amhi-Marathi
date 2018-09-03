package com.tushar2899.mimarathi;
public class Phrases {
    private String mDefaultTranslation;
    private String mMarathiTranslation;
    private int mDataAudio;
    public Phrases(String defaultTranslation, String marathiTranslation, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMarathiTranslation = marathiTranslation;
        mDataAudio=audio;

    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMarathiTranslation() {
        return mMarathiTranslation;
    }

    public int getDataAudio(){
        return mDataAudio;
    }

}

