package day09.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        // list에 50명의 person이 저장되어있다.
        // 이름이 김금삐인 사람의 주소를 확인하고 싶다!! 라고 한다면?
        // key : value 형태로 데이터관리
        // ex) 주민등록번호, 학번

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("kim", "123-4567-8910");
        phoneBook.put("lee", "010-1234-5678");

        System.out.println(phoneBook);
        System.out.println("--- --- --- --- ---");

        System.out.println("kim -> " + phoneBook.get("kim"));
        System.out.println("lee -> " + phoneBook.get("lee"));
        System.out.println("--- --- --- --- ---");

        Set<String> keys = phoneBook.keySet();
        System.out.println("keys : " + keys);
        System.out.println("--- --- --- --- ---");

        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " = " + phoneBook.get(key));
        }
        System.out.println("--- --- --- --- ---");

        for (String key : keys) {
            System.out.println(key + " = " + phoneBook.get(key));
        }
        System.out.println("--- --- --- --- ---");

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("--- --- --- --- ---");
    }
}
