package sectionHashMapTreeSet;

import java.util.*;

/**
 * 설명
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 *
 * 입력
 * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
 *
 * 출력
 * 학급 회장으로 선택된 기호를 출력합니다.
 *
 * 예시 입력 1
 * 15
 * BACBACCACCBDEDE
 *
 * 예시 출력 1
 * C
 */
public class classPresidentMain {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>(); // Key는 Char, Value는 Integer인 HashMap 객체 생성

        for (char x: str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // x의 키 값을 가져오는데 x의 키가 없으면 0을 반환하고 1을 더한 값을 저장
        }

        int max = Integer.MIN_VALUE; // 가장 작은 값으로 초기화
        for (char key : map.keySet()) { // map의 키를 순회
//            System.out.println(key + " " + map.get(key)); // 키와 해당 키의 값을 출력
            if (map.get(key) > max) {
                max = map.get(key); // 현재 키의 값이 max보다 크면 max를 갱신
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        classPresidentMain T = new classPresidentMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        String str = kb.next();

        System.out.print(T.solution(n, str));
    }
}