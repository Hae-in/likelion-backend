package day12.file;

import java.io.File;

// 파일 삭제
public class FileDelete {
    public static void main(String[] args) {
        File f = new File("src/day12/output.txt");

        if (f.exists()) {
            boolean isDeleted = f.delete();

            if (isDeleted) {
                System.out.println("파일 삭제를 성공하였습니다.");
            } else {
                System.out.println("파일 삭제를 실패하였습니다.");
            }
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
