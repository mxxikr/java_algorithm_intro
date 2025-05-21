package sectionArray;

import java.util.Scanner;

/**
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 *
 * 예시 입력 1
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * 예시 출력 1
 * 155
 */
public class maxSumGridPlateMain {
    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE; // 가장 작은 값으로 초기화
        int sum1, sum2; // 행과 열의 합을 저장할 변수

        for (int i = 0; i < n; i++) { // 행의 합
            sum1 = 0; // 행의 합 초기화
            sum2 = 0; // 열의 합 초기화
            for (int j = 0; j < n; j++) { // 열의 합
                sum1 += arr[i][j]; // 행의 합
                sum2 += arr[j][i]; // 열의 합
            }
            answer = Math.max(answer, sum1); // 행의 합과 최대 값 비교
            answer = Math.max(answer, sum2); // 열의 합과 최대 값 비교
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) { // 대각선의 합
            sum1 += arr[i][i]; // 왼쪽 대각선의 합
            sum2 += arr[i][n - 1 - i]; // 오른쪽 대각선의 합
        }

        answer = Math.max(answer, sum1); // 왼쪽 대각선의 합과 최대 값 비교
        answer = Math.max(answer, sum2); // 오른쪽 대각선의 합과 최대 값 비교

        return answer;
    }

    public static void main(String[] args) {
        maxSumGridPlateMain T = new maxSumGridPlateMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[][] arr = new int[n][n]; // 2차원 배열 생성

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
