public class Initial {
    public static void print(String text, int delay) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

    public static void mainMenu() {
        String[] Menu = {
                "Library Managment System Main Menu",
                "1.Manage Books ",
                "2.Mange Members",
                "3.Mange Transactions",
                "4.Borrow/Return",
                "0.Exit",
        };
        for (int i = 0; i < Menu.length; i++) {
            Initial.print(Menu[i], 4);
        }

    }

    public static void bookMenu() {
        String[] Menu = {
                "1.Add Book",
                "2.Count Book",
                "3.Searh Book",
                "4.Show All Books",
                "5.Show Limited Books",
                "6.Add Dummy Book",
                "7.Show Available Books",
                "8.Show Borrowed Books",
                "0.Main Menu",
        };
        for (int i = 0; i < Menu.length; i++) {
            Initial.print(Menu[i], 4);
        }

    }

    public static void memberMenu() {
        String[] Menu = {
                "1.Add Member",
                "2.Count Member",
                "3.Searh Member",
                "4.Show Member",
                "5.Add Dummy Member",
                "0.Main Menu",
        };
        for (int i = 0; i < Menu.length; i++) {
            Initial.print(Menu[i], 4);
        }

    }

    public static void borrowReturnMenu() {
        String[] Menu = {
                "1.Borrow Book",
                "2.Return Book",
                "0.Main Menu",
        };
        for (int i = 0; i < Menu.length; i++) {
            Initial.print(Menu[i], 4);
        }

    }

    public static void transactionMenu() {
        String[] Menu = {
                "1.Show All Transactions",
                "2.Show Borrow Transactions",
                "3.Show Return Transactions",
                "0.Main Menu",
        };
        for (int i = 0; i < Menu.length; i++) {
            Initial.print(Menu[i], 4);
        }

    }

    public static void start() {
        String title = "Welcome To Library Management System";
        String developer = "   By Muhammad Faizan Rauf";
        Initial.print(title, 80);
        Initial.print(developer, 70);

    }
}
