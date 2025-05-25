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
public class continuousNaturalNumSumMain {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1; // n을 2로 나눈 몫 + 1, lt가 m보다 커지면 더 이상 합을 구할 필요 없음
        int[] arr = new int[m];

        for (int i = 0; i < m; i++){ // 1부터 m까지의 자연수 배열 생성
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum+= arr[rt]; // lt부터 rt까지의 합을 구함

            if (sum == n) { // n과 같은지 확인
                answer++; // 현재 합이 n과 같으면 경우의 수 증가
            }

            while (sum >= n) { // n보다 같거나 크면 lt를 빼고 lt를 증가 시킴
                sum -= arr[lt++]; // 현재 합이 n보다 크면 왼쪽 포인터를 증가시켜서 합을 줄임
                if (sum == n) { // 줄인 후에 다시 n과 같은지 확인
                    answer++; // 현재 합이 n과 같으면 경우의 수 증가
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        continuousNaturalNumSumMain T = new continuousNaturalNumSumMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임

        System.out.print(T.solution(n));
    }
}