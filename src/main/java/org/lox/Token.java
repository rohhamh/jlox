package org.lox;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType var1, String var2, Object var3, int var4) {
        this.type = var1;
        this.lexeme = var2;
        this.literal = var3;
        this.line = var4;
    }

    public String toString() {
        String var10000 = String.valueOf(this.type);
        return var10000 + " " + this.lexeme + " " + String.valueOf(this.literal);
    }

    static enum TokenType {
        LEFT_PAREN,
        RIGHT_PAREN,
        LEFT_BRACE,
        RIGHT_BRACE,
        COMMA,
        DOT,
        MINUS,
        PLUS,
        SEMICOLON,
        SLASH,
        STAR,
        BANG,
        BANG_EQUAL,
        EQUAL,
        EQUAL_EQUAL,
        GREATER,
        GREATER_EQUAL,
        LESS,
        LESS_EQUAL,
        IDENTIFIER,
        STRING,
        NUMBER,
        AND,
        CLASS,
        ELSE,
        FALSE,
        FUN,
        FOR,
        IF,
        NIL,
        OR,
        PRINT,
        RETURN,
        SUPER,
        THIS,
        TRUE,
        VAR,
        WHILE,
        EOF;

        private TokenType() {
        }
    }
}
