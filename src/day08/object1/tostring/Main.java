package day08.object1.tostring;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        System.out.println(person);

        // 오버라이딩하지 않으면 클래스명@해시코드 출력
        Object obj = new Object();
        System.out.println(obj);
    }
}
