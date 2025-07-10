package sectionGreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘
 *
 * 아래의 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리 비용을 출력하는 프로그램을 작성하세요.
 * (경로가 없으면 impossible을 출력한다.
 *
 *   <---2----
 *  1 ---12---> 2 ---5---> 3
 *  |         / ^       / ^
 *  4       5   |     5
 *  |     /     2   /
 *  v v /       | /
 *  3 ---5---> 4 <---5--- 6
 *
 * 입력 설명
 * 첫째 줄에는 정점의 수 N(1 <= N <= 20)과 간선의 수 M이 주어집니다.
 * 그 다음부터 M줄에 걸쳐 연결 정보와 거리 비용이 주어진다.
 *
 * 출력 설명
 * 1번 정점에서 각 정점으로 가는 최소 비용을 2번 정점부터 차례대로 출력하세요
 *
 * 입력예제 1
 * 6 9
 * 1 2 12   // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 *
 * 출력예제 1
 * 2 : 11
 * 3 : 4
 * 4 : 9
 * 5 : 14
 * 6 : impossible
 */

class Edge implements Comparable<Edge> {
    public int vex; // 정점
    public int cost; // 비용(간선의 가중치)

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost; // 비용이 작은 순서로 정렬(오름차순)
    }
}

public class DijkstraAlgorithmMain {
    /**
     * 다익스트라 알고리즘
     * 최단 거리 탐색을 할 때 사용
     * 비용이 가장 적은 순서대로 방문하면서 이 전까지 들었던 비용 + 앞으로 들었던 비용 계산해 가장 비용이 적은 경로만 저장
     *
     */
    static int n, m; // 정점의 수, 간선의 수
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0)); // 시작 정점과 비용 0
        dis[v] = 0;
        while(!pQ.isEmpty()){ // 우선순위 큐가 비어있지 않으면
            Edge tmp = pQ.poll(); // 비용이 가장 작은 정점 꺼내기
            int now = tmp.vex; // 현재 정점
            int nowCost = tmp.cost; // 현재 정점까지의 비용
            if(nowCost > dis[now]) continue; // 현재 정점까지의 비용이 이미 기록된 비용보다 크면 무시
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithmMain T = new DijkstraAlgorithmMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 정점의 수
        m = kb.nextInt(); // 간선의 수
        graph = new ArrayList<ArrayList<Edge>>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n + 1]; // 시작 정점에서 각 정점으로 가는 최소 비용
        Arrays.fill(dis, Integer.MAX_VALUE); // 초기화
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt(); // 시작 정점
            int b = kb.nextInt(); // 도착 정점
            int c = kb.nextInt(); // 비용(가중치)
            graph.get(a).add(new Edge(b, c)); // 방향 그래프이므로 a에서 b로 가는 간선 추가
        }

        T.solution(1); // 1번 정점에서 시작
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }

        }
    }
}