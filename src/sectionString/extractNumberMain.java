package sectionString;
import java.util.Scanner;

/**
 * 설명
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * 입력
 * 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 *
 * 출력
 * 첫 줄에 자연수를 출력합니다.
 *
 * 예시 입력 1
 * g0en2T0s8eSoft
 *
 * 예시 출력 1
 * 208
 */
public class extractNumberMain {
        public int solution(String str) {
            int answer = 0;
            // 아스키 번호가 48부터 57까지인 경우는 숫자
            // 숫자일 경우에
            for (char x : str.toCharArray()) {
                if (x >= 48 && x <= 57) { // 숫자일 경우
                    answer = answer * 10 + (x - 48); // 10을 곱하고 아스키 번호를 빼서 숫자로 변환
                }

            }
            return answer;
        }

        public static void main(String[] args){
            extractNumberMain T = new extractNumberMain(); // 객체 생성
            Scanner kb = new Scanner(System.in); // 콘솔 입출력
            String str = kb.next(); // 한 줄 읽어들임

            System.out.print(T.solution(str)); // 메소드 호출
        }
}