package day05;

public class Book {
    String title;
    String author;
    int price;

    // 생성자가 한 번도 정의 된적이 없다면, 컴파일러가 자동으로 디폴트생성자를 생성함.
    public Book() {
        System.out.println("Book() 생성!");
        title = "Java";
        author = "고슬링";
        price = 100;
    } // 메서드와 흡사하나, 리턴타입이 없고, 메서드명이 클래스명과 동일함.

    public static void main(String[] args) {
        Book book = new Book(); // () - 생성자

        System.out.println(book.title);
        System.out.println(book.author);
        System.out.println(book.price);
    }
}
