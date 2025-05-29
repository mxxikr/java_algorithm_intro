package sectionRecursiveTreeGraph;

/**
 * 설명
 * 10진수 N이 입력 되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
 * 단 재귀 함수를 이용해서 출력해야 합니다.
 *
 * 입력 설명
 * 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄에 이진수를 출력하세요.
 *
 * 입력 예제1
 * 11
 *
 * 출력 예제1
 * 1011
 */
public class printBinaryMain {
    /** 재귀 함수
     * 자기가 자기 자신을 호출하는 함수 (반복문의 형태)
     * if-else 문을 사용하여 종료 조건을 설정해야 함
     * 재귀 함수는 스택 프레임을 사용함 (매개 변수, 지역 변수, 복귀 주소를 가진 프레임이 생성 됨) -> 백 트레킹 가능
     **/
    public void DFS(int n) {
        if (n == 0) { // 종료 조건
            return; // void 타입이므로 return을 사용하여 함수 종료
        } else{
//            System.out.print(n); // 재귀 함수가 작동하기 전에 출력 (스택의 상단에 있는 값이 먼저 출력됨) -> 몫 출력
            DFS(n / 2); // 항상 스택의 상단이 작동한 후 복귀 주소로 돌아감
            System.out.print(n % 2); // 재귀 함수가 끝나고 돌아오면서 출력 -> 나머지 출력
        }
    }

    public static void main(String[] args) {
        printBinaryMain T = new printBinaryMain(); // 객체 생성
        T.DFS(11);
    }
}