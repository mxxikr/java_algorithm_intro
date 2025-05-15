package section_string;

import java.util.*;

/**
 * 설명
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 *
 * 입력
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 해당 문자의 개수를 출력한다.
 *
 * 예시 입력 1
 * Computercooler
 * c
 *
 * 예시 출력 1
 * 2
 */

class findStrMain {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase(); // 대문자로 변환
        t = Character.toUpperCase(t); // 대문자로 변환

//        for (int i = 0; i < str.length(); i++) { // 문자열 길이만큼 반복
//            if (str.charAt(i) == t) { // string을 인덱스를 이용해 접근
//                answer++;
//            }
//        }
        
        // 향상 된 for문 사용
        for (char x : str.toCharArray()) { // 리스트나 배열을 순회
            if (x == t) { // string을 char 배열로 변환
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        findStrMain T = new findStrMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        String str = kb.next(); // 문자열 하나 읽어들임
        char c = kb.next().charAt(0); // 문자 하나 읽어들임

        System.out.print(T.solution(str, c));
    }
}