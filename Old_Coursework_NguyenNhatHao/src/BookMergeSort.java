public class BookMergeSort {
    public static void sort(Book[] books, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sort(books, left, middle);
            sort(books, middle + 1, right);

            merge(books, left, middle, right);
        }
    }

    private static void merge(Book[] books, int left, int middle, int right) {
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
}
