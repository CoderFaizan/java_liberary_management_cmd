import java.util.Scanner;

public class LibraryManagement {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    private static Dummy dummy = new Dummy();

    public static void main(String[] args) {
        Initial.start();
        int menuChoice;
        do {
            Initial.mainMenu();
            menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    handleBooksMenu();
                    break;
                case 2:
                    handleMemberMenu();
                    break;

                case 3:
                    handleTransactionsMenu();
                    break;
                case 4:
                    handleBorrowReturn();
                    break; // Add break here to exit the loop after handling member menu
                case 0:
                    Initial.print("Exiting the Library Management System. Goodbye!", 20);
                    break;
                default:
                    Initial.print("Invalid choice. Please choose a valid option.", 20);
                    break;
            }
        } while (menuChoice != 0);

        scanner.close();
    }

    private static void handleTransactionsMenu() {
        int transactionChoice;
        do {
            Initial.print("Welcome to Transactions Menu", 20);
            Initial.transactionMenu();
            transactionChoice = scanner.nextInt();

            switch (transactionChoice) {
                case 1:
                    library.showAllTransactions();
                    break;
                case 2:
                    library.showBorrowTransactions();
                    break;
                case 3:
                    library.showReturnTransactions();
                    break;

                case 0:
                    Initial.print("Exiting the Books Menu.", 20);
                    break;
                default:
                    Initial.print("Invalid choice. Please choose a valid option.", 20);
                    break;
            }

        } while (transactionChoice != 0);
    }

    private static void handleBooksMenu() {
        int bookMenuChoice;

        do {
            Initial.print("Welcome to Books Menu", 20);
            Initial.bookMenu();
            bookMenuChoice = scanner.nextInt();

            switch (bookMenuChoice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.next();
                    System.out.print("Enter author name: ");
                    String bookAuthor = scanner.next();
                    library.addBook(bookTitle, bookAuthor);
                    break;
                case 2:
                    String countBooksResults = library.countBooks();
                    Initial.print(countBooksResults, 20);
                    break;
                case 3:
                    Initial.print("Search Book : ", 30);
                    String searchBook = scanner.next();
                    library.searchBooks(searchBook);
                    break;
                case 4:
                    library.showBooks();
                    break;
                case 5:

                    Initial.print("How Many Books You Want to Show: ", 30);
                    int bookCount = scanner.nextInt();
                    library.showBooks(bookCount);
                    break;
                case 6:
                    Initial.print("You Can Only add Maximum 20 Books Once", 30);
                    Initial.print("How Many Dummy Books You Want to add", 30);
                    int dummyBookCount = scanner.nextInt();
                    dummy.addDummyBooks(dummyBookCount);
                    break;
                case 7:
                    library.showAvailableBooks();
                    break;
                case 8:
                    library.showBorrowedBooks();
                    break;
                case 0:
                    Initial.print("Exiting the Books Menu.", 20);
                    break;
                default:
                    Initial.print("Invalid choice. Please choose a valid option.", 20);
                    break;
            }

        } while (bookMenuChoice != 0);
    }

    private static void handleMemberMenu() {
        int memberMenuChoice;

        do {
            Initial.print("Welcome to Member Menu", 20);
            Initial.memberMenu();
            memberMenuChoice = scanner.nextInt();

            switch (memberMenuChoice) {
                case 1:
                    System.out.print("Enter Member Name: ");
                    String memebreName = scanner.next();
                    library.addMember(memebreName);
                    break;
                case 2:
                    String countMembersResult = library.countMembers();
                    Initial.print(countMembersResult, 2);
                    break;

                case 3:
                    Initial.print("Search Member : ", 30);
                    String searchMember = scanner.next();
                    library.searchMembers(searchMember);
                    break;
                case 4:
                    library.showMembers();
                    break;
                case 5:
                    Initial.print("You Can Only add Maximum 100 Members Once", 30);
                    Initial.print("How Many Dummy Member You Want to add", 30);
                    int dummyMemberCount = scanner.nextInt();
                    dummy.addDummyMember(dummyMemberCount);
                    break;
                case 0:
                    Initial.print("Exiting the Member Menu.", 20);
                    break;
                default:
                    Initial.print("Invalid choice. Please choose a valid option.", 20);
                    break;
            }

        } while (memberMenuChoice != 0);
    }

    private static void handleBorrowReturn() {
        int borrowReturnMenuChoice;

        do {
            Initial.print("Welcome to Borrow/Retrun Menu", 20);
            Initial.borrowReturnMenu();
            borrowReturnMenuChoice = scanner.nextInt();

            switch (borrowReturnMenuChoice) {
                case 1:
                    Initial.print("Enter Book Id: ", 1);
                    int borrowBookId = scanner.nextInt();

                    Initial.print("Enter Member Id: ", 1);
                    int borrowMemberId = scanner.nextInt();
                    // library.addMember(memebreName);
                    library.borrowBook(borrowBookId, borrowMemberId);
                    break;
                case 2:
                    Initial.print("Enter Book Id: ", 1);
                    int returnBookId = scanner.nextInt();

                    Initial.print("Enter Member Id: ", 1);
                    int returnMemberId = scanner.nextInt();
                    // library.addMember(memebreName);
                    library.returnBook(returnBookId, returnMemberId);
                    break;

                case 0:
                    Initial.print("Exiting the Borrow Return Menu.", 20);
                    break;
                default:
                    Initial.print("Invalid choice. Please choose a valid option.", 20);
                    break;
            }

        } while (borrowReturnMenuChoice != 0);
    }

}
