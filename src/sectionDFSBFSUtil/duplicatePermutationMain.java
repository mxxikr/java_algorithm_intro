package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 중복 순열 구하기
 * 설명
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 입력 설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 *
 * 입력 예제1
 * 3 2
 *
 * 출력 예제1
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
public class duplicatePermutationMain {
    static int[] pm;
    static int n, m;
    public void DFS(int L) {
        if (L == m) { // 다 뽑아 냈을 경우
            for (int x : pm) { // 중복 순열을 저장한 배열을 출력
                System.out.print(x + " ");
            }
            System.out.println();

        } else { // 아직 뽑아야 할 개수가 남았을 경우 (n가닥)
            for (int i = 1; i <= n; i++) { // 1부터 N까지 반복
                pm[L] = i; // 현재 레벨에 i를 저장
                DFS(L + 1); // 다음 레벨로 이동
            }
        }
    }

    public static void main(String[] args) {
        duplicatePermutationMain T = new duplicatePermutationMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 구슬의 개수
        m = kb.nextInt(); // 뽑을 개수

        pm = new int[m]; // 중복 순열을 저장할 배열

        T.DFS(0); // DFS 시작
    }
}