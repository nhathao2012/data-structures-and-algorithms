import java.util.*;

public class BookBinarySearch {

    // Assuming Main.getBooks() returns a Stack of Book objects
    private static Stack<Book> stack = Main.getBooks();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Enter command (search -help for commands):");
        command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.startsWith("search")) {
                handleSearchCommands(command.split(" ", 3)); // Split into at most 3 parts
            } else {
                System.out.println("Invalid command.");
                showHelp();
            }
            System.out.println("Enter next command:");
            command = scanner.nextLine();
        }
        scanner.close();
    }

    private static void handleSearchCommands(String[] args) {
        if (args.length > 2) {
            switch (args[1]) {
                case "-title":
                    searchByTitle(args[2]);
                    break;
                case "-author":
                    searchByAuthor(args[2]);
                    break;
                case "-help":
                    showHelp();
                    break;
                default:
                    System.out.println("Invalid command.");
                    showHelp();
            }
        } else {
            System.out.println("Invalid command.");
            showHelp();
        }
    }

    private static void showHelp() {
        System.out.println("Available commands:");
        System.out.println("search -title [book_title]  : Search book by title");
        System.out.println("search -author [book_author] : Search book by author");
    }

    private static void searchByTitle(String title) {
        title = normalize(title);

        Stack<Book> books = (Stack<Book>) stack.clone(); // Clone the stack to preserve original order
        BookMergeSort.sortByTitleStack(books);

        List<Book> foundBooks = binarySearchAllByTitle(books, title);
        if (!foundBooks.isEmpty()) {
            for (Book book : foundBooks) {
                System.out.println("Book found: " + book);
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchByAuthor(String author) {
        author = normalize(author);

        Stack<Book> books = (Stack<Book>) stack.clone(); // Clone the stack to preserve original order
        BookMergeSort.sortByAuthorStack(books);

        List<Book> foundBooks = binarySearchAllByAuthor(books, author);
        if (!foundBooks.isEmpty()) {
            for (Book book : foundBooks) {
                System.out.println("Book found: " + book);
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Normalize the string by converting to lower case and removing spaces
    public static String normalize(String input) {
        return input.toLowerCase().replaceAll("\\s", "");
    }

    public static List<Book> binarySearchAllByTitle(Stack<Book> books, String title) {
        List<Book> booksList = new ArrayList<>(books);
        List<Book> result = new ArrayList<>();
        int low = 0;
        int high = booksList.size() - 1;
        int mid = -1;

        // Standard binary search
        while (low <= high) {
            mid = (low + high) / 2;
            Book midVal = booksList.get(mid);
            String midTitle = normalize(midVal.getTitle());

            if (midTitle.contains(title)) {
                break;
            } else if (midTitle.compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If an element was found
        if (low <= high) {
            // Scan left of mid for matches
            int left = mid;
            while (left >= 0 && normalize(booksList.get(left).getTitle()).contains(title)) {
                result.add(booksList.get(left--));
            }
            // Scan right of mid for matches
            int right = mid + 1;
            while (right < booksList.size() && normalize(booksList.get(right).getTitle()).contains(title)) {
                result.add(booksList.get(right++));
            }
        }

        return result;
    }

    public static List<Book> binarySearchAllByAuthor(Stack<Book> books, String author) {
        List<Book> booksList = new ArrayList<>(books);
        List<Book> result = new ArrayList<>();
        int low = 0;
        int high = booksList.size() - 1;
        int mid = -1;

        // Standard binary search
        while (low <= high) {
            mid = (low + high) / 2;
            Book midVal = booksList.get(mid);
            String midAuthor = normalize(midVal.getAuthor());

            if (midAuthor.contains(author)) {
                break;
            } else if (midAuthor.compareTo(author) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If an element was found
        if (low <= high) {
            // Scan left of mid for matches
            int left = mid;
            while (left >= 0 && normalize(booksList.get(left).getAuthor()).contains(author)) {
                result.add(booksList.get(left--));
            }
            // Scan right of mid for matches
            int right = mid + 1;
            while (right < booksList.size() && normalize(booksList.get(right).getAuthor()).contains(author)) {
                result.add(booksList.get(right++));
            }
        }

        return result;
    }
}