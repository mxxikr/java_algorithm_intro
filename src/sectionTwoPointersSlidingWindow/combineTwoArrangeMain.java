package sectionTwoPointersSlidingWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 예시 입력 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 예시 출력 1
 * 1 2 3 3 5 6 7 9
 */
public class combineTwoArrangeMain {
    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0; // 포인터 초기화

        while (p1 < n && p2 < m) {
            if (arr[p1] < arr2[p2]) {
                answer.add(arr[p1++]); // arr의 원소가 더 작으면 arr의 원소를 추가하고 포인터 증가
            } else {
                answer.add(arr2[p2++]); // arr2의 원소가 더 작거나 같으면 arr2의 원소를 추가하고 포인터 증가
            }
        }

        // 남은 원소들을 추가
        while (p1 < n) {
            answer.add(arr[p1++]); // arr의 남은 원소들을 추가
        }

        while (p2 < m) {
            answer.add(arr2[p2++]); // arr2의 남은 원소들을 추가
        }

        return answer;
    }

    public static void main(String[] args) {
        combineTwoArrangeMain T = new combineTwoArrangeMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int m = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr2 = new int[m]; // 배열 생성

        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, m, arr, arr2));
    }
}