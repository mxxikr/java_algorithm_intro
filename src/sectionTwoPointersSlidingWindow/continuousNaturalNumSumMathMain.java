package sectionTwoPointersSlidingWindow;

import java.util.Scanner;

/**
 * 설명
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 * 예시 입력 1
 * 15
 *
 * 예시 출력 1
 * 3
 */
public class continuousNaturalNumSumMathMain {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--;

        while (n > 0) {
            cnt++; // 연속된 자연수의 개수 증가
            n = n - cnt; // n에서 연속된 자연수의 합을 빼줌
            if (n % cnt == 0) { // n이 cnt로 나누어 떨어지면
//                System.out.println(n + " " + cnt);
                answer++; // 경우의 수 증가
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        continuousNaturalNumSumMathMain T = new continuousNaturalNumSumMathMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임

        System.out.print(T.solution(n));
    }
}