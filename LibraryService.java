import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<String, Book> books;
    private Map<String, Member> members;

    public LibraryService() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book added: " + book);
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member registered: " + member);
    }

    public void issueBook(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(isbn);
            System.out.println("Book issued: " + book.getTitle() + " to " + member.getName());
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (member.getBorrowedBooks().contains(isbn)) {
            book.setAvailable(true);
            member.returnBook(isbn);
            System.out.println("Book returned: " + book.getTitle() + " by " + member.getName());
        } else {
            System.out.println("This member did not borrow this book.");
        }
    }

    public void viewAllBooks() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void viewAllMembers() {
        System.out.println("Members in the library:");
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
}
