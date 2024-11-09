import java.util.Stack;

public class BookMergeSort {
    private static Stack<Book> stack = Main.getBooks();

    public static void sortByTitle_stack(Stack<Book> books) {
        if (books == null || books.size() <= 1) {
            return;
        }
        Book[] booksArray = books.toArray(new Book[0]);
        //sortByTitle(booksArray, 0, books.size() - 1);
        sortByTitle(booksArray, 0, booksArray.length - 1);
        books.clear();
        for (Book book : booksArray) {
            books.push(book);
        }
        //

    }

    private static void sortByTitle(Book[] books, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2; //lengh boook /2
            sortByTitle(books, left, middle);
            sortByTitle(books, middle + 1, right);
            mergeByTitle(books, left, middle, right);

           // |1|2|3|                        |4|5|
            // 1|   |2|  |3|

        }

    }

    private static void mergeByTitle(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1; // n1 = 1
        int n2 = right - middle; // n2 = 1 - 0 = 1
                                            // |2|   |1|


                                        // |2|

        Book[] Left = new Book[n1];
        Book[] Right = new Book[n2];

        for (int i = 0; i < n1; ++i) {
            Left[i] = books[left + i]; // left index 0 = 2
        }
        for (int j = 0; j < n2; ++j) {
            Right[j] = books[middle + 1 + j]; //Right index = 1
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i].getTitle().compareToIgnoreCase(Right[j].getTitle()) <= 0) {
                books[k] = Left[i];
                i++;
            } else {
                books[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = Right[j];
            j++;
            k++;
        }
    }

    public static void sortByAuthor_stack(Stack<Book> books) {
        if (books == null || books.size() <= 1) {
            return;
        }
        Book[] booksArray = books.toArray(new Book[0]);
        sortByAuthor(booksArray, 0, booksArray.length - 1);
        books.clear();
        for (Book book : booksArray) {
            books.push(book);
        }
    }

    private static void sortByAuthor(Book[] books, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortByAuthor(books, left, middle);
            sortByAuthor(books, middle + 1, right);
            mergeByAuthor(books, left, middle, right);
        }
    }

    private static void mergeByAuthor(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] Left = new Book[n1];
        Book[] Right = new Book[n2];

        for (int i = 0; i < n1; ++i) {
            Left[i] = books[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            Right[j] = books[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i].getAuthor().compareToIgnoreCase(Right[j].getAuthor()) <= 0) {
                books[k] = Left[i];
                i++;
            } else {
                books[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = Right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Books sorted by Title:");
        sortByTitle_stack(stack);
        stack.forEach(System.out::println);

        // Re-fetch the books from Main to restore the original state
        stack = Main.getBooks();

        System.out.println("\nBooks sorted by Author:");
        sortByAuthor_stack(stack);
        stack.forEach(System.out::println);
    }
}