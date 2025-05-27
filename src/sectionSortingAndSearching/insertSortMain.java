package sectionSortingAndSearching;

import java.util.Scanner;

/**
 * 설명
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 삽입정렬입니다.
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
 * 11 7 5 6 10 9
 *
 * 예시 출력 1
 * 5 6 7 9 10 11
 */
public class insertSortMain {
    public int[] solution(int n, int[] arr) {
        // 삽입 정렬 : 배열의 두 번째 원소부터 시작하여, 현재 원소를 임시 변수에 저장하고 이전 원소들과 비교하여 적절한 위치에 삽입하는 방식
        for (int i = 1; i < n; i++) { // 두 번째 원소부터 시작
            int tmp = arr[i], j; // 현재 원소를 임시 변수에 저장
            for (j = i - 1; j >= 0; j--) { // 현재 원소의 이전 원소들과 비교
                if (arr[j] > tmp) { // 현재 원소보다 큰 경우
                    arr[j + 1] = arr[j]; // 현재 원소를 한 칸 뒤로 이동
                } else {
                    break; // 더 이상 비교할 필요 없음
                }
            }
            arr[j + 1] = tmp; // 현재 원소를 적절한 위치에 삽입
        }

        return arr;
    }

    public static void main(String[] args) {
        insertSortMain T = new insertSortMain(); // 객체 생성
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