package com.example.root.memo2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemoActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new MemoFragment();
    }
}
