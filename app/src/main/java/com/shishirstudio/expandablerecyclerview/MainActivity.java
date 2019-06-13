package com.shishirstudio.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FaqsAdapter faqsAdatper;
    private ArrayList<Faq> faqs;
    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
    }

    private void findViewById() {
        expandableListView = findViewById(R.id.expandableListView);
        faqs = getFaqs();
        faqsAdatper = new FaqsAdapter(faqs);
        expandableListView.setAdapter(faqsAdatper);
    }

    private ArrayList<Faq> getFaqs() {
        ArrayList<Faq> faqs = new ArrayList<>();
        faqs.add(new Faq("Question 1", "Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1 Answer 1"));
        faqs.add(new Faq("Question 2", "Answer 2 Answer 2 Answer 2 Answer 2 Answer 2 Answer 2 Answer 2Answer 2Answer 2 Answer 2 Answer 2 Answer 2 Answer 2"));
        faqs.add(new Faq("Question 3", "Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3 Answer 3"));
        faqs.add(new Faq("Question 4", "Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4 Answer 4"));
        faqs.add(new Faq("Question 5", "Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5 Answer 5"));
        return faqs;
    }
}
