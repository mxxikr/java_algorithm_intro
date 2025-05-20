package sectionArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 *
 * 입력
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 *
 * 출력
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 *
 * 예시 입력 1
 * 10
 *
 * 예시 출력 1
 * 1 1 2 3 5 8 13 21 34 55
 */
public class fibonacciSequenceMain {
//    public int[] solution(int n) {
//        int[] answer = new int[n]; // 피보나치 수열을 저장할 배열 생성
//        answer[0] = 1;
//        answer[1] = 1;
//
//        for (int i = 2; i < n; i++) {
//            answer[i] = answer[i - 2] + answer[i - 1];
//        }
//        return answer;
//    }

    public void solution(int n) {
        int a = 1, b = 1, c; // 피보나치 수열의 첫 두 항
        System.out.print(a + " " + b + " "); // 첫 두 항 출력
        for (int i = 2; i <= n; i++) { // 2부터 n까지 반복
            c = a + b; // 다음 항 계산
            System.out.print(c + " "); // 2 ~ n 번째 항 출력
            a = b; // a를 b로 업데이트 (이전 항)
            b = c; // b를 c로 업데이트 (현재 항)
        }
    }

    public static void main(String[] args) {
        fibonacciSequenceMain T = new fibonacciSequenceMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임

//        for (int x : T.solution(n)) {
//            System.out.print(x + " ");
//        }
        T.solution(n);
    }
}