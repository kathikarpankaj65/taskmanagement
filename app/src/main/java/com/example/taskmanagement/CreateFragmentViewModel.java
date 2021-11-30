package com.example.taskmanagement;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class CreateFragmentViewModel extends ViewModel {
    ArrayList<AdapterListViewHomePage> getCreateList(){
        ArrayList<AdapterListViewHomePage> arrayList=new ArrayList<>();
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc, "Chocolate is a food product made from roasted", "2-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc1, "Get Sneakers for Men from top brands like Nike", "6-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc2, "A flower, sometimes known as a bloom or blossom", "8-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc3, "Elephants are the largest land mammals on earth ", "12-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc4, "A frog is any member of a diverse and largely", "21-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc5, "a young boy or girl who is not yet an adult", "25-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc6, "Dinosaurs are a diverse group of reptiles of the clade Dinosaur", "28-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc7, "A cookie is a baked or cooked snack", "27-Dec 7:30pm"));
        return arrayList;
    }
}