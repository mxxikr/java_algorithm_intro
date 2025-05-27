package sectionSortingAndSearching;

import java.util.Scanner;

/**
 * 설명
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 버블정렬입니다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 * 출력
 * 오름차순으로 정렬된 수열을 출력합니다.
 *
 * 예시 입력 1
 * 6
 * 13 5 11 7 23 15
 *
 * 예시 출력 1
 * 5 7 11 13 15 23
 */
public class bubbleSortMain {
    public int[] solution(int n, int[] arr) {
        // 버블 정렬 : 인접한 두 원소를 비교하여 정렬하는 알고리즘
        for (int i = 0; i < n - 1; i++) { // n-1번 반복
            for (int j = 0; j < n - i - 1; j++) { // i번째 원소까지는 이미 정렬되어 있으므로 n-i-1까지 반복
                if (arr[j] > arr[j + 1]) { // 현재 원소가 다음 원소보다 크면
                    int temp = arr[j]; // 두 원소를 교환
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        bubbleSortMain T = new bubbleSortMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}