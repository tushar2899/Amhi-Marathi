package com.tushar2899.mimarathi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter{
    public PagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumberFragment();
        } else if (position == 1){
            return new FamilyFragments();
        } else if(position ==2){
            return new ColorsFragment();
        }
        else{
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Numbers";
        }
        else if (position == 1)
        {
            title = "Family";
        }
        else if (position == 2)
        {
            title = "Colours";
        }
        else{
            title="Phrases";
        }
        return title;
    }
}
