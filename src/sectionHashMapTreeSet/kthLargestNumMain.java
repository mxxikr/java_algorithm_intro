package sectionHashMapTreeSet;

import java.util.*;

/**
 * 설명
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 *
 * 출력
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 *
 * 예시 입력 1
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 *
 * 예시 출력 1
 * 143
 */
public class kthLargestNumMain {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;

        // TreeSet을 사용하여 중복된 합을 제거하고 정렬
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬
//        TreeSet<Integer> Tset = new TreeSet<>(); // 오름차순 정렬

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]); // 세 카드의 합을 TreeSet에 추가
                }
            }
        }

        int cnt = 0; // K번째 큰 수를 찾기 위한 카운트 변수
//        Tset.remove(143);
//        System.out.println("size : " + Tset.size()); // 원소의 개수 출력
//        System.out.println("first : " + Tset.first()); // 오름차순에서는 최소 값, 내림차순에서는 최대 값 출력
//        System.out.println("last : " + Tset.last()); // 오름차순에서는 최대 값, 내림차순에서는 최소 값 출력
        for (int x : Tset) {
//            System.out.println(x);
            cnt++; // TreeSet에서 순회하며 카운트 증가

            if (cnt == k) { // K번째 큰 수를 찾았을 때
                return x;
            }
//            System.out.println(cnt + " - " + x);
        }
        return answer;
    }

    public static void main(String[] args) {
        kthLargestNumMain T = new kthLargestNumMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int k = kb.nextInt(); // 숫자 하나 읽어들임

        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
    }
}