package assignment.hw1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework10 {
    // 로또 번호 생성기 🎲
    // 1부터 45 사이의 숫자 중 중복되지 않게 6개를 랜덤으로 뽑아 배열에 저장하세요.
    // 오름차순으로 정렬하여 출력하세요.

    public static class Lottery {
        private int[] myNumbers = new int[6];         // 내 번호
        private int[] winningNumbers = new int[6];    // 당첨 번호
        private int bonusNumber;                            // 보너스 번호
        private int matchedCount;                           // 맞춘 개수
        private int rank;                                   // 등수
        private long prizeAmount;                           // 당첨 금액
        private LocalDate drawDate;                         // 추첨 날짜
        private int round;                                  // 회차

        // 사용자 입력 받기
        public void inputMyNumbers() {
            Scanner sc = new Scanner(System.in);
            System.out.println("로또 번호 6개를 입력하세요 (1~45, 중복 불가):");

            for (int i = 0; i < myNumbers.length; ) {
                int num = sc.nextInt();

                // 범위 체크
                if (num < 1 || num > 45) {
                    System.out.println("1~45 사이 숫자를 입력하세요.");
                    continue;
                }

                // 중복 체크
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (myNumbers[j] == num) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("중복된 숫자입니다. 다시 입력하세요.");
                } else {
                    myNumbers[i] = num;
                    i++; // 유효한 입력일 때만 증가
                }
            }
        }

        // 당첨 번호 생성
        public void generateWinningNumbers() {
            Random rand = new Random();
            for (int i = 0; i < winningNumbers.length; ) {
                int num = rand.nextInt(45) + 1; // 1~45 랜덤

                // 중복 체크
                boolean isDuplicate = false;

                for (int j = 0; j < i; j++) {
                    if (winningNumbers[j] == num) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    winningNumbers[i] = num;
                    i++;
                }
            }

            // 보너스 번호 뽑기 (당첨번호와 중복되지 않게)
            while (true) {
                int bonus = rand.nextInt(45) + 1;
                boolean isDuplicate = false;

                for (int n : winningNumbers) {
                    if (n == bonus) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    bonusNumber = bonus;
                    break;
                }
            }
//        System.out.println(Arrays.toString(winningNumbers));
//        System.out.println(bonusNumber);
        }

        // 결과 비교
        public void checkResult() {
            matchedCount = 0;

            // 내 번호, 당첨 번호 비교
            for (int i = 0; i < myNumbers.length; i++) {
                for (int j = 0; j < winningNumbers.length; j++) {
                    if (myNumbers[i] == winningNumbers[j]) {
                        matchedCount++;
                    }
                }
            }

            // 등수 판정
            if (matchedCount == 6) {
                rank = 1;
                prizeAmount = 2000000000L;
            } else if (matchedCount == 5 && contains(myNumbers, bonusNumber)) {
                rank = 2;
                prizeAmount = 60000000L;
            } else if (matchedCount == 5) {
                rank = 3;
                prizeAmount = 1500000L;
            } else if (matchedCount == 4) {
                rank = 4;
                prizeAmount = 50000L;
            } else if (matchedCount == 3) {
                rank = 5;
                prizeAmount = 5000L;
            } else {
                rank = 0;
                prizeAmount = 0L;
            }
        }

        // 배열 안에 특정 값 있는지 확인 - 보너스번호 비교
        public boolean contains(int[] arr, int value) {
            for (int n : arr) {
                if (n == value) return true;
            }
            return false;
        }

        // 결과 출력
        public void printResult() {
            System.out.println("\n===== 로또 " + round + "회차 (" + drawDate + ") =====");
            System.out.println("내 번호: " + Arrays.toString(myNumbers));

            Arrays.sort(myNumbers);
            System.out.println("내 번호 정렬(오름차순) : " + Arrays.toString(myNumbers));

            System.out.println("당첨 번호: " + Arrays.toString(winningNumbers) + " + 보너스 " + bonusNumber);
            System.out.println("맞춘 개수: " + matchedCount);
            if (rank == 0) {
                System.out.println("결과: 꽝 😢");
            } else {
                System.out.println("결과: " + rank + "등! 당첨금 " + prizeAmount + "원 🎉");
            }
        }
    }
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.drawDate = LocalDate.now();
        lottery.round = 1100; // 임의 회차

        lottery.inputMyNumbers();           // 사용자 입력 받기
        lottery.generateWinningNumbers();   // 당첨 번호 생성
        lottery.checkResult();              // 결과 비교
        lottery.printResult();              // 결과 출력
    }
}
