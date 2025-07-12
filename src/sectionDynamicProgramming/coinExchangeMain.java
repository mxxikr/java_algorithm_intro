package sectionDynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전교환(냅색 알고리즘)
 *
 * 설명
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 *
 * 예시 입력 1
 * 3
 * 1 2 5
 * 15
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */
public class coinExchangeMain {
    static int n, m; // 동전의 종류 개수, 거슬러 줄 금액
    static int[] dy; // 동전의 최소 개수를 저장할 배열

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE); // dy 배열을 최대값으로 초기화
        dy[0] = 0; // 거슬러 줄 금액이 0일 때 동전의 개수는 0

        for (int i = 0; i < n; i++) { // 각 동전 종류에 대해
            for (int j = coin[i]; j <= m; j++) { // 동전의 금액부터 거슬러질 금액까지
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1); // 최소 동전 개수 계산
            }
        }

        return dy[m]; // 거슬러 줄 금액 m에 대한 최소 동전 개수 반환
    }

    public static void main(String[] args) {
        coinExchangeMain T = new coinExchangeMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 동전의 종류 개수
        int[] arr = new int[n]; // 동전의 종류 배열

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 동전의 종류 입력
        }

        m = kb.nextInt(); // 거슬러 줄 금액
        dy = new int[m + 1]; // 인덱스 0부터 m까지 사용하기 위해 크기 m+1로 초기화
        System.out.println(T.solution(arr));
    }
}