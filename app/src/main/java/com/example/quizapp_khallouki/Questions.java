package com.example.quizapp_khallouki;

public class Questions {
    private String quiz;
    private String rep,rep1,rep2,image;
    private int score=0;

    public Questions(String quiz, String rep, String rep1, String rep2, String image, int score) {
        this.quiz = quiz;
        this.rep = rep;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.image = image;
        this.score = score;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Questions(){

    }
}
