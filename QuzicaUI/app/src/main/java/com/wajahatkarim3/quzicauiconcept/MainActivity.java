package com.wajahatkarim3.quzicauiconcept;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import com.wajahatkarim3.quzicauiconcept.controllers.QuestionsRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerQuestions) RecyclerView recyclerView;
    @BindView(R.id.txtDesignation) TextView txtDesignation;
    @BindView(R.id.txtStats) TextView txtStats;

    QuestionsRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        txtDesignation.setText(getDesignationText());
        txtStats.setText(getStatsText());

        recyclerAdapter = new QuestionsRecyclerAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

    }

    public SpannableString getDesignationText()
    {
        String text = txtDesignation.getText().toString();

        SpannableString s = new SpannableString(text);

        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), text.indexOf("@"), text.length(), 0);

        /*
        s.setSpan(new RelativeSizeSpan(1.2f), text.indexOf("A"), text.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), text.indexOf("A"), text.length(), 0);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), text.indexOf("A"), text.length(), 0);
        */

        return s;
    }

    public SpannableString getStatsText()
    {
        String text = txtStats.getText().toString();

        SpannableString s = new SpannableString(text);

        s.setSpan(new RelativeSizeSpan(1.3f), 0, text.indexOf("A"), 0);
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.indexOf("A"),0);

        s.setSpan(new RelativeSizeSpan(1.3f), text.indexOf("1"), text.indexOf("Q"), 0);
        s.setSpan(new ForegroundColorSpan(Color.WHITE), text.indexOf("1"), text.indexOf("Q"), 0);

        return s;
    }

}
