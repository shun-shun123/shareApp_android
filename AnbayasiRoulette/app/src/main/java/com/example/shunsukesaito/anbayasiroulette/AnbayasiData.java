package com.example.shunsukesaito.anbayasiroulette;

/**
 * Created by saitoushunsuke on 2017/06/29.
 */

public class AnbayasiData {
    private int number;
    private int addition;
    private String comment;
    AnbayasiData(int number,int addition,String comment){
        this.number = number;
        this.addition = addition;
        this.comment = comment;
    }

    public int getNumber() {
        return this.number;
    }

    public int getAddition() {
        return addition;
    }

    public String getComment() {
        return comment;
    }
}
