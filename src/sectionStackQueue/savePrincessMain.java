package sectionStackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 * 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
 * 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
 * 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
 * 왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
 * 그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
 * 그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
 * 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
 * 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
 * 이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
 *
 *           1
 *       8      2
 *      7        3
 *       6      4
 *          5
 *
 * 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
 * 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
 * N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
 *
 * 출력
 * 첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
 *
 * 예시 입력 1
 * 8 3
 *
 * 예시 출력 1
 * 7
 */
public class savePrincessMain {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>(); // Queue : FIFO(First In First Out) 자료구조
        
        for (int i = 1; i <= n; i++) {
            Q.offer(i); // 왕자 번호를 큐에 추가
        }

        while (!Q.isEmpty()) { // 큐가 비워질 때까지 반복
            // poll() 메서드는 큐의 맨 앞에 있는 요소를 제거하고 그 값을 반환함
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll()); // k-1번 반복하여 큐의 앞에서 제거한 값을 다시 큐의 뒤에 추가
            }

            Q.poll(); // k번째 왕자를 제거

            if (Q.size() == 1) {
                answer = Q.poll(); // 마지막 남은 왕자의 번호를 저장
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        savePrincessMain T = new savePrincessMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.print(T.solution(n, k));
    }
}
