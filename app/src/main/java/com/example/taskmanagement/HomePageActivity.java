package com.example.taskmanagement;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        viewPager=findViewById(R.id.view_pager);
        ArrayList<Fragment> arrayList=new ArrayList<>();
        arrayList.add(new CreateFragment());
        arrayList.add(new NotificationFragment());
        viewPager.setAdapter(new HomePageAdapter(getSupportFragmentManager(), arrayList));
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create:
                viewPager.setCurrentItem(0);
                Toast.makeText(this, "ABC", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_notifications:
                viewPager.setCurrentItem(1);
                Toast.makeText(this, "XYZ", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
