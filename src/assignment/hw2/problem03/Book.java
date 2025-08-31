package assignment.hw2.problem03;

public class Book {
    private String title;
    private String author;
    private final String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false; // 대출 가능으로 초기화
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // 도서 대출 (가능한 경우만)
    public boolean borrowBook() {
        if(!isBorrowed) {
            isBorrowed = true;
            System.out.println("📖 '" + title + "' 대출 완료");
            return true;
        } else {
            System.out.println("⚠ '" + title + "' 은/는 이미 대출 중입니다.");
            return false;
        }
    }

    // 도서 반납
    public boolean returnBook() {
        if(isBorrowed) {
            isBorrowed = false;
            System.out.println("📚 '" + title + "' 반납 완료");
            return true;
        } else {
            System.out.println("⚠ '" + title + "' 은/는 대출된 상태가 아닙니다.");
            return false;
        }
    }

    // 도서 정보 출력
    public void showBookInfo() {
        System.out.println("=== 책 정보 ===");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("상태: " + (isBorrowed ? "대출 중" : "대출 가능"));
    }
}
