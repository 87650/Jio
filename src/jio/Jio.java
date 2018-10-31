/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jio;

import java.util.List;
import jio.parser.Lexer;
import jio.parser.Token;

/**
 *
 * @author doctor
 */
public class Jio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String input = "2 + 2";
        final List<Token> tokens = new Lexer(input).tokenize();
            for (Token token : tokens) {
            System.out.println(token.getType());
        }
    }
    
}
