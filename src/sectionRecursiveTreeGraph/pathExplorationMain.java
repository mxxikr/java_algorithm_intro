package sectionRecursiveTreeGraph;

import java.util.Scanner;

/**
 * 경로 탐색(인접 행렬)
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
 * 첫째 줄에는 정점의 수 N(2<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 간선의 정보가 주어진다.
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
public class pathExplorationMain {
    /**
     * 그래프에서 한번 방문한 노드는 다시 방문하지 않도록 해야 함
     * D(1) -> 노드 개수만큼 for문 돌아야함
     *      -> D(2) -> 노드 개수만큼 for문 돌아야함
     *              -> D(3) -> 노드 개수만큼 for문 돌아야함
     *                      ->  D(4) -> 노드 개수만큼 for문 돌아야함
     *                               -> D(5) -> 경로 체크
     *              -> D(5) -> 경로 체크
     *      -> D(3) -> 노드 개수만큼 for문 돌아야함
     *              -> D(4) -> 노드 개수만큼 for문 돌아야함
     *                      -> D(5) -> 경로 체크
     *                      -> D(2) -> D(5) -> 경로 체크
     *      -> D(4) -> 노드 개수만큼 for문 돌아야함
     *              -> D(5) -> 경로 체크
     *              -> D(2) -> D(5) -> 경로 체크
     */
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v) {
        if (v == n) {
            answer++; // 도착 정점에 도달했을 때 가짓 수 증가
        } else {
            for (int i = 1; i <= n; i++) { // 모든 정점에 대해 탐색
                if (graph[v][i] == 1 && ch[i] == 0) { // 간선이 존재하고 방문하지 않은 정점인 경우
                    ch[i] = 1; // 방문 처리
                    DFS(i); // 다음 정점으로 이동
                    ch[i] = 0; // 백트래킹: 방문 상태를 되돌림
                }
            }
        }
    }

    public static void main(String[] args) {
        pathExplorationMain T = new pathExplorationMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 정점의 수
        m = kb.nextInt(); // 간선의 수
        graph = new int[n + 1][n + 1]; // 인접 행렬 생성 (0번 인덱스는 사용하지 않음)
        ch = new int[n + 1]; // 방문 여부를 체크할 배열 (0번 인덱스는 사용하지 않음)

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt(); // 시작 정점
            int b = kb.nextInt(); // 도착 정점
            graph[a][b] = 1; // 간선이 존재함을 표시
        }

        ch[1] = 1; // 시작 정점 1을 방문 처리
        T.DFS(1); // DFS 시작 (1번 정점에서 시작)
        System.out.println(answer); // 총 가짓 수 출력
    }
}