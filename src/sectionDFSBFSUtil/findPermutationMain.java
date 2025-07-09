package sectionDFSBFSUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 순열 구하기
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 입력 설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 *
 * 입력 예제1
 * 3 2
 * 3 6 9
 *
 * 출력 예제1
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 */
public class findPermutationMain {
    /**
     * 순열
     * N개 중에서 M개를 순서 있게 골라 일렬로 배열하는 것
     *
     * DFS(재귀) & 백트래킹 이용
     * - 현재 위치(L)에서 사용할 수 있는 모든 숫자를 하나씩 선택(반복문)
     * - 이미 쓴 숫자는 제외(방문 체크)
     * - 다음 위치(L+1)로 이동해 또 동일한 과정을 반복
     * - M개를 다 뽑았다면(=재귀 끝까지 내려옴) 한 줄 출력
     * - 출력 뒤에는 방문 해제(백트래킹) : 다른 경로에서 다시 쓸 수 있게 함
     */
    static int[] pm, ch, arr; // pm: 순열을 저장할 배열, ch: 방문 여부를 저장할 배열, arr: 입력받은 자연수 배열
    static int n, m;

    public void DFS(int L){
        if (L == m) { // m개를 모두 뽑았을 경우
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println(); // 순열을 출력
        } else {
            for (int i = 0; i < n; i++) { // 0부터 n-1까지 반복
                if (ch[i] == 0) { // 방문하지 않은 경우
                    ch[i] = 1; // 방문 표시
                    pm[L] = arr[i]; // 현재 레벨에 해당 자연수를 저장
                    DFS(L + 1); // 다음 레벨로 이동
                    ch[i] = 0; // 백트래킹: 방문 표시 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        findPermutationMain T = new findPermutationMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 자연수의 개수
        m = kb.nextInt(); // 뽑을 개수

        arr = new int[n]; // 자연수를 저장할 배열
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        ch = new int[n]; // 방문 여부를 저장할 배열
        pm = new int[m]; // 순열을 저장할 배열

        T.DFS(0); // DFS 시작
    }
}