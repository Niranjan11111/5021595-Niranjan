class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class LibraryManagementSystem {
    // Linear Search to find books by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search to find books by title (assuming the list is sorted)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("2", "1984", "George Orwell"),
            new Book("3", "To Kill a Mockingbird", "Harper Lee"),
            new Book("4", "Pride and Prejudice", "Jane Austen"),
            new Book("5", "The Catcher in the Rye", "J.D. Salinger")
        };

        // Linear Search
        String searchTitle = "1984";
        Book foundBook = linearSearch(books, searchTitle);
        if (foundBook != null) {
            System.out.println("Linear Search: Found Book - " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Linear Search: Book not found.");
        }

        // Binary Search (assuming books array is sorted by title)
        searchTitle = "Pride and Prejudice";
        foundBook = binarySearch(books, searchTitle);
        if (foundBook != null) {
            System.out.println("Binary Search: Found Book - " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Binary Search: Book not found.");
        }
    }
}
