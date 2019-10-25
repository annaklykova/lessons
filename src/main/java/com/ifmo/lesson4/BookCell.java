package com.ifmo.lesson4;

public class BookCell {
    Book book;
    int quantity;

    public BookCell(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookCell{" +
                "book='" + book.author + " " +book.title+ '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
