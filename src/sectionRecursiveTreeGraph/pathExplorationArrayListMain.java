package sectionRecursiveTreeGraph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로 탐색(인접 리스트)
 *
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 경로의 가지 수는
 * 1 2 3 4 5
 * 1 2 5
 * 1 3 4 2 5
 * 1 3 4 5
 * 1 4 2 5
 * 1 4 5
 *
 *  <--
 * 1 --> 2 --> 5
 * | \ / ^    ^
 * v v v |  /
 * 3 --> 4
 *
 * 총 6가지 입니다.
 *
 * 입력 설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 간선의 정보가 주어진다.
 *
 * 출력 설명
 * 총 가짓 수를 출력합니다.
 *
 * 입력 예제1
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 * 출력 예제1
 * 6
 */
public class pathExplorationArrayListMain {
    /**
     * 인접 행렬로 푸는 방식은 정점의 개수가 많아지면 메모리 낭비도 심하고 시간 복잡도도 커짐
     * 1번 리스트 : 1 -> 1번 정점에서 갈 수 있는 정점들 2, 3, 4
     * 2번 리스트 : 2 -> 2번 정점에서 갈 수 있는 정점들 1, 3, 5
     * 3번 리스트 : 3 -> 3번 정점에서 갈 수 있는 정점들 4
     * 4번 리스트 : 4 -> 4번 정점에서 갈 수 있는 정점들 2, 5
     * 5번 리스트 : 5 -> 5번 정점에서 갈 수 있는 정점들 없음
     *
     * 리스트에 정점의 개수만큼 반복문을 돌면서 방문하지 않은 정점에 대해 DFS를 수행
     */
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph; // 인접 리스트를 저장할 배열
    static int[] ch;
    public void DFS(int v) {
        if (v == n) {
            answer++; // 도착 정점에 도달했을 때 가짓 수 증가
        } else {
            for (int nv : graph.get(v)) { // 현재 정점 v에서 갈 수 있는 모든 정점 nv에 대해
                if (ch[nv] == 0) { // 방문하지 않은 정점인 경우
                    ch[nv] = 1; // 방문 처리
                    DFS(nv); // 재귀 호출
                    ch[nv] = 0; // 백트래킹: 방문 상태를 되돌림
                }
            }
        }
    }

    public static void main(String[] args) {
        pathExplorationArrayListMain T = new pathExplorationArrayListMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 정점의 수
        m = kb.nextInt(); // 간선의 수

        graph = new ArrayList<ArrayList<Integer>>(); // 인접 리스트를 저장할 배열
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>()); // 각 정점에 대해 빈 리스트 생성
        }

        ch = new int[n + 1]; // 방문 여부를 체크할 배열 (0번 인덱스는 사용하지 않음)

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt(); // 시작 정점
            int b = kb.nextInt(); // 도착 정점
            graph.get(a).add(b); // a번 정점에서 b번 정점으로 가는 간선 추가
        }

        ch[1] = 1; // 시작 정점 1을 방문 처리
        T.DFS(1); // DFS 시작 (1번 정점에서 시작)
        System.out.println(answer); // 총 가짓 수 출력
    }
}