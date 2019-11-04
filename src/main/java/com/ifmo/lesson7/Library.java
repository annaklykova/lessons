package com.ifmo.lesson7;

/**
 * Библиотека помогает вести учет книг: какие книги и сколько в ней хранятся.
 * Библиотека ограничена по числу типов книг, это ограничение задается аргументом
 * конструктора maxBookKinds. Например, если библиотека ограничена числом 10,
 * то это означает, что она может хранить 10 разных книг, но любое их количество.
 *
 * Если из библиотеки убираются все книги одного типа, то освобождается место,
 * на которое можно добавить книгу другого типа.
 * Например:
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *     library.put(new Book("Stephen King", "Dark Tower"), 3); // return true
 *
 *     // Эту книгу добавить не можем, т.к. лимит 2
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return false
 *
 *     // Забираем все книги Тёмной башни, чтобы освободить место.
 *     library.take(new Book("Stephen King", "Dark Tower"), 3) // return 3
 *
 *     // Теперь мы можем успешно добавить "Войну и мир".
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return true
 * </pre>
 *
 * Если попытаться взять из библиотеки больше книг, чем у нее есть, то она
 * должна вернуть только число книг, которые в ней находились и освободить место.
 * Например:
 *
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *
 *     // Все равно вернет 2, т.к. больше нет.
 *     library.take(new Book("Stephen King", "Shining"), 10) // return 2
 * </pre>
 */
public class Library {
    BookCell[] lib;
    int count=0;

    public Library(int maxBookKinds) {
        // TODO implement
        this.lib = new BookCell[maxBookKinds];
    }

    /**
     * Add books to library.
     *
     * @param book     Book to add.
     * @param quantity How many books to add.
     * @return {@code True} if book successfully added, {@code false} otherwise.
     */
    public boolean put(Book book, int quantity) {
        int index = hashInd(book);

        if (findBookCellNumber(book) >= 0) {
            lib[findBookCellNumber(book)].quantity += quantity;
            return true;
        } else if (count<lib.length) {
            for (int i = 0; i < lib.length; i++) {

                if (lib[index] == null) {
                    lib[index] = new BookCell(book, quantity);
                    count++;
                    return true;
                } else {
                    index++;
                    index %= lib.length;
                    if (lib[index] == null) {
                        lib[index] = new BookCell(book, quantity);
                        count++;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public int findBookCellNumber(Book book) {
        int i = hashInd(book);
        for (int j = 0; j < lib.length; j++) {
            if (!(lib[i]==null) && lib[i].book.equals(book))
                return i;
            i++;
            i = i % lib.length;
        }
        return -1;
    }

    /**
     * Take books from library.
     *
     * @param book     Book to take.
     * @param quantity How many books to take.
     * @return Actual number of books taken.
     */
    public int take(Book book, int quantity) {
        // TODO implement

        if (findBookCellNumber(book) >= 0) {
            int i = findBookCellNumber(book);
            int quantityToTake = lib[i].quantity;
            if (lib[i].quantity <= quantity) {
                lib[i] = null;
                count--;
                return quantityToTake;
            } else {
                lib[i].quantity = lib[i].quantity - quantity;
                return quantity;
            }
        }
        return 0;
    }

    private int hashInd(Book book) {
        return Math.abs(book.hashCode()) % lib.length;
    }

}
