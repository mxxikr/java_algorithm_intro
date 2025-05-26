package sectionStackQueue;

import java.util.*;

/**
 * 설명
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 *
 * 예시 입력 1
 * (()(()))(()
 *
 * 예시 출력 1
 * NO
 */
public class correctBracketMain {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>(); // Stack 객체 생성 (LIFO 구조)

        for (char x: str.toCharArray()) {
            if (x == '(') { // 여는 괄호가 나오면 스택에 추가
                stack.push(x);
            } else {
                if (stack.isEmpty()) { // 닫는 괄호가 나왔는데 스택이 비어있으면 올바르지 않은 괄호
                    return "NO";
                }
                stack.pop(); // 닫는 괄호가 있으면 상단에 있는 괄호 스택에서 제거 (짝 맞춤)
            }
        }

        if (!stack.isEmpty()) {
            return "NO"; // 모든 괄호를 처리한 후에도 스택에 여는 괄호가 남아있으면 올바르지 않은 괄호
        }

        return answer;
    }

    public static void main(String[] args) {
        correctBracketMain T = new correctBracketMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        String str = kb.next();

        System.out.print(T.solution(str));
    }
}