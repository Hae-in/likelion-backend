package day03;

public class ArrayTraversalExam {
    public static void main(String[] args) {
        int[] arr = {95, 87, 66, 73, 82};
        int total = 0, max = 0;
        double avg = 0;

        // 1. 배월의 모든 요소를 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i] + "\t");
            total = total + arr[i];
            max = arr[i] > max ? arr[i] : max;
        }

        // 2. 총점, 평균 구하기
        System.out.println("총점 = " + total);

        avg = (double) total / arr.length;
        System.out.println("평균 = " + avg);

        // 3. 최대값 찾기
        System.out.println("최대값 = " + max);
    }
}