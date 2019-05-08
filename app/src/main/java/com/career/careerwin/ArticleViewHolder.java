package com.career.careerwin;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView articleNameView;
    private Context context;


    public ArticleViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        articleNameView = (TextView) itemView.findViewById(R.id.article_name);
        this.context = context;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, articleNameView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public TextView getArticleNameView() {
        return articleNameView;
    }
}