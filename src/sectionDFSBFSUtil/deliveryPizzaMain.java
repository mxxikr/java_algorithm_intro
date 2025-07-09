package sectionDFSBFSUtil;

/**
 * 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
 *
 * 설명
 * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
 * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
 * 예를 들어, 도시의 지도가 아래와 같다면
 *
 * 0 1 0 0
 * 0 0 2 1
 * 0 0 1 0
 * 1 2 0 2
 *
 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
 * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 *
 * 입력
 * 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
 * 둘째 줄부터 도시 정보가 입력된다.
 *
 * 출력
 * 첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
 *
 * 예시 입력 1
 * 4 4
 * 0 1 2 0
 * 1 0 2 1
 * 0 2 1 2
 * 2 0 1 2
 *
 * 예시 출력 1
 * 6
 */
import java.util.*;

class pizzaPoint {
    public int x, y;

    pizzaPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class deliveryPizzaMain {
    static int n, m, len, answer = Integer.MAX_VALUE; // 도시 크기, 살릴 피자집 개수, 피자집 개수, 최소 피자 배달 거리
    static int[] combi; // 피자집 조합을 저장할 배열
    static ArrayList<pizzaPoint> pz, hs; // 피자집과 집의 좌표를 저장하는 리스트

    public void DFS(int L, int s) {
        if (L == m) { // M개의 피자집을 선택했을 때(조합 완성)
            for (int x: combi) {
//                System.out.print(x + " "); // 선택된 피자집 인덱스 출력
                int sum = 0; // 도시의 피자 배달 거리 초기화
                for (pizzaPoint home : hs) { // 각 집에 대해
                    int minDist = Integer.MAX_VALUE; // 해당 집의 최소 피자 배달 거리 초기화
                    for (int i : combi) { // 선택된 피자집들에 대해(조합 인덱스 번호)
                        pizzaPoint pizza = pz.get(i); // 피자집 좌표 가져오기
                        int dist = Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y); // 피자 배달 거리 계산
                        minDist = Math.min(minDist, dist); // 최소 거리 갱신
                    }
                    sum += minDist; // 해당 집의 최소 배달 거리를 도시의 총 배달 거리로 합산
                }
                answer = Math.min(answer, sum); // 전체 도시의 최소 피자 배달 거리 갱신
            }
        } else { // M개를 선택하지 못했을 때
            for (int i = s; i < len; i++) { // 피자집 조합 생성
                combi[L] = i; // 현재 레벨에 해당 피자집 인덱스 저장
                DFS(L + 1, i + 1); // 다음 레벨로 이동
            }
        }
    }

    public static void main(String[] args) {
        deliveryPizzaMain T = new deliveryPizzaMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 도시 크기 N
        m = kb.nextInt(); // 살릴 피자집 개수 M
        pz = new ArrayList<>(); // 피자집 좌표 리스트
        hs = new ArrayList<>(); // 집 좌표 리스트

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int tmp = kb.nextInt(); // 도시 정보 입력
                if (tmp == 1) { // 집인 경우
                    hs.add(new pizzaPoint(i, j)); // 집 좌표 추가
                } else if (tmp == 2) { // 피자집인 경우
                    pz.add(new pizzaPoint(i, j)); // 피자집 좌표 추가
                }
            }
        }
        len = pz.size(); // 피자집 개수
        combi = new int[m]; // 피자집 조합을 저장할 배열 초기화
        T.DFS(0, 0); // DFS 시작, L=0(현재 레벨), s=0(시작 번호)
        System.out.println(answer); // 최소 피자 배달 거리 출력
    }
}