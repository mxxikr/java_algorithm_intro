package sectionRecursiveTreeGraph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프 최단 거리(BFS)
 *
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하세요.
 *
 * 1 <-- 2 --> 5
 * | \    ^ ^  ^
 * v   v  /  \ |
 * 3 --> 4 --> 6
 *
 * 입력 설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)과 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 간선의 정보가 주어진다.
 *
 * 출력 설명
 * 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
 *
 * 입력 예제1
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 *
 * 출력 예제1
 * 2 : 3
 * 3 : 1
 * 4 : 1
 * 5 : 2
 * 6 : 2
 */
public class graphShortestDistanceMain {
    /**
     * 레벨로 표현
     * 
     * 0 레벨         1
     *             /   \
     * 1 레벨      3     4
     *                 / \
     * 2 레벨          5   6
     *                     \
     * 3 레벨                2
     *
     * 배열로 표현
     * 1 2 3 4 5 6
     * 0 3 1 1 2 2
     *
     * dis[3] = 1; // 1번 정점에서 3번 정점으로 가는 최소 이동 간선 수는 1
     * dis[4] = 1; // 1번 정점에서 4번 정점으로 가는 최소 이동 간선 수는 1
     * dis[5] = 2; // 1번 정점에서 5번 정점으로 가는 최소 이동 간선 수는 2
     * dis[6] = 2; // 1번 정점에서 6번 정점으로 가는 최소 이동 간선 수는 2
     * dis[2] = 3; // 1번 정점에서 2번 정점으로 가는 최소 이동 간선 수는 3
     * dis[nv] = dis[v] + 1; // 현재 정점 v에서 다음 정점 nv로 이동할 때 간선 수를 1 증가시킴
     */
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph; // 인접 리스트를 저장할 배열
    static int[] ch, dis; // 방문 여부를 체크할 배열과 각 정점까지의 최소 이동 간선 수를 저장할 배열

    public void BFS(int v) {
        Queue<Integer> queue = new java.util.LinkedList<>();
        ch[v] = 1; // 시작 정점 v를 방문 처리
        dis[v] = 0; // 시작 정점 v까지의 최소 이동 간선 수는 0
        queue.offer(v); // 시작 정점을 큐에 추가

        while(!queue.isEmpty()) {
            int cv = queue.poll(); // 현재 정점 cv를 큐에서 꺼냄
            for (int nv : graph.get(cv)) { // 현재 정점 cv에서 갈 수 있는 모든 정점 nv에 대해
                if (ch[nv] == 0) { // nv가 아직 방문하지 않은 정점이라면
                    ch[nv] = 1; // nv를 방문 처리
                    queue.offer(nv); // nv를 큐에 추가
                    dis[nv] = dis[cv] + 1; // nv까지의 최소 이동 간선 수는 현재 정점 cv까지의 간선 수 + 1
                }
            }
        }
    }

    public static void main(String[] args) {
        graphShortestDistanceMain T = new graphShortestDistanceMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 정점의 수
        m = kb.nextInt(); // 간선의 수

        graph = new ArrayList<ArrayList<Integer>>(); // 인접 리스트를 저장할 배열
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>()); // 각 정점에 대해 빈 리스트 생성
        }

        ch = new int[n + 1]; // 방문 여부를 체크할 배열 (0번 인덱스는 사용하지 않음)
        dis = new int[n + 1]; // 각 정점까지의 최소 이동 간선 수를 저장할 배열 (0번 인덱스는 사용하지 않음)

        for (int i = 0; i < m; i++) { // 인접 리스트 구성
            int a = kb.nextInt(); // 시작 정점
            int b = kb.nextInt(); // 도착 정점
            graph.get(a).add(b); // a번 정점에서 b번 정점으로 가는 간선 추가
        }

        ch[1] = 1; // 시작 정점 1을 방문 처리
        T.BFS(1); // DFS 시작 (1번 정점에서 시작)
        for(int i = 2; i <= n; i++) { // 2번 정점부터 n번 정점까지의 최소 이동 간선 수 출력
            System.out.println(i + " : " + dis[i]); // 각 정점 i까지의 최소 이동 간선 수 출력
        }
    }
}