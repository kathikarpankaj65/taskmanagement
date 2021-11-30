    package com.example.taskmanagement;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class HomePageAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> arrayList;

    public HomePageAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

}
