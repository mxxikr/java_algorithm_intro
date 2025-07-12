package sectionDynamicProgramming;

import java.util.Scanner;

/**
 * 최대 부분 증가수열
 *
 * 설명
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
 * 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
 * 길이가 5인 최대 부분 증가수열을 만들 수 있다.
 *
 * 입력
 * 첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,
 * 둘째 줄은 N개의 입력데이터들이 주어진다.
 *
 * 출력
 * 첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.
 *
 * 예시 입력 1
 * 8
 * 5 3 7 8 6 2 9 4
 *
 * 예시 출력 1
 * 4
 */
public class maxIncreasingSubsequenceMain {
    static int[] dy;
    public int solution(int[] arr) {
        int answer = 0; // 최대 부분 증가수열의 길이
        dy = new int[arr.length]; // 배열 초기화
        dy[0] = 1; // 첫 번째 원소는 항상 부분 증가수열의 길이가 1

        answer = dy[0]; // 길이 1 값이 들어 올 경우를 위해 초기값 설정
        for(int i = 1; i < arr.length; i++) {
            int max = 0; // 부분 증가수열의 길이가 최소 1이기 때문에 0으로 초기화
            for (int j = i -1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) { // j번째 원소가 i번째 원소보다 작고, dy[j]가 현재 max보다 크면
                    max = dy[j]; // max를 갱신
                }
            }
            dy[i] = max + 1; // 현재 원소의 부분 증가수열 길이는 max + 1
            answer = Math.max(answer, dy[i]); // 최대 부분 증가수열 길이 갱신
        }

        return answer;
    }

    public static void main(String[] args) {
        maxIncreasingSubsequenceMain T = new maxIncreasingSubsequenceMain();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력되는 데이터의 수
        int[] arr = new int[n]; // 입력 데이터 배열

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 입력 데이터 저장
        }

        System.out.println(T.solution(arr));
    }
}