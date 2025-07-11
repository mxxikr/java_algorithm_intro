package sectionGreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * 원더랜드(최소스패닝트리: 크루스칼, Union-Find 활용)
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
class WonderEdge implements Comparable<WonderEdge> {
    public int v1; // 시작 정점
    public int v2; // 끝 정점
    public int cost; // 간선 가중치

    WonderEdge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(WonderEdge ob) { // 간선 가중치 기준으로 오름차순 정렬
        return this.cost - ob.cost; // 양수면 this가 크고, 음수면 ob가 크고, 0이면 같음
    }
}

public class WonderLandMSTKruskalMain {
    /**
     * 그래프와 트리의 차이점
     * 그래프는 회로가 존재하지만 트리는 회로가 존재하지 않는 연결된 그래프임
     * 트리는 회로가 없는 그래프이므로 트리의 간선의 개수는 항상 V-1개임
     *
     * 크루스칼 알고리즘
     * 1. 간선을 가중치의 오름차순으로 정렬함
     * 2. 간선을 하나씩 확인하며 사이클이 발생하지 않는다면 트리에 포함시킴
     *  - 사이클을 확인하기 위해 Union-Find 자료구조를 사용함
     * 3. 모든 노드가 연결될 때까지 반복함
     */
    static int[] unf;
    public static int Find(int v) {
        if (unf[v] == v) {
            return v; // 자기 자신이 부모 노드인 경우
        } else {
            return unf[v] = Find(unf[v]); // 경로 압축
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a); // a의 부모 노드 찾기
        int fb = Find(b); // b의 부모 노드 찾기
        if (fa != fb) { // 부모 노드가 다르면 합침
            unf[fa] = fb; // a의 부모를 b로 설정
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시의 개수
        int m = kb.nextInt(); // 도로의 개수
        unf = new int[n + 1]; // 1부터 n까지의 도시 번호를 사용하므로 n+1 크기의 배열 생성
        ArrayList<WonderEdge> arr = new ArrayList<>(); // 간선 정보를 저장할 리스트

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt(); // 시작 도시
            int b = kb.nextInt(); // 끝 도시
            int c = kb.nextInt(); // 유지 비용
            arr.add(new WonderEdge(a, b, c)); // 간선 정보 추가
        }

        int answer = 0; // 최소 비용 초기화
        int cnt = 0; // 연결된 간선의 개수 초기화
        Collections.sort(arr); // 간선을 가중치 기준으로 오름차순 정렬
        for (WonderEdge ob : arr) {
            if (cnt == n - 1) { // 모든 도시가 연결되었으면 종료
                break;
            }
            int fv1 = Find(ob.v1); // 시작 도시의 부모 노드 찾기
            int fv2 = Find(ob.v2); // 끝 도시의 부모 노드 찾기
            if (fv1 != fv2) { // 같은 집합이 아닐 경우
                answer += ob.cost; // 최소 비용에 간선 가중치 추가
                cnt++;// 연결된 간선의 개수 증가
                Union(ob.v1, ob.v2); // 두 도시를 합침
            }
        }

        System.out.println(answer);
    }
}