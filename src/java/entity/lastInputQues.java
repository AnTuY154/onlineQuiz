/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Darkness_King
 */
public class lastInputQues {
    int location;
    String question;

    public lastInputQues() {
    }

    public lastInputQues(int location, String question) {
        this.location = location;
        this.question = question;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
}
