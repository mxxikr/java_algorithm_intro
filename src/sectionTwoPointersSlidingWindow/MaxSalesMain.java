package sectionTwoPointersSlidingWindow;

import java.util.*;

/**
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * 예시 입력 1
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 예시 출력 1
 * 56
 */
public class MaxSalesMain {
    public int solution(int n, int m, int[] arr) {
        int sum = arr[0] + arr[1] + arr[2]; // 초기 값 설정, 첫 3일의 매출액 합
        int answer = sum;

        for (int i = 3; i < n; i++) {
            sum += arr[i]; // 현재 매출액을 합에 추가
            sum -= arr[i - m]; // m일 전의 매출액을 빼기
            answer = Math.max(answer, sum); // 최대 매출액 갱신
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxSalesMain T = new MaxSalesMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int m = kb.nextInt(); // 숫자 하나 읽어들임

        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, m, arr));
    }
}