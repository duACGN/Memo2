package com.example.root.memo2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

public class MemoFragment extends Fragment{
    private MemoOne mMemoOne;
    private EditText mText;
    private static final String ARG_MEMO_ID = "memo_id";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        UUID memoId = (UUID) getActivity().getIntent().getSerializableExtra(MemoActivity.EXTRA_MEMO_ID);
        UUID memoId = (UUID)getArguments().getSerializable(ARG_MEMO_ID);
        mMemoOne = MemoLab.get(getActivity()).getMemoOne(memoId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_memo, container, false);

        mText = (EditText)v.findViewById(R.id.text_memo);
        mText.setText(mMemoOne.getText());
        mText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mMemoOne.setText(s.toString());
                mMemoOne.setTitle(s.toString().substring(0, mText.getLayout().getLineEnd(0)-1));
//                mMemoOne.setTitle(mText.get);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    public static MemoFragment newInstance(UUID memoId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_MEMO_ID, memoId);

        MemoFragment fragment = new MemoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
