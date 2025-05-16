package sectionString;
import java.util.Scanner;

/**
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 *
 * 예시 입력 1
 * teachermode e
 *
 * 예시 출력 1
 * 1 0 1 2 1 0 1 2 2 1 0
 */
public class shortestCharDistanceMain {
        public int[] solution(String s, char t) {
            int[] answer = new int[s.length()]; // 길이만큼 배열 생성
            int p = 1000; // 최대 길이보다 큰 값으로 초기화

            for (int i = 0; i < s.length(); i++) { // 문자열 길이만큼 반복
                if (s.charAt(i) == t) {
                    p = 0; // p값 초기화
                    answer[i] = p; // p값을 넣어줌
                } else {
                    p++; // p값 증가
                    answer[i] = p; // p값을 넣어줌
                }
            }

//        p = 1000; // p값 초기화
//
//        for (int j = 0; j < s.length(); j++) { // 뒤에서부터 꺼내야 함
//            if (s.charAt(s.length() - 1 - j) != t) {
//                p++; // p값 증가
//            } else {
//                p = 0; // p값 초기화
//            }
//            if (answer[s.length() - 1 - j] < p) { // p값이 더 크면
//            } else {
//                answer[s.length() - 1 - j] = p; // p값을 넣어줌
//            }
//        }

        p = 1000; // p값 초기화

        for (int j = s.length() - 1; j >= 0; j--) { // 뒤에서부터 꺼내야 함
            if (s.charAt(j) == t) {
                p = 0; // p값 증가
            } else {
                p++; // p값 증가
                answer[j] = Math.min(answer[j], p); // p값을 넣어줌
            }
        }
            return answer;
        }

        public static void main(String[] args){
            shortestCharDistanceMain T = new shortestCharDistanceMain(); // 객체 생성
            Scanner kb = new Scanner(System.in); // 콘솔 입출력
            String str = kb.next(); // 문자열 읽어들임
            char c = kb.next().charAt(0); // 문자 읽어들임

            for (int x : T.solution(str, c)) {
                System.out.print(x + " "); // 배열 출력
            }
        }
}