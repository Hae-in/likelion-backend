package day03;

public class ArrayCopyExam {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3};
        int[] copyIarr = new int[iarr.length];

        for (int i = 0; i < iarr.length; i++) {
            copyIarr[i] = iarr[i]; // 값을 복사 = 깊은 복사 (주소만 복사 = 얕은복사, int[] copyIarr = iarr)
        }
        System.out.println("복사된 배열");
        for (int value : copyIarr) {
            System.out.println(value);
        }

        // System.arraycopy() 사용
        int[] copy2 = new int[iarr.length];
        System.arraycopy(iarr, 0, copy2, 0, iarr.length);
        System.out.println(copy2);

        // Arrays.copyOf() 사용

        // Arrays.copyOfRange() 사용
        

    }
}
