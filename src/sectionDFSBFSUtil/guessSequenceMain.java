package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 설명
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * 예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
 *
 * 3 1 2 4
 *  4 3 6
 *   7 9
 *   16
 *
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 *
 * 입력
 * 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
 * N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
 *
 * 출력
 * 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
 * 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
 *
 * 예시 입력 1
 * 4 16
 *
 * 예시 출력 1
 * 3 1 2 4
 */
public class guessSequenceMain {
    static int n, f;
    static int[] b, p, ch; // ch: 방문 여부를 저장할 배열
    boolean flag = false;
    int[][] dy = new int[35][35]; // 메모이제이션을 위한 배열

    public int combi(int n, int r) {
        if (dy[n][r] > 0) { // 이미 계산된 경우는 바로 반환
            return dy[n][r];
        }
        if (n == r || r == 0) { // n과 r이 같거나 r이 0이면 조합 수는 1
            return 1;
        } else {
            // n-1Cr-1 + n-1Cr
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r); // n-1에서 r-1을 뽑는 경우 + n-1에서 r을 뽑는 경우
        }
    }

    public void DFS(int L, int sum){
        if (flag) {
            return; // 이미 답을 찾은 경우 더 이상 탐색하지 않도록 함
        }
        if (L == n) { // L과 n이 같으면(모든 숫자를 다 뽑았을 때)
            if (sum == f) { // 합이 최종 값과 같으면
                for (int x : p) {
                    System.out.print(x + " "); // 순열을 출력
                }
                flag = true; // 답을 찾았으므로 flag를 true로 설정
            }
        } else {
            for (int i = 1; i <= n; i++) { // 1부터 n까지의 순열 생성
                if (ch[i] == 0) { // 사용하지 않았을 경우
                    ch[i] = 1; // 사용 표시
                    p[L] = i; // 현재 레벨에 해당 숫자를 저장
                    DFS(L + 1, sum + (p[L] * b[L])); // 다음 레벨로 이동하고 현재 숫자를 곱한 값을 합에 더함
                    ch[i] = 0; // 백트래킹: 사용 표시 해제 -> 다른 숫자를 사용할 수 있게 함
                }
            }
        }
    }

    public static void main(String[] args) {
        guessSequenceMain T = new guessSequenceMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1]; // 1부터 n까지의 숫자를 사용하므로 n+1 크기의 배열을 사용

        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }

        T.DFS(0, 0);
    }
}