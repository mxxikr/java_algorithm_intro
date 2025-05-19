package sectionArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 *
 * 예시 입력 1
 * 6
 * 7 3 9 5 6 12
 *
 * 예시 출력 1
 * 7 9 6 12
 */
public class printBigNumMain {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) { // i-1번째 인덱스의 값이 i번째 인덱스의 값보다 작으면
                answer.add(arr[i]); // i번째 인덱스의 값을 추가
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        printBigNumMain T = new printBigNumMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
