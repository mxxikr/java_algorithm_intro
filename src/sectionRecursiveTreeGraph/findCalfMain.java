package sectionRecursiveTreeGraph;

import java.util.Queue;
import java.util.Scanner;

/**
 * 설명
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
 *
 * 출력
 * 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
 *
 * 예시 입력 1
 * 5 14
 *
 * 예시 출력 1
 * 3
 */
public class findCalfMain {
    int answer = 0;
    int[] dis = {1, -1, 5}; // 이동할 수 있는 거리 배열
    int[] ch; // 방문 여부를 체크하기 위한 배열
    Queue<Integer> Q = new java.util.LinkedList<>(); // 큐 생성

    public int BFS(int s, int e) {
        ch = new int[10001]; // 1부터 10,000까지의 좌표를 체크하기 위한 배열 초기화'
        ch[s] = 1; // 출발 거리 지정

        Q.offer(s); // 큐에 시작 위치 추가
        int L = 0; // 레벨 값 초기화

        while (!Q.isEmpty()) { // 비어있지 않으면 실행
            int len = Q.size(); // 현재 레벨의 노드 개수

            for (int i = 0; i < len; i++) { // 현재 레벨의 노드 개수만큼 반복
                int x = Q.poll(); // 큐에서 노드 꺼내기


                for (int j = 0; j < 3; j++) { // 이동할 수 있는 거리만큼 반복
                    int nx = x + dis[j]; // 새로운 위치 계산

                    if (nx == e) { // 송아지 위치에 도달한 경우
                        return L + 1; // nx는 x의 자식 노드, L은 부모 노드의 레벨이므로 레벨 값에 1을 더해서 반환
                    }

                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) { // 범위 내에 있고 방문하지 않은 경우
                        ch[nx] = 1; // 방문 처리
                        Q.offer(nx); // 큐에 추가
                    }
                }
            }
            L++; // 레벨 증가
        }

        return answer;
    }

    public static void main(String[] args) {
        findCalfMain T = new findCalfMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int s = kb.nextInt(); // 현수의 위치
        int b  = kb.nextInt(); // 송아지의 위치
        System.out.println(T.BFS(s, b));
    }
}