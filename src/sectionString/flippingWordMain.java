package sectionString;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 *
 * 예시 입력 1
 * 3
 * good
 * Time
 * Big
 *
 * 예시 출력 1
 * doog
 * emiT
 * giB
 */
public class flippingWordMain {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
//        for (String x : str) {
//            // StringBuilder는 처음에 만든 객체만 계속 사용
//            String tmp = new StringBuilder(x).reverse().toString(); // StringBuilder와 reverse 이용해 문자열을 뒤집음
//            answer.add(tmp); // ArrayList에 추가
//        }
        for (String x : str) {
            char[] s = x.toCharArray(); // char 배열로 변환
            // char 배열을 뒤집기 위해 lt와 rt를 설정
            int lt = 0, rt = x.length() - 1;

            while(lt < rt) { // lt가 rt보다 작을 때까지 반복
                char tmp = s[lt]; // lt에 있는 문자 저장
                s[lt] = s[rt]; // rt에 있는 문자 lt에 저장
                s[rt] = tmp; // tmp에 저장된 문자 rt에 저장
                lt++; // lt 증가
                rt--; // rt 감소
            }
            String tmp = String.valueOf(s); // char 배열을 String으로 변환
            answer.add(tmp);
        }
       return answer;
}

    public static void main(String[] args){
        flippingWordMain T = new flippingWordMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 읽어들임
        String[] str = new String[n]; // 문자열 배열 생성

        for (int i = 0; i < n; i++) {
            str[i] = kb.next(); // 배열에 문자 하나씩 저장
        }

        for (String x : T.solution(n, str)) {
            System.out.println(x); // 문자열 하나 읽어들임
        }
    }
}