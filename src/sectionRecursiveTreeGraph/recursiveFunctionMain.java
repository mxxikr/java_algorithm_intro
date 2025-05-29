package sectionRecursiveTreeGraph;

import java.util.Scanner;

/**
 * 설명
 * 자연수 N이 입력되면 재귀 함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 *
 * 입력 설명
 * 첫 번째 줄은 정수 N(3<=N<=10)이 입력 된다.
 *
 * 출력 설명
 * 첫째 줄에 출력한다.
 *
 * 입력 예제1
 * 3
 *
 * 출력 예제1
 * 1 2 3
 */
public class recursiveFunctionMain {
    /** 재귀 함수
     * 자기가 자기 자신을 호출하는 함수 (반복문의 형태)
     * if-else 문을 사용하여 종료 조건을 설정해야 함
     * 재귀 함수는 스택 프레임을 사용함 (매개 변수, 지역 변수, 복귀 주소를 가진 프레임이 생성 됨) -> 백 트레킹 가능
     **/
    public void DFS(int n) {
        if (n == 0) { // 종료 조건
            return; // void 타입이므로 return을 사용하여 함수 종료
        } else{
            DFS(n - 1); // 항상 스택의 상단이 작동한 후 복귀 주소로 돌아감
            System.out.print(n + " "); // 재귀 함수가 끝나고 돌아오면서 출력
        }
    }

    public static void main(String[] args) {
        recursiveFunctionMain T = new recursiveFunctionMain(); // 객체 생성
        T.DFS(3);
    }
}