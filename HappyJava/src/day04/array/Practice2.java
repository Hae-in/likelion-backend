package day04.array;

public class Practice2 {
    public static void main(String[] args) {
        // 정수 배열에서 최대값과 최소값을 찾는 프로그램을 작성하세요.
        int[] arr = {31, 51, 82, 0, 43, 3, 100};
        int min, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            

        }
    }
}
