package day06;

public class Exam03 {
    public static void main(String[] args) {


        // 같은 부모일 경우에만 형변환 가능
        Parent p = new Child();

        // 형변환!!! - 작은 그릇에서 큰 그릇으로 바뀔 때(묵시적 형변환 가능)
        // 큰그릇 - 부모(오브젝트), 작은그릇 - 자식

        Object obj = p;
        p = (Parent) obj; // 더 큰 그릇에서 작은 그릇으로 옮겨담을때 오류!!!

        // 형변환 시에는 인스턴스가 중요!!!
        if (p instanceof Child) { // p가 가리키고있는 인스턴스가 c일때
            // 형변환
            Child c = (Child) p;
        }
    }
}
