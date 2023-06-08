package com.example.finalwork;

import java.io.Serializable;

public class Storage implements Serializable {

    public String question;
    public String answer1;
    public String answer2;
    public String answer3;
    public String answer4;
    public String help;
    public int checkchoice;

    public Storage(String question, String answer1, String answer2, String answer3, String answer4, String help, int checkchoice) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.help = help;
        this.checkchoice = checkchoice;
    }
}
