package sectionHashMapTreeSet;

import java.util.*;

/**
 * 설명
 * 현수의 아빠는 제과점을 운영합니다.
 * 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 *
 * 예시 입력 1
 * 7 4
 * 20 12 20 10 23 17 10
 *
 * 예시 출력 1
 * 3 4 4 3
 */
public class typeOfSalesMain {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap <Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) { // 처음 k-1개의 매출액을 map에 저장
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;

        for (int rt = k - 1; rt < n; rt++) { // rt는 k-1부터 시작하며 증가
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1); // 이미 존재하는 매출액은 카운트 증가
            answer.add(map.size()); // 현재 구간의 매출액 종류 개수를 저장
            map.put(arr[lt], map.get(arr[lt]) - 1); // lt 위치의 매출액 카운트 감소

            if (map.get(arr[lt]) == 0) { // 카운트가 0이 되면 제거
                map.remove(arr[lt]);
            }
            lt++; // lt 증가하며 k 구간 사이즈를 유지
        }

        return answer;
    }

    public static void main(String[] args) {
        typeOfSalesMain T = new typeOfSalesMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int k = kb.nextInt(); // 숫자 하나 읽어들임

        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}