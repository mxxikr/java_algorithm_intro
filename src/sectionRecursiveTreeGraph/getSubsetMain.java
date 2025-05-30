package sectionRecursiveTreeGraph;

/**
 * 부분 집합 구하기(DFS)
 *
 * 자연ㅅ수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분 집합을 모두 출력하는 프로그램을 작성하시오
 *
 * 입력 설명
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 *
 * 출력 설명
 * 첫 번째 줄부터 각 줄에 하나씩 부분 짒합을 아래의 출력 예제와 같은 순서로 출력한다.
 * 단 공집합은 출력하지 않습니다.
 *
 * 입력 예제1
 * 3
 *
 * 출력 예제1
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 */
public class getSubsetMain {
    static int n;
    static int[] ch; // 숫자를 부분 집합으로 사용할지 안할지 저장할 배열

    public void DFS(int L) {
        if (L == n + 1) { // 종착 지점에 도달했을 때
            String tmp = ""; // 부분 집합을 저장할 문자열
            for (int i = 1; i <= n; i++) { // 1부터 N까지 반복
                if (ch[i] == 1) { // 부분 집합에 포함된 원소
                    tmp += i + " "; // 문자열에 추가
                }
            }
            // 공집합 출력하지 않음
            if (tmp.length() > 0) { // 부분 집합이 비어있지 않을 때
                System.out.println(tmp);
            }

        } else { // 종착점에 도착하지 않았을 경우에는 두 갈래로 뻗어 나감
            ch[L] = 1; // L을 부분 집합에 포함하는 경우
            DFS(L + 1); // L을 부분 집합에 포함하는 경우 (왼쪽)
            ch[L] = 0; // L을 부분 집합에 포함하지 않는 경우
            DFS(L + 1); // L을 부분 집합에 포함하지 않는 경우 (오른쪽)
        }
    }

    public static void main(String[] args) {
        getSubsetMain T = new getSubsetMain(); // 객체 생성

        n = 3;
        ch = new int[n + 1]; // 부분 집합을 저장할 배열 생성(1부터 N까지 사용하므로 n+1 크기)
        T.DFS(1);
    }
}