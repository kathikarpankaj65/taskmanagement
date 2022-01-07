package com.example.taskmanagement;

public class MainActivityObservable<P> {
    MainActivityObserver<P> mainActivityObserver;
    void setMainActivityObserver(MainActivityObserver<P> mainActivityObserver) {
        this.mainActivityObserver = mainActivityObserver;
    }
    void setValue(P p){
        mainActivityObserver.onChange(p);
    }
}
