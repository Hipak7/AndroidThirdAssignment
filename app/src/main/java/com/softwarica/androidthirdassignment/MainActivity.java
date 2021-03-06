package com.softwarica.androidthirdassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softwarica.androidthirdassignment.fragments.AddFragment;
import com.softwarica.androidthirdassignment.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Softwarica> softwaricas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=findViewById(R.id.buttomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        //to view Home at start

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selFragment=null;

                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_home:
                            selFragment=new HomeFragment();
                            break;
                    }
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_add:
                            selFragment=new AddFragment();
                            break;
                    }
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_about:
                            selFragment=new AboutFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selFragment).commit();

                    return true;


                }
            };


}