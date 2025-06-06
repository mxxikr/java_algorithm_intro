package sectionStackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 * 출력
 * 연산한 결과를 출력합니다.
 *
 * 예시 입력 1
 * 352+*9-
 *
 * 예시 출력 1
 * 12
 */
public class postfixMain {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char x: str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48); // 문자 0의 아스키 코드 값이 48이므로, 숫자로 변환
            } else {
                int rt = stack.pop(); // 스택에서 오른쪽 피연산자 꺼내기
                int lt = stack.pop(); // 스택에서 왼쪽 피연산자 꺼내기
//                System.out.println(lt + " " + x + " " + rt);

                // 연산자에 따라 계산
                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else if (x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.get(0); // 스택에 남아있는 최종 결과 값을 꺼내기
        return answer;
    }

    public static void main(String[] args) {
        postfixMain T = new postfixMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        String str = kb.next();

        System.out.print(T.solution(str));
    }
}