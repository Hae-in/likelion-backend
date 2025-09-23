package assignment.hw2.problem03;

public class Library {
    private Book[] books = new Book[100];
    private int numberOfBooks = 0;

    public Library() {}

    // 도서 추가
    public void addBook(Book book) {
        books[numberOfBooks] = book;
        numberOfBooks++;
        System.out.println("📕 '" + book.getTitle() + "' 이 도서관에 추가되었습니다.");
    }

    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {
        for(int i = 0; i < numberOfBooks; i++) {
            if(books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    // 제목으로 도서 대출
    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if(book != null) {
            book.borrowBook();
        } else {
            System.out.println("❌ '" + title + "' 은/는 도서관에 없습니다.");
        }
    }

    // 제목으로 도서 반납
    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if(book != null) {
            book.returnBook();
        } else {
            System.out.println("❌ '" + title + "' 은/는 도서관에 없습니다.");
        }

    }

    // 대출 가능한 도서 목록 출력
    public void displayAvailableBooks() {
        System.out.println("=== 대출 가능한 도서 목록 ===");
        boolean found = false;
        for (int i = 0; i < numberOfBooks; i++) {
            if (!books[i].isBorrowed()) {
                System.out.println("📘 " + books[i].getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("대출 가능한 도서가 없습니다.");
        }
    }
}
