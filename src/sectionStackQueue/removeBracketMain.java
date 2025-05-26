package sectionStackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 남은 문자만 출력한다.
 *
 * 예시 입력 1
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 예시 출력 1
 * EFLM
 */
public class removeBracketMain {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>(); // Stack 객체 생성 (LIFO 구조)

        for (char x: str.toCharArray()) {
            if (x == ')') { // ')'를 만나면 스택에서 '('가 나올 때까지 스택의 상단에 있는 문자 꺼내기
//                System.out.println("stack.pop() : " + stack.pop());
                while (stack.pop() != '(') {} // pop() 메서드는 꺼낸 값을 리턴함
            } else {
                stack.push(x); // '('가 아닌 경우 스택에 문자 추가
            }
        }

        for (int i = 0; i < stack.size(); i++) { // 스택에 남아있는 문자들을 순회
            answer += stack.get(i); // get() 메서드는 인덱스로 접근하여 해당 값을 리턴함
        }

        return answer;
    }

    public static void main(String[] args) {
        removeBracketMain T = new removeBracketMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        String str = kb.next();

        System.out.print(T.solution(str));
    }
}