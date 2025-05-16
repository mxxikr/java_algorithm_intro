package sectionString;
import java.util.Scanner;

/**
 *설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *
 * 입
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 *
 * 예시 입력
 * ksekkset
 *
 * 예시 출력 1
 * kset
 *
 */
public class deleteDuplicationWord {
        public String solution(String str) {
            String answer = "";

            for (int i = 0; i < str.length(); i++) {
//                System.out.println(str.charAt(i) + " " + i  + " " + str.indexOf(str.charAt(i))); // i번째 문자, 해당 문자의 인덱스, 해당 문자의 처음 등장 위치 출력
                if(str.indexOf(str.charAt(i)) == i) { // 해당 문자의 처음 등장 위치와 현재 인덱스가 같으면
                    answer += str.charAt(i); // answer에 해당 문자 추가
                }
            }
            return answer;
        }

        public static void main(String[] args){
            deleteDuplicationWord T = new deleteDuplicationWord(); // 객체 생성
            Scanner kb = new Scanner(System.in); // 콘솔 입출력
            String str = kb.next(); // 문자열 하나 읽어들임

            System.out.print(T.solution(str)); // 메소드 호출
        }
}