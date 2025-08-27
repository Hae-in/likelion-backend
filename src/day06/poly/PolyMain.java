package day06.poly;

public class PolyMain {
    public static void main(String[] args) {

        // 부모 변수가 부모 인스턴스 참조
        System.out.println("\n=== Parent -> Parent ===");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("\n=== Child -> Child ===");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        // 부모 변수가 자식 인스턴스 참조
        System.out.println("\n=== Parent -> Child ===");
        Parent poly = new Child();
        poly.parentMethod();
        // poly.childMethod(); // 컴파일 오류

        // 자식 변수가 부모 인스턴스 참조
        // Child c = new Parent(); // 컴파일 오류
    }
}
