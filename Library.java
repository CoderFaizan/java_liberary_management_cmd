import java.util.Arrays;

public class Library {
    private static int maxBooks = 50;
    private static int maxMember = 200;
    private static int maxTransaction = 200;
    private static Book[] books = new Book[maxBooks];
    private static int currentBooks = 0;
    private static int currentMembers = 0;
    private static int availableBooks = 0;
    private static int borrowedBooks = 0;

    private static Member[] members = new Member[maxMember];

    private Transaction[] transactions = new Transaction[maxTransaction];
    private int transactionCount;

    public void borrowBook(int bookIndex, int memberIndex) {
        bookIndex--;
        memberIndex--;
        if (bookIndex >= 0 && bookIndex < currentBooks && memberIndex >= 0 && memberIndex < currentMembers) {
            if (books[bookIndex].available) {

                transactions[transactionCount] = new Transaction(books[bookIndex], members[memberIndex], "Borrow");
                transactionCount++;
                availableBooks--;
                books[bookIndex].available = false;
                Initial.print("Book borrowed successfully!", 1);
                borrowedBooks++;
            } else {
                Initial.print("Book is not available for borrowing.", 1);
            }
        } else {
            Initial.print("Invalid book or member index.", 1);
        }
    }

    public void returnBook(int bookIndex, int memberIndex) {
        bookIndex--;
        memberIndex--;
        if (bookIndex >= 0 && bookIndex < currentBooks && memberIndex >= 0 && memberIndex < currentMembers) {
            if (!books[bookIndex].available) {

                transactions[transactionCount] = new Transaction(books[bookIndex], members[memberIndex], "Return");
                transactionCount++;
                availableBooks++;
                books[bookIndex].available = true;
                Initial.print("Book returned successfully!", 2);
                borrowedBooks--;
            } else {
                Initial.print("Book is already available. Cannot return.", 2);
            }
        } else {
            Initial.print("Invalid book or member index.", 2);
        }
    }

    public void showAllTransactions() {
        if (transactionCount > 0) {
            Initial.print("Transaction History:", 1);
            for (int i = 0; i < transactionCount; i++) {
                Initial.print("Transaction " + (i + 1) + ":", 1);
                Initial.print("Book ID: " + transactions[i].book.id, 1);
                Initial.print("Book Title: " + transactions[i].book.title, 1);
                Initial.print("Member ID: " + transactions[i].member.id, 1);
                Initial.print("Member Name: " + transactions[i].member.name, 1);
                Initial.print("Transaction Type: " + transactions[i].transactionType, 1);
                Initial.print("--------------", 1);
            }
        } else {
            Initial.print("No transactions available in the history.", 1);
        }
    }

    public void showBorrowTransactions() {
        if (transactionCount > 0) {
            Initial.print("Borrow Transaction History:", 1);
            for (int i = 0; i < transactionCount; i++) {
                if (transactions[i].transactionType == "Borrow") {
                    Initial.print("Transaction " + (i + 1) + ":", 1);
                    Initial.print("Book ID: " + transactions[i].book.id, 1);
                    Initial.print("Book Title: " + transactions[i].book.title, 1);
                    Initial.print("Member ID: " + transactions[i].member.id, 1);
                    Initial.print("Member Name: " + transactions[i].member.name, 1);
                    // Initial.print("Transaction Type: " + transactions[i].transactionType, 1);
                    Initial.print("--------------", 1);
                }
            }
        } else {
            Initial.print("No transactions available in the history.", 1);
        }
    }

    public void showReturnTransactions() {
        if (transactionCount > 0) {
            Initial.print("Return Transaction History:", 1);
            for (int i = 0; i < transactionCount; i++) {
                if (transactions[i].transactionType == "Return") {
                    Initial.print("Transaction " + (i + 1) + ":", 1);
                    Initial.print("Book ID: " + transactions[i].book.id, 1);
                    Initial.print("Book Title: " + transactions[i].book.title, 1);
                    Initial.print("Member ID: " + transactions[i].member.id, 1);
                    Initial.print("Member Name: " + transactions[i].member.name, 1);
                    // Initial.print("Transaction Type: " + transactions[i].transactionType, 1);
                    Initial.print("--------------", 1);
                }
            }
        } else {
            Initial.print("No transactions available in the history.", 1);
        }
    }

    public static void addBook(String name, String author) {
        if (currentBooks < maxBooks) {
            books[currentBooks] = new Book(name, author);
            availableBooks++;
            currentBooks++;

            Initial.print("Book added successfully At Index : " + currentBooks, 1);
        } else {
            Initial.print("Library is full. Cannot add more books.", 20);
        }
    }

    public static void showBooks() {
        if (currentBooks > 0) {
            Initial.print("Books in the Library:", 1);
            for (int i = 0; i < currentBooks; i++) {
                Initial.print("Book " + (i + 1) + ":", 1);
                Initial.print("ID: " + books[i].id, 1);
                Initial.print("Title: " + books[i].title, 1);
                Initial.print("Author: " + books[i].author, 1);
                Initial.print("Available: " + (books[i].available == true ? "Yes" : "No"), 1);

                Initial.print("--------------", 1);
            }
        } else {
            Initial.print("No books available in the Library.", 1);
        }
    }

    public static void showBooks(int limit) {

        if (currentBooks > 0) {
            if (limit > currentBooks) {
                Initial.print(limit + " Books Are Not Available ", limit);
            } else {

                Initial.print("Books in the Library:", 1);
                for (int i = 0; i < limit; i++) {
                    Initial.print("Book " + (i + 1) + ":", 1);
                    Initial.print("ID: " + books[i].id, 1);
                    Initial.print("Title: " + books[i].title, 1);
                    Initial.print("Author: " + books[i].author, 1);
                    Initial.print("Available: " + (books[i].available == true ? "Yes" : "No"), 1);

                    Initial.print("--------------", 1);
                }
            }
        } else {
            Initial.print("No books available in the Library.", 1);
        }
    }

    public static void showBorrowedBooks() {
        if (borrowedBooks > 0) {
            Initial.print("Books in the Library:", 1);
            for (int i = 0; i < currentBooks; i++) {
                if (!books[i].available) {

                    Initial.print("Book " + (i + 1) + ":", 1);
                    Initial.print("ID: " + books[i].id, 1);
                    Initial.print("Title: " + books[i].title, 1);
                    Initial.print("Author: " + books[i].author, 1);
                    Initial.print("Available: " + (books[i].available == true ? "Yes" : "No"), 1);

                    Initial.print("--------------", 1);
                }
            }
        } else {
            Initial.print("No Book is Borrowed.", 1);
        }
    }

    public void searchBooks(String titleSubstring) {
        if (currentBooks == 0) {
            Initial.print("No books in the library.", 3);
        } else {
            Initial.print("Matching Books:", 3);
            for (int i = 0; i < currentBooks; i++) {
                if (books[i].title.toLowerCase().contains(titleSubstring.toLowerCase())) {
                    Initial.print("Book " + (i + 1) + ":", 1);
                    Initial.print("ID: " + books[i].id, 1);
                    Initial.print("Title: " + books[i].title, 1);
                    Initial.print("Author: " + books[i].author, 1);
                    Initial.print("--------------", 1);
                }
            }
        }
    }

    public void showAvailableBooks() {
        if (availableBooks == 0) {
            Initial.print("No books in the library to Borrow.", 3);
        } else {
            Initial.print("Available Books:", 3);
            for (int i = 0; i < currentBooks; i++) {
                if (books[i].available) {

                    Initial.print("Book " + (i + 1) + ":", 1);
                    Initial.print("ID: " + books[i].id, 1);
                    Initial.print("Title: " + books[i].title, 1);
                    Initial.print("Author: " + books[i].author, 1);
                    Initial.print("--------------", 1);
                }
            }
        }
    }

    public static String countBooks() {
        String message = "";
        if (currentBooks > 0) {
            if (currentBooks == 1) {
                message = "Only One Book Is Available In Library";
            } else {
                message = "Total " + currentBooks + " Books are available in Library";
            }
        } else {
            message = "Still No Book Is Available";
        }
        return message;
    }

    public static String countMembers() {
        String message = "";
        if (currentMembers > 0) {
            if (currentMembers == 1) {
                message = "Only One Member Is Available In Record";
            } else {
                message = "Total " + currentMembers + " Members are available in Record";
            }
        } else {
            message = "Still No Member Is Available";
        }
        return message;
    }

    public static void addMember(String name) {
        if (currentMembers < maxMember) {
            members[currentMembers] = new Member(name);
            currentMembers++;
            Initial.print("Member added successfully At Index : " + currentMembers, 1);
        } else {
            Initial.print("More Members Not Allowed", 1);
        }
    }

    public static void showMembers() {
        if (currentMembers > 0) {
            Initial.print("Members in the Records:", 1);
            for (int i = 0; i < currentMembers; i++) {
                Initial.print("Member " + (i + 1) + ":", 1);
                Initial.print("Id: " + members[i].id, 1);
                Initial.print("Name: " + members[i].name, 1);

                // Initial.print("ID: " + books[i].id,1);
                Initial.print("--------------", 1);
            }
        } else {
            Initial.print("No Members available in the Record.", 1);
        }
    }

    public static void searchMembers(String nameSubstring) {
        if (currentMembers > 0) {
            Initial.print("Matching Members:", 1);
            for (int i = 0; i < currentMembers; i++) {
                if (members[i].name.toLowerCase().contains(nameSubstring.toLowerCase())) {
                    Initial.print("Member " + (i + 1) + ":", 1);
                    Initial.print("Id: " + members[i].id, 1);
                    Initial.print("Name: " + members[i].name, 1);
                    Initial.print("--------------", 1);
                }
            }
        } else {
            Initial.print("No Members available in the Record.", 1);
        }
    }

}
