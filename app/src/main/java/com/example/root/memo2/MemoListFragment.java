package com.example.root.memo2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MemoListFragment extends Fragment{
    private RecyclerView mMemoRecyclerView;
    private MemoAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_memo_list, container, false);

        mMemoRecyclerView = (RecyclerView)view.findViewById(R.id.memo_recycler_view);
        mMemoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        MemoLab memoLab = MemoLab.get(getActivity());
        List<MemoOne> memoOnes = memoLab.getMemoOnes();

        mAdapter = new MemoAdapter(memoOnes);
        mMemoRecyclerView.setAdapter(mAdapter);
    }

    private class MemoHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDataTextView;
        private MemoOne mMemoOne;


        public MemoHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_memo, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView)itemView.findViewById(R.id.memo_title);
            mDataTextView = (TextView)itemView.findViewById(R.id.memo_data);
        }

        public void bind(MemoOne memoOne){
            mMemoOne = memoOne;
            mTitleTextView.setText(mMemoOne.getTitle());
            mDataTextView.setText(mMemoOne.getDate().toString());
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(),
                    mMemoOne.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class MemoAdapter extends RecyclerView.Adapter<MemoHolder>{
        private List<MemoOne> mMemoOnes;
        public MemoAdapter(List<MemoOne> memoOnes){
            mMemoOnes = memoOnes;
        }

        @Override
        public MemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MemoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MemoHolder holder, int position) {
            MemoOne memoOne = mMemoOnes.get(position);
            holder.bind(memoOne);
        }

        @Override
        public int getItemCount() {
            return mMemoOnes.size();
        }
    }
}
