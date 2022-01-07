package com.example.taskmanagement;

public class SplashScreenObservable<P> {
    SplashScreenObserver<P> splashScreenObserver;
    void setSplashScreenObserver(SplashScreenObserver<P> splashScreenObserver) {
        this.splashScreenObserver = splashScreenObserver;
    }
    void setValue(P p) {
        splashScreenObserver.onChange(p);
    }
}
