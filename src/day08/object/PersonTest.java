package day08.object;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("김금삐");
        person.setAge(13);
        person.setAddress("대구");

        System.out.println(person);

        Person kim = new Person("kim", 20, "강남구 역삼동");
        System.out.println(kim);
    }
}
