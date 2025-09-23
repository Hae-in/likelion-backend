package day12.file;

import java.io.File;

// 디렉토리 목록 조회
public class FileList {
    public static void main(String[] args) {
        File f = new File("src/day12/input.txt");
        if (!f.exists()) {
            System.out.println("디렉토리가 존재하지 않습니다.");
        }

        if (f.isDirectory()) {
            File[] fileList = f.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                System.out.println(fileList[i].getName());
                System.out.println("\t");
                if (fileList[i].isDirectory()) {
                    System.out.println("디렉토리");
                } else {
                    System.out.println("파일");
                    System.out.println("\t");
                    System.out.println(fileList[i].length());
                }
            }
        } else {
            System.out.println("디렉토리가 아닙니다.");
        }
    }
}
