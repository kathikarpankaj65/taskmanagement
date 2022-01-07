package com.example.taskmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Observer<Result> {
    EditText editText;
    EditText editText1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.sign_in);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        editText = findViewById(R.id.edittext_username);
        String s = editText.getText().toString().trim();
        editText1 = findViewById(R.id.edittext_password);
        String s1 = editText1.getText().toString().trim();
        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel();
        LiveData<Result> mainActivityLiveData = mainActivityViewModel.getMainActivityViewModel(s, s1);
        mainActivityLiveData.observe(this, this);
    }

    @Override
    public void onChanged(Result result) {
        if (result instanceof Loading) {
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
        }
        if (result instanceof Success) {
            progressDialog.dismiss();
            Success<Integer> success = (Success) result;
            int c_id = success.getT();
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
        }
        else if (result instanceof Error) {
            progressDialog.dismiss();
            Error error = (Error) result;
            if (error.getException() instanceof UsernameException) {
                UsernameException usernameException = (UsernameException) error.getException();
                if (usernameException.getMessage().equals(usernameException.getMessage())) {
                    editText.setError(usernameException.getMessage());
                }
            }
            else if (error.getException() instanceof PasswordException) {
                PasswordException passwordException = (PasswordException) error.getException();
                if (passwordException.getMessage().equals(passwordException.getMessage())) {
                    editText1.setError(passwordException.getMessage());
                }
            }
            else if (error.getException() instanceof CredentialException) {
                CredentialException credentialException = (CredentialException) error.getException();
                Toast.makeText(this, credentialException.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}