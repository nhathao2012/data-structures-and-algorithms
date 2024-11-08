import java.util.*;

public class BookBinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Enter command (search -help for commands):");
        command = scanner.nextLine();

        if (command.startsWith("search")) {
            handleSearchCommands(command.split(" "));
        } else if (command.equals("exit")) {
            return;
        }
    }

    private static void handleSearchCommands(String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "-title":
                    searchByTitle();
                    break;
                case "-author":
                    searchByAuthor();
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
        System.out.println("-title  : Search book by title");
        System.out.println("-author : Search book by author");
    }

    private static void searchByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title to search:");
        String title = scanner.nextLine();

        List<Book> books = new ArrayList<>(Main.stack);
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        int index = binarySearchByTitle(books, title);
        if (index != -1) {
            System.out.println("Book found: " + books.get(index));
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book author to search:");
        String author = scanner.nextLine();

        List<Book> books = new ArrayList<>(Main.stack);
        Collections.sort(books, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));

        int index = binarySearchByAuthor(books, author);
        if (index != -1) {
            System.out.println("Book found: " + books.get(index));
        } else {
            System.out.println("Book not found.");
        }
    }

    public static int binarySearchByTitle(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midVal = books.get(mid);
            int cmp = midVal.getTitle().compareTo(title);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // Found
        }
        return -1; // Not found
    }

    public static int binarySearchByAuthor(List<Book> books, String author) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midVal = books.get(mid);
            int cmp = midVal.getAuthor().compareTo(author);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // Found
        }
        return -1; // Not found
    }
}
