package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 조합 구하기
 *
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하시오
 *
 * 입력 설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 *
 * 입력 예제 1
 * 4 2
 *
 * 출력 예제 1
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */
public class getCombinationMain {
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s) {
        for (int i = s; i <=n; i++) {
            combi[L] = i;
            if (L == m - 1) { // M개를 모두 뽑았을 경우에는 조합 완성
                for (int x : combi) {
                    System.out.print(x + " "); // 조합을 출력
                }
                System.out.println(); // 줄 바꿈
            } else {
                DFS(L + 1, i + 1); // 다음 레벨로 이동, 다음 시작 번호는 i+1
            }
        }
    }

    public static void main(String[] args) {
        getCombinationMain T = new getCombinationMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // N: 구슬의 개수
        m = kb.nextInt(); // M: 뽑을 구슬의 개수
        combi = new int[m]; // M개를 뽑을 배열 초기화
        T.DFS(0, 1); // DFS 시작, L=0(현재 레벨), s=1(시작 번호)
    }
}