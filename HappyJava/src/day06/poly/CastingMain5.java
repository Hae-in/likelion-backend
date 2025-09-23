package day06.poly;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("\n=== parent1 호출 ===");
        call(parent1);

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent parent2 = new Child();
        System.out.println("\n=== parent2 호출 ===");
        call(parent2);

        // Child child1 = new Parent(); // 자식은 부모를 담을 수 없다.

        Child child2 = new Child();
        System.out.println("\n=== child2 호출 ===");
        call(child2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();

        //Child 인스턴스인 경우 childMethod() 실행
        if (parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent; // 다운캐스팅
            child.childMethod();
        }
    }
}
