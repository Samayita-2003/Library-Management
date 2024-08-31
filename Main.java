import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Members");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    libraryService.addBook(new Book(isbn, title, author));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    libraryService.registerMember(new Member(memberId, name, email));
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    String issueIsbn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMemberId = scanner.nextLine();
                    libraryService.issueBook(issueIsbn, issueMemberId);
                    break;

                case 4:
                    System.out.print("Enter ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = scanner.nextLine();
                    libraryService.returnBook(returnIsbn, returnMemberId);
                    break;

                case 5:
                    libraryService.viewAllBooks();
                    break;

                case 6:
                    libraryService.viewAllMembers();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
