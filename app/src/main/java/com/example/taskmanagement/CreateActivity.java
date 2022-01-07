package com.example.taskmanagement;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener, Observer<Result> {

    EditText editText_date, editText_time, editText_project, editText_tasks;
    MainActivityObservable<Result> createMainActivityObservable;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_create);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_create_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button button = findViewById(R.id.activity_create_button);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        editText_date = findViewById(R.id.edittext_date);
        String s = editText_date.getText().toString().trim();
        editText_time = findViewById(R.id.edittext_time);
        String s1 = editText_time.getText().toString().trim();
        editText_project = findViewById(R.id.edittext_project);
        String s2 = editText_project.getText().toString().trim();
        editText_tasks = findViewById(R.id.edittext_tasks);
        String s3 = editText_tasks.getText().toString().trim();
        CreateActivityViewModel createActivityViewModel = new CreateActivityViewModel();
        LiveData<Result> liveData = createActivityViewModel.getCreateActivityViewModel(s, s1, s2, s3);
        liveData.observe(this, this);
    }

    @Override
    public void onChanged(Result result) {
        if (result instanceof Loading) {
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
        }
        if (result instanceof Success) {
            progressDialog.dismiss();
            Success<String> success = (Success) result;
            Toast.makeText(this, success.getT(), Toast.LENGTH_SHORT).show();
        }
        else if (result instanceof Error) {
            progressDialog.dismiss();
            Error error = (Error) result;
            if (error.getException() instanceof DateException) {
                DateException dateException = (DateException) error.getException();
                if (dateException.getMessage().equals(dateException.getMessage())){
                    editText_date.setError(dateException.getMessage());
                }
            }
            else if (error.getException() instanceof TimeException) {
                TimeException timeException = (TimeException) error.getException();
                if (timeException.getMessage().equals(timeException.getMessage())){
                    editText_time.setError(timeException.getMessage());
                }
            }
            else if (error.getException() instanceof ProjectException) {
                ProjectException projectException = (ProjectException) error.getException();
                if (projectException.getMessage().equals(projectException.getMessage())){
                    editText_project.setError(projectException.getMessage());
                }
            }
            else if (error.getException() instanceof TasksException) {
                TasksException tasksException = (TasksException) error.getException();
                if (tasksException.getMessage().equals(tasksException.getMessage())){
                    editText_tasks.setError(tasksException.getMessage());
                }
            }
        }
    }
}