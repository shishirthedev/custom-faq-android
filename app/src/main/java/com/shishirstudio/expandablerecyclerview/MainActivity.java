package com.shishirstudio.expandablerecyclerview;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FaqsAdapter faqsAdapter;
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
        faqsAdapter = new FaqsAdapter(faqs);
        expandableListView.setAdapter(faqsAdapter);
        final int colorPrimary = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            View previousGroupView = null;
            TextView currentHeaderTv, prevHeaderTv;
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                currentHeaderTv = view.findViewById(R.id.headerTv);
                if(previousGroupView != null && view != previousGroupView){
                    previousGroupView.setBackgroundColor(Color.WHITE);
                    prevHeaderTv = previousGroupView.findViewById(R.id.headerTv);
                    prevHeaderTv.setTextColor(colorPrimary);
                }
                view.setBackgroundColor(colorPrimary);
                currentHeaderTv.setTextColor(Color.WHITE);
                previousGroupView = view;
                return false;
            }
        });
    }

    private ArrayList<Faq> getFaqs() {
        ArrayList<Faq> faqs = new ArrayList<>();
        faqs.add(new Faq("Do you get paid on medium?",
                "When Medium Members clap for an article, a portion of their $5 monthly subscription fee is paid directly to the author. According to Medium. In other words, you are paid per clap on Medium. Generally speaking, the more claps you receive, the more money you make."));

        faqs.add(new Faq("How does medium Partner program work?",
                "No, you don't have to be a paying Medium member to join the Partner Program and earn money for your writing. ... Publications are a vital part of Medium. Writers can earn money through the Partner Program and include their story in a publication at the same time. It will have no impact on how much they earn."));

        faqs.add(new Faq("What do you write on a medium?",
                "You get paid by the clap. But cost-per-clap ranges from $0.01 to $2.19. Medium pays authors based on a weighted cost-per-clap system."));

        faqs.add(new Faq("How does medium make money?",
                "When Medium Members clap, a portion of their $5 monthly subscription fee is paid directly to the author. In other words, you are paid per clap on Medium. The more claps you receive, the more money you make."));

        faqs.add(new Faq("How much money can you make writing on medium?",
                "Some writers who make serious money on Medium say that you should write at least three times a week, but more if possible. I follow some writers who write every single day! These guys must make a whole lot more than $100 per month"));

        faqs.add(new Faq("Is medium free for writers?",
                "As a writer on Medium, you can share your stories with the world with our easy-to-use editor. Publishing on Medium is free and stories you publish may be distributed to your followers, as well as millions of readers who follow relevant topics."));

        faqs.add(new Faq("What does medium Partner Program pay?",
                "The AVERAGE Medium Partner Program earnings for bloggers who post AT LEAST one locked story tend to always float near $50 per month. The MOST earned by any one writer for 1 month tends to float around $5,000-$10,000."));

        faqs.add(new Faq("Can I write for medium?",
                "You write beside and with other people. Medium is not about who you are or whom you know, but about what you have to say. Medium gives you an opportunity to reach a new audience with your amazing stories. You don't need to be a great writer to use Medium effectively."));

        return faqs;
    }
}
