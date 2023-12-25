public class Dummy {
    Library library = new Library();

    public void addDummyBooks(int count) {
        String[] bookNames = {
                "The Great Gatsby",
                "To Kill a Mockingbird",
                "1984",
                "Pride and Prejudice",
                "The Catcher in the Rye",
                "The Lord of the Rings",
                "Harry Potter and the Sorcerer's Stone",
                "The Chronicles of Narnia",
                "Moby-Dick",
                "The Hobbit",
                "The Odyssey", "Frankenstein", "The Picture of Dorian Gray", "Dracula", "Jane Eyre",
                "Wuthering Heights", "The Brothers Karamazov", "One Hundred Years of Solitude", "Brave New World",
                "The Count of Monte Cristo" };

        String[] authors = { "F. Scott Fitzgerald", "Harper Lee", "George Orwell", "Jane Austen", "J.D. Salinger",
                "J.R.R. Tolkien",
                "J.K. Rowling", "C.S. Lewis", "Herman Melville", "J.R.R. Tolkien", "Homer", "Mary Shelley",
                "Oscar Wilde",
                "Bram Stoker", "Charlotte Brontë", "Emily Brontë", "Fyodor Dostoevsky", "Gabriel García Márquez",
                "Aldous Huxley", "Alexandre Dumas" };

        if (count > bookNames.length || count <= 0) {
            Initial.print("Invalid Choice", 30);
        } else {
            for (int i = 0; i < count; i++) {
                library.addBook(bookNames[i], authors[i]);
            }
            Initial.print("Process Of Adding Dummy Books Completed", 4);
        }

    }

    public void addDummyMember(int count) {
        String[] names = {
                "Usama", "Fatima", "Omar", "Aisha", "Ali", "Khadijah", "Amina", "Abdullah", "Sumaya", "Usama",
                "Aisha", "Khadijah", "Umar", "Bilal", "Zainab", "Amina", "Yusuf", "Aisha", "Mariam", "Hassan",
                "Zahra", "Aisha", "Khalid", "Ibrahim", "Ayesha", "Ahmed", "Sana", "Mustafa", "Layla", "Zakariya",
                "Nadia", "Tariq", "Sofia", "Rahim", "Hafsah", "Nasir", "Zain", "Aisha", "Musa", "Farida", "Amir",
                "Zara", "Hamza", "Amina", "Rayyan", "Saida", "Kareem", "Leila", "Jamal", "Nour", "Rami", "Fatemah",
                "Aziz", "Huda", "Yaseen", "Shireen", "Othman", "Asma", "Yahya", "Rukaya", "Isa", "Naima", "Talha",
                "Madiha", "Taha", "Lubna", "Qasim", "Hana", "Saad", "Najwa", "Bashir", "Rabia", "Samir", "Lina",
                "Karim", "Aaliyah", "Waleed", "Noura", "Kamal", "Nadia", "Jalal", "Soraya", "Rashid", "Safia",
                "Wahid", "Zoya", "Zubair", "Sakina", "Ahmad", "Aasiyah", "Yunus", "Fariha", "Tariq", "Alia",
                "Jibril", "Rania", "Imran", "Nahla", "Talib", "Sanaa"
        };
 
        if (count > names.length || count <= 0) {
            Initial.print("Invalid Choice", 30);
        } else {
            for (int i = 0; i < count; i++) {
                library.addMember(names[i]);
            }
            Initial.print("Process Of Adding Dummy member Completed", 1);
        }
    }
}
