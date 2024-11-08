import java.util.Stack;
import java.util.Scanner;

public class Book {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String author;

    private static Stack<Book> stack = Main.getBooks();

    public Book(String title, String author) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (book -help for commands):");
            command = scanner.nextLine();
            if (command.startsWith("book")) {
                handleBookCommands(command.split(" "));
            } else if (command.equals("exit")) {
                break;
            }
        }
    }

    private static void handleBookCommands(String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "-list":
                    listBooks();
                    break;
                case "-add":
                    addBook();
                    break;
                case "-remove":
                    removeBook();
                    break;
                case "-update":
                    updateBook();
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

    private static void listBooks() {
        for (Book book : stack) {
            System.out.println(book);
        }
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        stack.push(new Book(title, author));
    }

    private static void removeBook() {
        if (!stack.isEmpty()) {
            stack.pop();
            System.out.println("Top book removed.");
        } else {
            System.out.println("No books to remove.");
        }
    }

    private static void updateBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Book book : stack) {
            if (book.id == id) {
                System.out.println("Enter new title:");
                book.title = scanner.nextLine();
                System.out.println("Enter new author:");
                book.author = scanner.nextLine();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void showHelp() {
        System.out.println("Available commands:");
        System.out.println("-list   : List all books");
        System.out.println("-add    : Add a new book");
        System.out.println("-remove : Remove the top book");
        System.out.println("-update : Update a book by ID");
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + "]";
    }
}
