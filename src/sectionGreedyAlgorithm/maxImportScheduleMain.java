package sectionGreedyAlgorithm;

import org.xml.sax.ext.LexicalHandler;

import java.util.*;

/**
 * 최대 수입 스케쥴(PriorityQueue 응용문제)
 *
 * 설명
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 *
 * 출력
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 *
 * 예시 입력 1
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 *
 * 예시 출력 1
 * 150
 */

class Lecture implements Comparable<Lecture>{
    public int money; // 강연료
    public int date; // 강연을 해야 하는 날

    Lecture(int money, int time) {
        this.money = money;
        this.date = time;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.date - this.date; // 내림차순 정렬 (시간이 늦은 순서대로, 큰 값 우선)
    }
}

public class maxImportScheduleMain {
    /**
     * 우선순위 큐(Priority Queue)
     * 각 요소가 우선순위를 가지며, 우선순위가 높은 요소가 먼저 처리되는 자료구조임
     */
    static int n, max = Integer.MIN_VALUE; // n: 강연 요청의 개수, max: 가장 큰 날짜(강연을 해야 하는 날)
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬을 위한 우선 순위 큐 생성(큰 값 우선)
        Collections.sort(arr);

        int j = 0; // arr의 인덱스
        for (int i = max; i >= 1; i--) { // max일부터 1일까지 하루씩 작아지며 반복
            for(; j < n; j++) { // arr의 인덱스가 n보다 작을 때까지 반복
                if(arr.get(j).date < i) break; // 현재 날짜(i)보다 강연을 해야 하는 날이 빠르면 반복 종료
                pQ.offer(arr.get(j).money); // 우선순위 큐에 강연료를 추가
            }
            if(!pQ.isEmpty()) { // 우선순위 큐가 비어있지 않으면
                answer += pQ.poll(); // 가장 큰 강연료를 꺼내서 총 수입에 더함
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        maxImportScheduleMain T = new maxImportScheduleMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) {
                max = d; // 가장 큰 날짜 구함
            }
        }
        System.out.print(T.solution(arr));
    }
}