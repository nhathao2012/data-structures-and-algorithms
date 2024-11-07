public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book(1, "Java Programming", "John Doe");
        books[1] = new Book(2, "Effective Java", "Joshua Bloch");
        books[2] = new Book(3, "Clean Code", "Robert Martin");
        books[3] = new Book(4, "Design Patterns", "Erich Gamma");
        books[4] = new Book(5, "Refactoring", "Martin Fowler");

        System.out.println("Before sorting:");
        for (Book book : books) {
            System.out.println(book);
        }

        BookMergeSort.sort(books, 0, books.length - 1);

        System.out.println("\nAfter sorting:");
        for (Book book : books) {
            System.out.println(book);
        }
        BookBinarySearch.searchBooks(books);
    }
}
