package com.example.root.memo2;

import android.content.Context;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoLab {
    private static MemoLab sMemoLab;
    private static List<MemoOne> mMemoOnes;

    public List<MemoOne> getMemoOnes() {
        return mMemoOnes;
    }

    private MemoLab(Context context){
        mMemoOnes = new ArrayList<>();
        for (int i=0; i<5; i++){
            MemoOne memoOne = new MemoOne();
            memoOne.setTitle("记事本 #" + i);
            memoOne.setSolved(i % 2 == 0);
            mMemoOnes.add(memoOne);
        }
    }

    public static void addMemoOne(MemoOne memoOne){
        memoOne.setTitle("记事本 #");
        mMemoOnes.add(memoOne);
    }

    public static MemoLab get(Context context){
        if(sMemoLab == null){
            sMemoLab = new MemoLab(context);
        }
        return sMemoLab;
    }

    public MemoOne getMemoOne(UUID id){
        for(MemoOne memoOne : mMemoOnes){
            if(memoOne.getId().equals(id)){
                return memoOne;
            }
        }

        return null;
    }
}