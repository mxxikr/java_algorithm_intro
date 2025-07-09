package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 조합의 경우 수(메모이제이션)
 *
 * nCr = n! / (r! * (n-r)!) 로 계산합니다.
 * 하지만 여러분은 이 공식을 쓰지 않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 *
 * nCr = n-1Cr-1 + n-1Cr
 *
 * 입력 설명
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 *
 * 출력 설명
 * 첫째 줄에 조합 수를 출력합니다.
 *
 * 입력 예제1
 * 5 3
 *
 * 출력 예제1
 * 10
 *
 * 입력 예제2
 * 33 19
 *
 * 출력 예제2
 * 818809200
 */
public class combinationNumOfCaseMain {
    /**
     * 5C3 = 4C2 + 4C3
     * {1, 2, 3, 4, 5}
     * 5가 포함 된 경우의 수 + 5가 포함 되지 않은 경우의 수
     * {1, 2, 3, 4}에서 2개를 뽑는 경우의 수 + {1, 2, 3, 4}에서 3개를 뽑는 경우의 수
     */
    int[][] dy = new int[35][35]; // 메모이제이션을 위한 배열
    public int DFS(int n, int r){
        if (dy[n][r] > 0) { // 이미 계산된 경우는 바로 반환
            return dy[n][r];
        }
        if (n == r || r == 0) { // n과 r이 같거나 r이 0이면 조합 수는 1
            return 1;
        } else {
            // n-1Cr-1 + n-1Cr
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); // n-1에서 r-1을 뽑는 경우 + n-1에서 r을 뽑는 경우
        }
    }

    public static void main(String[] args) {
        combinationNumOfCaseMain T = new combinationNumOfCaseMain();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));

    }
}