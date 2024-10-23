package com.slobodianyk.homework2;

class Grade {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    String subject;
    @SuppressWarnings("checkstyle:VisibilityModifier")
    double score;

    // Constructor
    Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }
}
