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
        title = title.toLowerCase();

        Stack<Book> books = (Stack<Book>) stack.clone(); // Clone the stack to preserve original order
        BookMergeSort.sortByTitle_stack(books);

        int index = binarySearchByTitle(books, title);
        if (index != -1) {
            System.out.println("Book found: " + books.get(index));
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchByAuthor(String author) {
        author = author.toLowerCase();

        Stack<Book> books = (Stack<Book>) stack.clone(); // Clone the stack to preserve original order
        BookMergeSort.sortByAuthor_stack(books);

        int index = binarySearchByAuthor(books, author);
        if (index != -1) {
            System.out.println("Book found: " + books.get(index));
        } else {
            System.out.println("Book not found.");
        }
    }

    public static int binarySearchByTitle(Stack<Book> books, String title) {
        List<Book> booksList = new ArrayList<>(books);
        int low = 0;
        int high = booksList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midVal = booksList.get(mid);
            String midTitle = midVal.getTitle().toLowerCase();
            if (midTitle.contains(title)) {
                return mid; // Found
            } else if (midTitle.compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    public static int binarySearchByAuthor(Stack<Book> books, String author) {
        List<Book> booksList = new ArrayList<>(books);
        int low = 0;
        int high = booksList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midVal = booksList.get(mid);
            String midAuthor = midVal.getAuthor().toLowerCase();
            if (midAuthor.contains(author)) {
                return mid; // Found
            } else if (midAuthor.compareTo(author) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }
}