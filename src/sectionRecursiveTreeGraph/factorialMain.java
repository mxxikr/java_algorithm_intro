package sectionRecursiveTreeGraph;

/**
 * 설명
 * 자연수 N이 입력 되면 N! (N 팩토리얼)을 구하는 프로그램을 작성하세요.
 * 예를 들어 5!는 5*4*3*2*1=120입니다.
 *
 * 입력 설명
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄에 N!의 값을 출력합니다.
 *
 * 입력 예제1
 * 5
 *
 * 출력 예제1
 * 120
 */
public class factorialMain {
    /** 재귀 함수
     * 자기가 자기 자신을 호출하는 함수 (반복문의 형태)
     * if-else 문을 사용하여 종료 조건을 설정해야 함
     * 재귀 함수는 스택 프레임을 사용함 (매개 변수, 지역 변수, 복귀 주소를 가진 프레임이 생성 됨) -> 백 트레킹 가능
     **/
    public int DFS(int n) {
        if (n == 1) { // 종료 조건
            return 1; // n이 1이면 1을 반환 (팩토리얼의 기본값)
        } else{
//            System.out.print(n); // 재귀 함수가 작동하기 전에 출력 (스택의 상단에 있는 값이 먼저 출력됨)
            return n * DFS(n - 1); // 항상 스택의 상단이 작동한 후 복귀 주소로 돌아감
            // DFS(5) -> 5 * DFS(4) -> 5 * 4 * DFS(3) -> 5 * 4 * 3 * DFS(2) -> 5 * 4 * 3 * 2 * DFS(1) -> 5 * 4 * 3 * 2 * 1
            // 스택의 상단에서부터 복귀 주소로 돌아가면서 값을 곱함
        }
    }

    public static void main(String[] args) {
        factorialMain T = new factorialMain(); // 객체 생성
        System.out.println(T.DFS(5));
    }
}