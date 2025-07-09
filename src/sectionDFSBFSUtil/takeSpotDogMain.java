package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 설명
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
 * 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
 *
 * 출력
 * 첫 번째 줄에 가장 무거운 무게를 출력한다.
 *
 * 예시 입력 1
 * 259 5
 * 81
 * 58
 * 42
 * 33
 * 61
 *
 * 예시 출력 1
 * 242
 */
public class takeSpotDogMain {
    /**
     * 부분 집합 이용
     */
    static int answer = Integer.MIN_VALUE, c, n; // 가장 무거운 무게를 저장할 변수
    public void DFS(int L, int sum, int[] arr){
        if (sum > c) { // 현재 무게가 트럭의 최대 무게를 넘으면 더 이상 탐색하지 않음
            return;
        }

        if (L == n) { // 레벨과 원소의 개수가 같으면(0번 인덱스부터 돌다가 n번 됐을 때 부분 집합이 완성)
            answer = Math.max(answer, sum); // 현재 무게와 가장 무거운 무게를 비교하여 더 큰 값을 저장
        } else {
            // 포함, 불포함 2가지 경우를 가지 치기
            DFS(L + 1, sum + arr[L], arr); // 레벨 + 1하고 현재 원소를 부분 집합에 포함
            DFS(L + 1, sum, arr); // 레벨 + 1하고 현재 원소를 부분 집합에 포함하지 않음
        }
    }

    public static void main(String[] args) {
        takeSpotDogMain T = new takeSpotDogMain();
        Scanner kb = new Scanner(System.in);

        c = kb.nextInt(); // 트럭의 최대 무게
        n = kb.nextInt(); // 바둑이의 수
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 각 바둑이의 무게
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}