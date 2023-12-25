public class Member {
    private static int nextId = 1;
    public int id;
    public String name;

    public Member(String name) {
        this.id = nextId++;
        this.name = name;
    }
}
