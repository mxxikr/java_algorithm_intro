package sectionGreedyAlgorithm;
import java.util.*;

/**
 * 친구인가? (Disjoint-Set : Union&Find)
 * 설명
 * 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
 * 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
 * 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 *
 * 입력
 * 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
 * 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
 * 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
 *
 * 출력
 * 첫 번째 줄에 “YES"또는 "NO"를 출력한다.
 *
 * 예시 입력
 * 9 7
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 * 3 8
 *
 * 예시 출력 1
 * NO
 */
public class FriendQueryDisjointSetMain {
    /**
     * 서로소 집합(Disjoint-Set, Union-Find) 알고리즘
     * 친구(간접/직접) 관계 그룹 판별 문제
     */
    static int[] unf; // 대표자 저장할 부모 노드 배열

    public static int Find(int v){ // 노드 v의 집합 대표자 반환
        if(v == unf[v]) { // 만약 v가 자기 자신을 부모로 가지고 있다면
            return v; // 자기 자신을 반환
        }
        else { // 그렇지 않다면
            return unf[v] = Find(unf[v]); // 재귀적으로 부모를 찾아가면서 경로 압축
        }
    }

    public static void Union(int a, int b){ // 대표자 다를 때만 두 원소가 속한 집합을 합침
        int fa = Find(a); // a의 대표자 찾기
        int fb = Find(b); // b의 대표자 찾기
        if(fa != fb) { // 만약 a와 b의 대표자가 다르다면
            unf[fa]=fb; // a의 대표자를 b의 대표자로 설정하여 두 그룹을 합침
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in); // Scanner를 사용하여 입력 받기
        int n = kb.nextInt(); // 학생 수
        int m = kb.nextInt(); // 친구 관계의 개수
        unf = new int[n + 1]; // 1부터 n까지 사용하므로 n+1 크기로 생성

        for (int i = 1; i <= n; i++) { // 각 학생을 자기 자신이 대표자인 집합으로 초기화
            unf[i] = i; // 자기 자신을 부모로 설정
        }

        for (int i = 1; i <= m; i++) { // 친구 관계 입력 받기
            int a = kb.nextInt(); // 첫 번째 학생
            int b = kb.nextInt(); // 두 번째 학생
            Union(a, b); // 두 학생의 친구 관계를 Union 연산으로 합침
        }
        int a = kb.nextInt(); // 친구 관계를 확인할 첫 번째 학생
        int b = kb.nextInt(); // 친구 관계를 확인할 두 번째 학생
        int fa = Find(a); // 첫 번째 학생의 대표자 찾기
        int fb = Find(b); // 두 번째 학생의 대표자 찾기
        if (fa == fb) { // 두 학생이 같은 집합에 속하는지 확인
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
    }
}