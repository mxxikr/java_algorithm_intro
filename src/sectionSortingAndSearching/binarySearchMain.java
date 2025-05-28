package sectionSortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 설명
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 *
 * 입력
 * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 *
 * 출력
 * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 *
 * 예시 입력 1
 * 8 32
 * 23 87 65 12 57 32 99 81
 *
 * 예시 출력 1
 * 3
 */
public class binarySearchMain {
    public int solution(int n, int[] arr, int m) {
        int answer = 0;

        Arrays.sort(arr); // 배열을 오름차순으로 정렬
        int lt = 0, rt = n - 1; // lt는 시작 인덱스, rt는 끝 인덱스

        while (lt <= rt) { // lt가 rt보다 작거나 같을 때까지 반복
            int mid = (lt + rt) / 2; // 중간 인덱스 계산

            if (arr[mid] == m) { // 중간 값이 m과 같으면
                answer = mid + 1; // 위치는 인덱스 + 1 (1부터 시작하므로)
                break; // 찾았으므로 반복 종료
            } else if (arr[mid] > m) { // 중간 값이 m보다 크면
                rt = mid - 1; // 오른쪽 부분을 제외
            } else { // 중간 값이 m보다 작으면
                lt = mid + 1; // 왼쪽 부분을 제외
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        binarySearchMain T = new binarySearchMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        int m  = kb.nextInt();
        int[] arr = new int[n]; // 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        System.out.println(T.solution(n, arr, m));
    }
}