package sectionHashMapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 설명
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 * 예시 입력 1
 * bacaAacba
 * abc
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */
public class allAnagramMain {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        // b 문자열의 문자를 bm에 저장
        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        // a 문자열의 처음 b.length() - 1개의 문자를 am에 저장
        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;

        for (int rt = L; rt < a.length(); rt++) {
            // rt 위치의 문자의 count map에 추가
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);

            if (am.equals(bm)) {
                answer++; // am과 bm이 같으면 아나그램이므로 카운트 증가
            }

            // 슬라이딩 윈도우
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1); // lt 위치의 문자의 개수를 1 감소

            if (am.get(a.charAt(lt)) == 0) { // lt 위치의 문자의 개수가 0이면 제거
                am.remove(a.charAt(lt));
            }

            lt++; // lt 증가하여 다음 부분문자열로 이동

        }
        return answer;
    }

    public static void main(String[] args) {
        allAnagramMain T = new allAnagramMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        String a = kb.next();
        String b = kb.next();

        System.out.println(T.solution(a, b));
    }
}