package sectionString;
import javax.print.DocFlavor;
import java.util.Scanner;

/**
 설명
 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 알파벳 이외의 문자들의 무시합니다.


 입력
 첫 줄에 길이 100을 넘지 않는 공백이 있는 문자열이 주어집니다.


 출력
 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.


 예시 입력 1
 found7, time: study; Yduts; emit, 7Dnuof

 예시 출력 1
 YES
 */
public class validPalindrome {
        public String solution(String str) {
            String answer = "NO";
            str = str.toUpperCase().replaceAll("[^A-Z]", ""); // 대문자로 변환 후 알파벳 이외의 문자 제거
//            System.out.println(str);

            String tmp = new StringBuilder(str).reverse().toString(); // StringBuilder를 이용해 문자열을 뒤집음

            if (str.equals(tmp)) { // 원래 문자열과 뒤집은 문자열이 같으면
                answer = "YES";
            }

            return answer;
        }

        public static void main(String[] args){
            validPalindrome T = new validPalindrome(); // 객체 생성
            Scanner kb = new Scanner(System.in); // 콘솔 입출력
            String str = kb.nextLine(); // 한 줄 읽어들임

            System.out.print(T.solution(str)); // 메소드 호출
        }
}