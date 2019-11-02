package com.ifmo.lesson7;

public class BookCell {
    Book book;
    int quantity;

    BookCell(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookCell{" +
                "book='" +book.toString()+ '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
