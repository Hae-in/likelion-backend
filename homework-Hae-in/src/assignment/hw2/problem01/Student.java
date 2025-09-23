package assignment.hw2.problem01;

public class Student {
    private final int idNumber; // 학번
    String name;                // 이름
    private int age;            // 나이
    private double GPA;         // 학점

    // 모든 정보
    public Student(String name, int idNumber, int age, double GPA) {
        this.name = name;
        this.idNumber = idNumber;
        updateAge(age); // 유효성 검사
        updateGpa(GPA); // 유효성 검사
    }

    // 이름, 학번
    public Student(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.age = 18;
        this.GPA = 0.0;
    }

    // 나이 수정
    public void updateAge(int newAge) {
        if (15 <= newAge && newAge <= 100) {
            this.age = newAge;
        } else {
            System.out.println("⚠ 잘못된 입력입니다. (나이: 15~100 사이 허용)");
        }
    }

    // GPA 수정
    public void updateGpa(double newGpa) {
        if (0.0 <= newGpa && newGpa <= 4.0) {
            this.GPA = newGpa;
        } else {
            System.out.println("⚠ 잘못된 입력입니다. (GPA: 0.0~4.0 사이 허용)");
        }
    }

    // GPA가 3.5 이상이면 true 반환
    public boolean isExcellent() {
        return GPA >= 3.5;
    }

    // 학생 정보 출력
    public void displayInfo() {
        System.out.println("name='" + name + '\'' + ", idNumber=" + idNumber + ", age=" + age + ", GPA=" + GPA);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", idNumber=" + idNumber + ", age=" + age + ", GPA=" + GPA + '}';
    }
}
