package com.example.taskmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity implements Observer<Result> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        SplashScreenActivityViewModel splashScreenActivityViewModel = new SplashScreenActivityViewModel();
        LiveData<Result> splashScreenMutableLiveData = splashScreenActivityViewModel.getSplashScreenActivityViewModel();
        splashScreenMutableLiveData.observe(this, this);
    }

    @Override
    public void onChanged(Result result) {
        if (result instanceof Success) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}