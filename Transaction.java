
class Transaction {
    Book book;
    Member member;
    String transactionType;

    public Transaction(Book book, Member member, String transactionType) {
        this.book = book;
        this.member = member;
        this.transactionType = transactionType;
    }
}
