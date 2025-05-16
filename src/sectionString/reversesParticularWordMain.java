package sectionString;

import java.util.Scanner;

/**
 * 설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시 입력 1
 * a#b!GE*T@S
 *
 * 예시 출력 1
 * S#T!EG*b@a
 */
public class reversesParticularWordMain {
    public String solution(String str) {
        String answer;
        char[] s = str.toCharArray(); // char 배열로 변환
        int lt = 0, rt = str.length() - 1; // 좌우 포인터

        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt]) ) { // 알파벳이 아닐 때 lt 증가
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) { // 알파벳이 아닐 때 rt 감소
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt]; // 알파벳일 때 lt와 rt 교환
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s); // char 배열을 string으로 변환

        return answer;
    }

    public static void main(String[] args){
        reversesParticularWordMain T = new reversesParticularWordMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        String str = kb.next(); // 문자 읽어들임

        System.out.println(T.solution(str));
    }
}