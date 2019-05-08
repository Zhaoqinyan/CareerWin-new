package com.career.careerwin;

import java.io.Serializable;

public class Article implements Serializable {
    String title;
    int titleInt;

    public Article() {
    }

    public Article(int titleInt) {
        this.titleInt = titleInt;
    }

    public Article(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
