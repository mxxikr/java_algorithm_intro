package sectionArray;

import java.util.Scanner;

/**
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 *
 * 예시 입력 1
 * 20
 *
 * 예시 출력 1
 * 8
 */
public class primeNumMain {
    public int solution(int n) {
        int answer = 0; // 소수의 개수를 저장할 변수
        int[] ch = new int[n + 1]; // 0~n까지 숫자가 소수인지 체크하는 배열

        for (int i = 2; i < n; i++) { // 2부터 n-1까지 반복
            if (ch[i] == 0) { // i가 소수인 경우
                answer++; // 소수 개수 증가
                for (int j = i; j < n; j += i) { // i의 배수는 소수가 아니므로
                    ch[j] = 1; // 체크 배열에 표시
                }
            }
        }

        return answer; // 소수의 개수를 반환
    }

    public static void main(String[] args) {
        primeNumMain T = new primeNumMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임

        System.out.println(T.solution(n));
    }
}
