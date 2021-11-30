package com.example.taskmanagement;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NotificationFragmentViewModel extends ViewModel {
    ArrayList<AdapterNotificationHomePage> getNotification(){
        ArrayList<AdapterNotificationHomePage> arrayList=new ArrayList<>();
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc, "Chocolate is a food product made from roasted"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc1, "Get Sneakers for Men from top brands like Nike"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc2, "A flower, sometimes known as a bloom or blossom"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc3, "Elephants are the largest land mammals on earth "));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc4, "A frog is any member of a diverse and largely"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc5, "a young boy or girl who is not yet an adult"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc6, "Dinosaurs are a diverse group of reptiles of the clade Dinosaur"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc7, "A cookie is a baked or cooked snack"));
        return arrayList;
    }
}
