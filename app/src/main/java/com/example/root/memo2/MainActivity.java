package com.example.root.memo2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_main);

        if(fragment == null){
            fragment = new MemoListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_main, fragment)
                    .commit();
        }
    }
}
