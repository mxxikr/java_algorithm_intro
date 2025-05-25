package sectionTwoPointersSlidingWindow;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 설명
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 * 예시 입력 1
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 *
 * 예시 출력 1
 * 2 3 5
 */
public class findCommonElementMain {
    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0; // 포인터 초기화

        // 두 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        Arrays.sort(arr2);

        while (p1 < n && p2 < m) {
            if (arr[p1] == arr2[p2]) {
                answer.add(arr[p1++]); // 두 배열의 원소가 같으면 공통 원소로 추가
                p2++; // 포인터 증가
            } else if (arr[p1] < arr2[p2]) {
                p1++; // arr의 원소가 더 작으면 arr의 포인터 증가
            } else {
                p2++; // arr2의 원소가 더 작으면 arr2의 포인터 증가
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        findCommonElementMain T = new findCommonElementMain(); // 객체 생성
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
