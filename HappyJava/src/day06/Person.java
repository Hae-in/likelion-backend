package day06;

public class Person {

    // 필드는 private 선언하는것이 일반적
    private int age;
    private String name;

    // 필드가 모두 private 하다면, 저 정보를 써야할 때 어떻게 해야할까요?

    // 이 객체를 사용할 때 필드에 직접 접근하게 하기 보다는 메서드를 이용하게함.
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    // getter & setter 메서드 이용
}
