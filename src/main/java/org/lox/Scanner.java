package org.lox;

import java.util.ArrayList;
import java.util.List;
import org.lox.Token.TokenType;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String var1) {
        this.source = var1;
    }

    List<Token> scanTokens() {
        while(!this.isAtEnd()) {
            this.start = this.current;
            this.scanToken();
        }

        this.tokens.add(new Token(TokenType.EOF, "", (Object)null, this.line));
        return this.tokens;
    }

    private boolean isAtEnd() {
        return this.current >= this.source.length();
    }

    private void scanToken() {
        char var1 = this.advance();
        switch (var1) {
            case '!':
                this.addToken(this.match('=') ? TokenType.BANG_EQUAL : TokenType.BANG);
                break;
            case '(':
                this.addToken(TokenType.LEFT_PAREN);
                break;
            case ')':
                this.addToken(TokenType.RIGHT_PAREN);
                break;
            case '*':
                this.addToken(TokenType.STAR);
                break;
            case '+':
                this.addToken(TokenType.PLUS);
                break;
            case ',':
                this.addToken(TokenType.COMMA);
                break;
            case '-':
                this.addToken(TokenType.MINUS);
                break;
            case '.':
                this.addToken(TokenType.DOT);
                break;
            case '/':
                if (this.match('/')) {
                    while(this.peek() != '\n' && !this.isAtEnd()) {
                        this.advance();
                    }
                } else {
                    this.addToken(TokenType.SLASH);
                }
                break;
            case ';':
                this.addToken(TokenType.SEMICOLON);
                break;
            case '<':
                this.addToken(this.match('=') ? TokenType.LESS_EQUAL : TokenType.LESS);
                break;
            case '=':
                this.addToken(this.match('=') ? TokenType.EQUAL_EQUAL : TokenType.EQUAL);
                break;
            case '>':
                this.addToken(this.match('=') ? TokenType.GREATER_EQUAL : TokenType.GREATER);
                break;
            case '{':
                this.addToken(TokenType.LEFT_BRACE);
                break;
            case '}':
                this.addToken(TokenType.RIGHT_BRACE);
                break;
            default:
                Lox.error(this.line, "Unexpected character.");
        }

    }

    private boolean match(char var1) {
        if (this.isAtEnd()) {
            return false;
        } else if (this.source.charAt(this.current) != var1) {
            return false;
        } else {
            ++this.current;
            return true;
        }
    }

    private char peek() {
        return this.isAtEnd() ? '\u0000' : this.source.charAt(this.current);
    }

    private char advance() {
        return this.source.charAt(this.current++);
    }

    private void addToken(Token.TokenType var1) {
        this.addToken(var1, (Object)null);
    }

    private void addToken(Token.TokenType var1, Object var2) {
        String var3 = this.source.substring(this.start, this.current);
        this.tokens.add(new Token(var1, var3, var2, this.line));
    }
}
