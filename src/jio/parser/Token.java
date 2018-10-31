/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jio.parser;

/**
 *
 * @author doctor
 */
public class Token {
 private TokenType type;
private String text;// место для имени переменной.// место для имени переменной.


    public Token() {
 }

    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
        
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }   
}
