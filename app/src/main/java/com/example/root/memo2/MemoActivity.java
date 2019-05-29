package com.example.root.memo2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

public class MemoActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        UUID memoId = (UUID)getIntent().getSerializableExtra(EXTRA_MEMO_ID);
        //Log.d("MemoActivity",memoId.toString());
        return MemoFragment.newInstance(memoId);
    }

    private static final String EXTRA_MEMO_ID = "com.bignerdranch.android.criminalintent.memo_id";

    public static Intent newIntent(Context packageContext, UUID memo_id){
        Intent intent = new Intent(packageContext, MemoActivity.class);
        intent.putExtra(EXTRA_MEMO_ID, memo_id);
        return intent;
    }
}
