package com.example.taskmanagement;

import java.util.ArrayList;

public class Local extends Repository {

    @Override
    Result isUserAvailable(String username, String password) throws CredentialException{
        if (username.equals("pankaj") && password.equals("abc")) {
            return new Success(23445623);
        }
        throw new CredentialException();
    }

    @Override
    Result getCreateList() throws Exception {
        ArrayList<AdapterListViewHomePage> arrayList=new ArrayList<>();
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc, "Chocolate is a food product made from roasted", "2-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc1, "Get Sneakers for Men from top brands like Nike", "6-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc2, "A flower, sometimes known as a bloom or blossom", "8-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc3, "Elephants are the largest land mammals on earth ", "12-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc4, "A frog is any member of a diverse and largely", "21-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc5, "a young boy or girl who is not yet an adult", "25-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc6, "Dinosaurs are a diverse group of reptiles of the clade Dinosaur", "28-Dec 7:30pm"));
        arrayList.add(new AdapterListViewHomePage(R.drawable.abc7, "A cookie is a baked or cooked snack", "27-Dec 7:30pm"));
        return new Success<ArrayList<AdapterListViewHomePage>>(arrayList);
    }

    @Override
    Result getNotificationList() throws Exception {
        ArrayList<AdapterNotificationHomePage> arrayList=new ArrayList<>();
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc, "Chocolate is a food product made from roasted"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc1, "Get Sneakers for Men from top brands like Nike"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc2, "A flower, sometimes known as a bloom or blossom"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc3, "Elephants are the largest land mammals on earth "));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc4, "A frog is any member of a diverse and largely"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc5, "a young boy or girl who is not yet an adult"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc6, "Dinosaurs are a diverse group of reptiles of the clade Dinosaur"));
        arrayList.add(new AdapterNotificationHomePage(R.drawable.abc7, "A cookie is a baked or cooked snack"));
        return new Success<ArrayList<AdapterNotificationHomePage>>(arrayList);
    }

    @Override
    Result setCreateActivityData() throws Exception {
        return new Success<String>("Data added Successfully");
    }

    @Override
    ArrayList<AdapterListViewHomePage> getArrayList() {
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

    @Override
    ArrayList<AdapterNotificationHomePage> getNotificationArrayList() {
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
