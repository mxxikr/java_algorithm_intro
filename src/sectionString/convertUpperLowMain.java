package sectionString;

import java.util.Scanner;

/**
 * 설명
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 *
 * 예시 입력 1
 * StuDY
 *
 * 예시 출력 1
 * sTUdy
 */

public class convertUpperLowMain {
    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) { // string 기반 문자 배열 생성
            if (Character.isLowerCase(x)) { // x가 소문자일 경우
                answer += Character.toUpperCase(x); // 대문자로 변경
            } else { // x가 대문자일 경우
                answer += Character.toLowerCase(x);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        convertUpperLowMain T = new convertUpperLowMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        String str = kb.next(); // 문자열 하나 읽어들임

        System.out.print(T.solution(str));
    }
}