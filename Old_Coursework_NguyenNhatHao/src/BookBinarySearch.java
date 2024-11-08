import java.util.Scanner;

public class BookBinarySearch {
    public static void searchBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Sort the array before performing binary search
        BookMergeSort.sort(books, 0, books.length - 1);

        do {
            System.out.print("\nEnter a character or full title to search for (or type 'exit' to quit): ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                search(books, input);
            }
        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
    }

    private static void search(Book[] books, String input) {
        boolean found = false;

        System.out.println("\nBooks containing '" + input + "' in their titles:");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(input.toLowerCase())) {
                System.out.println("Book found: " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with the input '" + input + "'.");
        }
    }

    private static int binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = books[middle].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return middle;
            }

            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1; // Book not found
    }
}
