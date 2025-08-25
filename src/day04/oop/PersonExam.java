package day04.oop;

public class PersonExam {
    public static void main(String[] args) {

        // static 필드는 인스턴스화 하지 않고 사용가능하다.
        Person.count++;
        System.out.println(Person.MAX_AGE);
        System.out.println(Person.count);

        Person kang = new Person();
        kang.name = "강경미";

        Person kim = new Person();
        kim.name = "김주원";

        kim.count++;
        System.out.println(kang.count);
        System.out.println(kim.count);
    }
}
