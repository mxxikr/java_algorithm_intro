package sectionDFSBFSUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 설명
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
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
 * 출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */
public class changeCoinMain {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr){
        if (sum > m) { // 현재 합이 거슬러 줄 금액보다 크면 더 이상 탐색하지 않음
            return;
        }

        if (L >= answer) { // 현재 레벨이 기존의 최소 동전 개수보다 크면 더 이상 탐색하지 않음
            return;
        }

        if (sum == m) { // 현재 합이 거슬러 줄 금액과 같으면
            answer  = Math.min(answer, L); // 현재 레벨(동전의 개수)과 기존의 최소 동전 개수를 비교하여 더 작은 값을 저장
        } else {
            for (int i = 0; i < n; i++) { // 동전의 종류를 순회
                DFS(L + 1, sum + arr[i], arr); // 현재 레벨 + 1하고 현재 동전을 포함
            }
        }
    }

    public static void main(String[] args) {
        changeCoinMain T = new changeCoinMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 동전의 종류 개수
        // 기본형 배열은 Collections.sort()를 사용할 수 없으므로 Integer 배열로 변환하거나 래퍼 클래스를 사용해야 함
        Integer[] arr = new Integer[n]; // 동전의 종류를 저장할 배열

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 각 동전의 종류를 입력받음
        }
        // 동전이 들어오면 내림차순으로 정렬 시킴 -> 가장 큰 동전부터 사용하여 최소 개수로 거슬러 주기 위함
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

//        for (int x: arr) {
//            System.out.print(x + " "); // 정렬된 동전 종류 출력
//        }

        m = kb.nextInt(); // 거슬러 줄 금액
        T.DFS(0, 0, arr); // DFS 시작
        System.out.println(answer);
    }
}