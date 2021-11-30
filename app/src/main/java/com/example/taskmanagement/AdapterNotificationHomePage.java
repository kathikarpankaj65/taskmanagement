package com.example.taskmanagement;

public class AdapterNotificationHomePage {
    private int image;
    private String title;

    AdapterNotificationHomePage(int image, String title){
        this.image=image;
        this.title=title;
    }

    int getImage(){
        return image;
    }

    String getTitle(){
        return title;
    }

}
