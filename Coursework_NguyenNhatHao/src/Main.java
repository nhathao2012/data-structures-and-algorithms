import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<Book> stack = new Stack<>();
    public static Stack<Book> getBooks() {
        return stack;
    }
    public static void main(String[] args) {
        // Adding 5 books to the stack
        stack.push(new Book("Harry Potter", "J.K. Rowling"));
        stack.push(new Book("The Hobbit", "J.R.R. Tolkien"));
        stack.push(new Book("1984", "George Orwell"));
        stack.push(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        stack.push(new Book("To Kill a Mockingbird", "Harper Lee"));

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("book - Go to Book operations");
            System.out.println("sort - Go to BookMergeSort operations");
            System.out.println("search - Go to BookBinarySearch operations");
            System.out.println("exit - Exit the program");
            System.out.println("\nType your command (or -help after any command for further instructions):");

            command = scanner.nextLine();
            switch (command) {
                case "book":
                    Book.main(new String[]{});
                    break;
                case "sort":
                    BookMergeSort.main(new String[]{});
                    break;
                case "search":
                    BookBinarySearch.main(new String[]{});
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}
