package com.career.careerwin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> articles;
    private Context context;

    //local data constructor
    public ArticleAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    //FB data constructor
    public ArticleAdapter(DatabaseReference articlesRef, Context context) {
        this.context = context;
        articles = new ArrayList<>();
        articlesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Article p = dataSnapshot.getValue(Article.class);
                articles.add(p);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Article p = dataSnapshot.getValue(Article.class);
                articles.remove(p);
                notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_article, parent, false);
        return new ArticleViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article president = articles.get(position);
        holder.getArticleNameView().setText(president.getTitle());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}