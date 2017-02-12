package com.wajahatkarim3.quzicauiconcept.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wajahatkarim3.quzicauiconcept.R;
import com.wajahatkarim3.quzicauiconcept.models.QAItemModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Wajahat Karim on 2/12/2017.
 */

public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.QAViewHolder> {

    public Context context;
    public List<QAItemModel> itemsList = new ArrayList<>();

    public QuestionsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public QAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qa_item_layout, parent, false);
        return new QAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QAViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class QAViewHolder extends RecyclerView.ViewHolder
    {

        public QAViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void render()
        {

        }

    }
}
