package sectionRecursiveTreeGraph;

/**
 * 설명
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력 되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 입력 설명
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * 출력 설명
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 * 입력 예제1
 * 10
 *
 * 출력 예제1
 * 1 1 2 3 5 8 13 21 34 55
 */
public class fibonacciRecursionMain {
    /** 재귀 함수
     * 자기가 자기 자신을 호출하는 함수 (반복문의 형태)
     * if-else 문을 사용하여 종료 조건을 설정해야 함
     * 재귀 함수는 스택 프레임을 사용함 (매개 변수, 지역 변수, 복귀 주소를 가진 프레임이 생성 됨) -> 백 트레킹 가능
     **/
    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else{
            return DFS(n - 2) + DFS(n - 1); // 피보나치 수열의 재귀 호출
        }
    }

    public static void main(String[] args) {
        fibonacciRecursionMain T = new fibonacciRecursionMain(); // 객체 생성
        int n = 45; // 피보나치 수열의 총 항의 수
        for (int i = 1; i <= n; i++) { // 1부터 n까지 반복
            System.out.print(T.DFS(i) + " "); // 피보나치 수열 출력
        }
    }
}