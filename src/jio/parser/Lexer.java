/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jio.parser;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author doctor
 */
public class Lexer {
    
    private static final String OPERATOR_CHARS = "+-*/";
    private static final TokenType[] OPERATOR_TOKENS = {
        TokenType.PLUS, TokenType.MINUS, 
        TokenType.STAR, TokenType.SLASH,
    };
    
  private final String imput;
  private final int length;
  private final List<Token> tokens;
  
  private int pos;

    public Lexer(String imput) {
        this.imput = imput;
        length = imput.length();
        
        tokens = new ArrayList<>();
    }
  
    public List<Token> tokenize() {
        while(pos < length){
            final char current = peek(0);
            if(Character.isDigit(current)) tokenizeNumber();
            else if (OPERATOR_CHARS.indexOf(current) != -1) {
               tokenizeNumber();
           } else {
                next();
            }
        }
        return tokens;
    }
    private void tokenizeNumber() {
        final StringBuilder buffer = new  StringBuilder();
        char current = peek(0);
        while(Character.isDigit(current)) {
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.NUMBER,buffer.toString());
    }
    
    private void tokenizeOperator() {
        final int position = OPERATOR_CHARS.indexOf(peek(0));
       addToken(OPERATOR_TOKENS[position]);
       next();
    }
    
    private char next() {
     pos++;
      return peek(0);
    }
    
    
    private char peek(int relativePosition) {
     final int position = pos + relativePosition;
      if(position >= length) return '\0';
      return imput.charAt(position);
    }
    
    private void addToken(TokenType type) {
        addToken(type, "");    
    }
    
    private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}
