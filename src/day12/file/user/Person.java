package day12.file.user;

public class Person {
    private String name;
    private String phoneNumber;
    private String address;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", address='" + address + '\'' + '}';
    }
}
