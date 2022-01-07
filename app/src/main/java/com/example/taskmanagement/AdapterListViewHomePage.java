package com.example.taskmanagement;

public class AdapterListViewHomePage {
    private int image;
    private String first_title;
    private String date_time;
    AdapterListViewHomePage(int image, String first_title, String date_time){
        this.image=image;
        this.first_title=first_title;
        this.date_time=date_time;
    }

    int getImage(){
        return image;
    }

    String getFirst_title(){
        return first_title;
    }

    String getDate_time(){
        return date_time;
    }
}
