package sectionSortingAndSearching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 설명
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 선택정렬입니다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 * 출력
 * 오름차순으로 정렬된 수열을 출력합니다.
 *
 *
 * 예시 입력 1
 * 6
 * 13 5 11 7 23 15
 *
 * 예시 출력 1
 * 5 7 11 13 15 23
 */
public class selectionSortMain {
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) { // 마지막 원소는 이미 정렬되어 있으므로 n-1까지 반복
            int idx = i; // 현재 위치의 인덱스를 저장
            for (int j = i + 1; j < n; j++) { // 현재 위치 다음부터 끝까지 반복
                if (arr[j] < arr[idx]) { // 현재 위치의 값보다 작은 값이 있으면
                    idx = j; // 작은 값의 인덱스를 저장
                }
            }
            // 현재 위치의 값과 작은 값의 위치를 바꿈
            int tmp = arr[i];
            arr[i] = arr[idx]; // 현재 위치에 작은 값을 넣음
            arr[idx] = tmp; // 작은 값의 위치에 현재 위치의 값을 넣음
        }

        return arr;
    }

    public static void main(String[] args) {
        selectionSortMain T = new selectionSortMain(); // 객체 생성
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