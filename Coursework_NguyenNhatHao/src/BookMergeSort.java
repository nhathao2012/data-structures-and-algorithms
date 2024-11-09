import java.util.Stack;

public class BookMergeSort {

    public static void sortByTitle(Stack<Book> books) {
        if (books == null || books.size() <= 1) {
            return;
        }
        Book[] booksArray = books.toArray(new Book[0]);
        sortByTitle(booksArray, 0, booksArray.length - 1);
        books.clear();
        for (Book book : booksArray) {
            books.push(book);
        }
    }

    private static void sortByTitle(Book[] books, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortByTitle(books, left, middle);
            sortByTitle(books, middle + 1, right);
            mergeByTitle(books, left, middle, right);
        }
    }

    private static void mergeByTitle(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] L = new Book[n1];
        Book[] R = new Book[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = books[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = books[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getTitle().compareTo(R[j].getTitle()) <= 0) {
                books[k] = L[i];
                i++;
            } else {
                books[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sortByAuthor(Stack<Book> books) {
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

        Book[] L = new Book[n1];
        Book[] R = new Book[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = books[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = books[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getAuthor().compareTo(R[j].getAuthor()) <= 0) {
                books[k] = L[i];
                i++;
            } else {
                books[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Stack<Book> books = new Stack<>();
        books.push(new Book("Title C", "Author A"));
        books.push(new Book("Title A", "Author B"));
        books.push(new Book("Title B", "Author C"));

        System.out.println("Books sorted by Title:");
        sortByTitle(books);
        books.forEach(System.out::println);

        // Re-adding the books in original order for the next sort
        books.clear();
        books.push(new Book("Title C", "Author A"));
        books.push(new Book("Title A", "Author B"));
        books.push(new Book("Title B", "Author C"));

        System.out.println("\nBooks sorted by Author:");
        sortByAuthor(books);
        books.forEach(System.out::println);
    }
}