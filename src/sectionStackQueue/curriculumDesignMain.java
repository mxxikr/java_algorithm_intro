package sectionStackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 설명
 * 현수는 1년 과정의 수업계획을 짜야 합니다.
 * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
 * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
 * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
 * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
 * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
 * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
 * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
 * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
 * 두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)

 * 출력
 * 첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.
 *
 * 예시 입력 1
 * CBA
 * CBDAGE
 *
 * 예시 출력 1
 * YES
 */
public class curriculumDesignMain {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>(); // Queue : FIFO(First In First Out) 자료구조

        for (char x: need.toCharArray()) {
            Q.offer(x); // 필수과목 순서를 Queue에 저장
        }

        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) { // 현재 수업계획에 필수 과목이 있다면
                if (x != Q.poll()) { // 필수 과목 순서와 다르면
                    return "NO";
                }
            }
        }

        if (!Q.isEmpty()) { // Queue에 남아있는 필수 과목이 있다면
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        curriculumDesignMain T = new curriculumDesignMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        String a = kb.next();
        String b = kb.next();

        System.out.print(T.solution(a, b));
    }
}