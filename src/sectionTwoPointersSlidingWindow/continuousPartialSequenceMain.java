package sectionTwoPointersSlidingWindow;

import java.util.Scanner;

/**
 * 설명
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * 입력
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 * 출력
 * 첫째 줄에 경우의 수를 출력한다.
 *
 * 예시 입력 1
 * 8 6
 * 1 2 1 3 1 1 1 2
 *
 * 예시 출력 1
 * 3
 */
public class continuousPartialSequenceMain {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) { // rt 증가
            sum += arr[rt]; // lt부터 rt까지의 합을 구함

            if (sum == m) { // m과 같은지 확인
                answer++; // 현재 합이 m과 같으면 경우의 수 증가
            }
            while (sum >= m) { // m보다 같거나 크면 lt를 빼고 lt를 증가 시킴
                sum -= arr[lt++]; // 현재 합이 m보다 크면 왼쪽 포인터를 증가시켜서 합을 줄임
                if (sum == m) { // 줄인 후에 다시 m과 같은지 확인
                    answer++; // 현재 합이 m과 같으면 경우의 수 증가
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        continuousPartialSequenceMain T = new continuousPartialSequenceMain(); // 객체 생성
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