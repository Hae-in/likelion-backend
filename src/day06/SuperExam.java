package day06;

class Parent3 {
    int i = 10;

    public Parent3() {
        System.out.println("Parent3 생성");
    }

    public Parent3(int i) {
        System.out.println("Parent3 int 생성");
    }

    public void print() {
        System.out.println("Parent : " + i);
    }
}

class Child3 extends Parent3 {
    int i = 20;

    // super - 부모의 인스턴스를 가리킴
    public Child3() {
        super(); // 생략가능, 부모의 생성자에 접근 가능
        System.out.println("Child 생성");
    }

    public Child3(int i) {
        super(i); // 명시적으로 호출 해야함
        System.out.println("Parent3 int 생성");
    }

    public void print() {
        super.print(); // 부모의 필드, 메소드에 접근 가능
        System.out.println("Child : " + i);
    }

    public int getI() {
        return i;
    }
}

public class SuperExam {
    public static void main(String[] args) {
        Parent3 parent3 = new Parent3();
        Child3 child3 = new Child3(30); // Parent3 int 생성
        System.out.println(child3.i); // 20
        System.out.println(child3.getI()); // 20
        child3.print();
    }
}
