package sectionGreedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 원더랜드(최소스패닝트리: 프림, PriorityQueue)
 *
 * 설명
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 * 아래의 그림은 그 한 예를 설명하는 그림이다.
 * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
 *
 *  src/sectionGreedyAlgorithm/WonderLandMSTKruskal.jpg 참고
 *
 * 입력
 * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
 * 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 * 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 *
 * 출력
 * 모든 도시를 연결하면서 드는 최소비용을 출려한다.
 *
 * 예시 입력 1
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 *
 * 예시 출력 1
 * 196
 */
class WonderPrimEdge implements Comparable<WonderPrimEdge> {
    public int vex; // 정점
    public int cost; // 비용

    WonderPrimEdge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(WonderPrimEdge ob) {
        return this.cost - ob.cost; // 비용이 작은 순서로 정렬(오름차순)
    }
}

class WonderLandMSTPrimMain {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시의 개수
        int m = kb.nextInt(); // 도로의 개수
        ArrayList<ArrayList<WonderPrimEdge>> graph = new ArrayList<ArrayList<WonderPrimEdge>>(); // 그래프 표현(인접 리스트)

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<WonderPrimEdge>()); // 각 도시(정점)에 대한 인접 리스트 초기화
        }

        int[] ch = new int[n + 1]; // 방문 여부 체크

        for (int i = 0; i < m; i++) { // 인접 리스트에 도로 정보 추가
            int a = kb.nextInt(); // 도시
            int b = kb.nextInt(); // 도시
            int c = kb.nextInt(); // 유지비용
            graph.get(a).add(new WonderPrimEdge(b, c));
            graph.get(b).add(new WonderPrimEdge(a, c)); // 무방향 그래프이므로 양방향 추가
        }

        int answer = 0; // 최소 비용
        PriorityQueue<WonderPrimEdge> pQ = new PriorityQueue<WonderPrimEdge>(); // 우선순위 큐
        pQ.offer(new WonderPrimEdge(1, 0)); // 시작 정점(1번 도시)과 비용 0을 큐에 추가

        while (!pQ.isEmpty()) {
            WonderPrimEdge tmp = pQ.poll(); // 비용이 가장 작은 정점 꺼내기
            int vex = tmp.vex; // 현재 정점
            if (ch[vex] == 0) { // 회로 방지
                ch[vex] = 1; // 방문 처리
                answer += tmp.cost; // 최소 비용에 현재 비용 추가
                for (WonderPrimEdge ob : graph.get(vex)) { // 현재 정점과 연결된 모든 정점 탐색
                    if (ch[ob.vex] == 0) { // 방문하지 않은 정점만 큐에 추가
                        pQ.offer(new WonderPrimEdge(ob.vex, ob.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}