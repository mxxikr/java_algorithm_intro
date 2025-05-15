package sectionString;

import java.util.Scanner;

/**
 * 설명
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 * 단어를 답으로 합니다.
 *
 *
 * 예시 입력 1
 * it is time to study
 *
 * 예시 출력 1
 * study
 */
public class wordInSentenceMain {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE; // 가장 작은 값으로 초기화
        String[] s = str.split(" "); // 공백을 기준으로 단어를 나눔
        for (String x : s) { // 단어를 하나씩 꺼내옴
            int len = x.length(); // 단어의 길이

            if (len > m) { // 단어의 길이가 가장 긴 단어보다 길면
                m = len; // 길이를 갱신
                answer = x; // 단어를 갱신
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        wordInSentenceMain T = new wordInSentenceMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        String str = kb.nextLine(); // 한 줄 읽어들임

        System.out.print(T.solution(str));
    }
}
