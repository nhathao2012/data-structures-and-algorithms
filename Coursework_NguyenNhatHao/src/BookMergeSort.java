import java.util.Scanner;
import java.util.Stack;

public class BookMergeSort {

    private static Stack<Book> stack = Main.getBooks(); // Assuming Main.getBooks() returns a Stack of Book objects

    public static void sortByTitle() {
        // Convert the stack to an array for efficient sorting
        Book[] books = stack.toArray(new Book[stack.size()]);

        sortByTitle(books, 0, books.length - 1);

        // Copy the sorted array back to the stack
        stack.clear();
        for (Book book : books) {
            stack.push(book);
        }
    }

    private static void sortByTitle(Book[] books, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sortByTitle(books, left, middle);
            sortByTitle(books, middle + 1, right);

            mergeByTitle(books, left, middle, right);
        }
    }

    private static void mergeByTitle(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = books[left + i];
        for (int i = 0; i < n2; ++i)
            rightArray[i] = books[middle + 1 + i];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getTitle().compareTo(rightArray[j].getTitle()) <= 0) {
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

    public static void sortByAuthor() {
        // Convert the stack to an array for efficient sorting
        Book[] books = stack.toArray(new Book[stack.size()]);

        sortByAuthor(books, 0, books.length - 1);

        // Copy the sorted array back to the stack
        stack.clear();
        for (Book book : books) {
            stack.push(book);
        }
    }

    private static void sortByAuthor(Book[] books, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sortByAuthor(books, left, middle);
            sortByAuthor(books, middle + 1, right);

            mergeByAuthor(books, left, middle, right);
        }
    }

    private static void mergeByAuthor(Book[] books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = books[left + i];
        for (int i = 0; i < n2; ++i)
            rightArray[i] = books[middle + 1 + i];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getAuthor().compareTo(rightArray[j].getAuthor()) <= 0) {
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
        Scanner scanner = new Scanner(System.in);
        String command;

//        System.out.println("Enter command (sort -help for commands):");
//        command = scanner.nextLine();
//
//        if (command.startsWith("sort")) {
//            handleSortCommands(command.split(" "));
//        } else if (command.equals("exit")) {
//            return;
//        }

        while (true) {
            System.out.println("Enter command (sort -help for commands):");
            command = scanner.nextLine();
            if (command.startsWith("sort")) {
                handleSortCommands(command.split(" "));
            } else if (command.equals("exit")) {
                break;
            }
        }


    }

    private static void handleSortCommands(String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "-title":
                    sortByTitle(); // Use the existing sortByTitle() method
                    System.out.println("Books sorted by title:");
                    printBooks();
                    break;
                case "-author":
                    sortByAuthor(); // Use the existing sortByAuthor() method
                    System.out.println("Books sorted by author:");
                    printBooks();
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
        System.out.println("-title  : Sort books by title");
        System.out.println("-author : Sort books by author");
        System.out.println("-help   : Display this help message");
    }

    private static void printBooks() {
        for (Book book : stack) {
            System.out.println(book);
        }
    }
}
