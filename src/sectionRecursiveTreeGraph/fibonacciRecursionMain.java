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
    static int[] fibo; // 피보나치 수열을 저장할 배열
    public int DFS(int n) { // n번째 피보나치 수열을 계산하는 재귀 함수
        if (fibo[n] > 0) {
            return fibo[n]; // 이미 계산된 값이 있으면 그 값을 반환
        }

        if (n == 1) {
            return fibo[n] = 1; // 피보나치 수열의 첫 번째 항
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1); // n번째 항은 (n-2)번째 항과 (n-1)번째 항의 합
        }
    }

    public static void main(String[] args) {
        fibonacciRecursionMain T = new fibonacciRecursionMain(); // 객체 생성
        int n = 10; // 피보나치 수열의 총 항의 수
        fibo = new int[n + 1]; // 피보나치 수열을 저장할 배열 생성 (0부터 n까지 사용하기 위해 n+1 크기로 생성)
        T.DFS(n); // 맨 마지막 항까지 한번에 계산
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}