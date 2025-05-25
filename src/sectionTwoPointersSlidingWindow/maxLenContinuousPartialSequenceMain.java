package sectionTwoPointersSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 1 1 0 0 [ 1 1 1 1 1 1 1 1 ] 0 1
 * 이며 그 길이는 8입니다.
 *
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 * 예시 입력 1
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 예시 출력 1
 * 8
 */
public class maxLenContinuousPartialSequenceMain {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) { // rt가 0인 경우
                cnt++; // 0의 개수 증가
            }

            while (cnt > k) { // 0의 개수가 k보다 작아야함
                if (arr[lt] == 0) { // lt가 0인 경우
                    cnt--; // 0의 개수 감소
                }
                lt++; // 왼쪽 포인터 증가
            }

            answer = Math.max(answer, rt - lt + 1); // 현재 연속 부분 수열의 길이를 계산하여 최대 값 갱신
        }

        return answer;
    }

    public static void main(String[] args) {
        maxLenContinuousPartialSequenceMain T = new maxLenContinuousPartialSequenceMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int k = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, k, arr));
    }
}