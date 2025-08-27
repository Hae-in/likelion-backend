package day08.object;

public class Person {
    private String name;
    private int age;
    private String address;

    // private 변수값 변경을 위해서 getter/setter

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // return 값은 변수 타입과 동일하게
    public String getName() {
        return name;
    }

    // return 값 없으니까 void
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 어떻게 보여줄건지의 요구사항에 따라 수정 가능!!
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}
