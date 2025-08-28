package day09.collection;

import java.util.*;

public class PersonDemo {
    public static void main(String[] args) {
        // Person을 여러명 저장하고 싶다.
        // 1. Person 객체 5개 생서
        Person person1 = new Person("John", "1", "John@doe.com", "123-4567-8910");
        Person person2 = new Person("Kim", "2", "Kim@doe.com", "010-1234-5678");
        Person person3 = new Person("Lee", "3", "Lee@doe.com", "010-5341-6424");
        Person person4 = new Person("Choi", "4", "Choi@doe.com", "010-4412-1456");
        Person person5 = new Person("Ann", "5", "Ann@doe.com", "010-2342-5678");

        // 2. 이렇게 생성한 person 객체들을 List, Set, Map 각각 담아주세요.
        // map은 key를 idNumber로 하고, value는 Person을 담는것으로 해주세요.

        // List
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        System.out.println("personList = " + personList);

        // Set
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);
        personSet.add(person5);

        System.out.println("personSet = " + personSet);

        // Map
        Map<String, Person> personMap = new HashMap<>();
        personMap.put(person1.getIdNumber(), person1);
        personMap.put(person2.getIdNumber(), person2);
        personMap.put(person3.getIdNumber(), person3);
        personMap.put(person4.getIdNumber(), person4);
        personMap.put(person5.getIdNumber(), person5);

        System.out.println("personMap = " + personMap);

        // 3. 각 List, Set, Map에서 특정 idNumber에 해당하는 Person 객체를 찾고 싶다면??
        Person findPerson = null;

        // List
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person != null && "1".equals(person.getIdNumber())) { // NullPointException
                findPerson = person;
                break; // 찾으면 더이상 순회할 필요 없으니까
            }
        }
        System.out.println("List findPerson = " + findPerson);

        // Set
        for (Person person : personSet) {
            if (person != null && "1".equals(person.getIdNumber())) {
                findPerson = person;
                break;
            }
        }
        System.out.println("Set findPerson = " + findPerson);

        // Map
        findPerson = personMap.get("1");
        System.out.println("<Map findPerson = " + findPerson);
    }
}
