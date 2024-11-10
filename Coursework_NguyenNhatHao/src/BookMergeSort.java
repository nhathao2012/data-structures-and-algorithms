import java.util.Stack;

public class BookMergeSort {
    private static Stack<Book> stack = Main.getBooks();

    public static void sortByTitleStack(Stack<Book> books) {
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

            // Recursively sort the left half
            sortByTitle(books, left, middle);

            // Recursively sort the right half
            sortByTitle(books, middle + 1, right);

            // Merge the sorted halves
            mergeByTitle(books, left, middle, right);
        }
    }

    private static void mergeByTitle(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = books[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = books[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getTitle().compareToIgnoreCase(rightArray[j].getTitle()) <= 0) {
                books[k] = leftArray[i];
                i++;
            } else {
                books[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sortByAuthorStack(Stack<Book> books) {
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

            // Recursively sort the left half
            sortByAuthor(books, left, middle);

            // Recursively sort the right half
            sortByAuthor(books, middle + 1, right);

            // Merge the sorted halves
            mergeByAuthor(books, left, middle, right);
        }
    }

    private static void mergeByAuthor(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = books[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = books[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getAuthor().compareToIgnoreCase(rightArray[j].getAuthor()) <= 0) {
                books[k] = leftArray[i];
                i++;
            } else {
                books[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Books sorted by Title:");
        sortByTitleStack(stack);
        stack.forEach(System.out::println);

        // Re-fetch the books from Main to restore the original state
        stack = Main.getBooks();

        System.out.println("\nBooks sorted by Author:");
        sortByAuthorStack(stack);
        stack.forEach(System.out::println);
    }
}