package com.wajahatkarim3.quzicauiconcept.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wajahatkarim3.quzicauiconcept.BuildConfig;
import com.wajahatkarim3.quzicauiconcept.DetailsActivity;
import com.wajahatkarim3.quzicauiconcept.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wajahat Karim on 2/12/2017.
 */

public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.QAViewHolder> {

    public Context context;

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

        @BindView(R.id.layoutQuestion_item)
        LinearLayout layoutQuestion;

        public QAViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.layoutQuestion_item)
        public void onLayoutItemClick()
        {
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP)
            {
                Intent intent = new Intent(context, DetailsActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity)context, (View)layoutQuestion, "questionTransition");
                ((Activity)context).startActivity(intent, options.toBundle());

            }
            else {
                Intent ii = new Intent(context, DetailsActivity.class);
                context.startActivity(ii);
            }


        }


    }
}
