package sectionSortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 설명
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
 * 둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
 *
 * 출력
 * 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
 *
 * 예시 입력 1
 * 5 3
 * 1 2 8 4 9
 *
 * 예시 출력 1
 * 3
 */
public class chooseStableMain {
    private int count(int[] arr, int dist) {  // 유효한지 확인하는 함수
        int cnt = 1; // 맨 첫 번째 마구간에는 무조건 말 1마리 배치
        int ep = arr[0]; // 마지막 말이 배치 된 위치

        for (int i = 1; i < arr.length; i++) {
            // arr[i]의 위치에 말 배치할 수 있는지 확인
            if (arr[i] - ep >= dist) { // 현재 마구간이 마지막 말 위치에서 dist 이상 떨어져 있으면
                cnt++; // 말 한 마리 추가 배치
                ep = arr[i]; // 마지막 배치 위치 업데이트
            }
        }

        return cnt; // 최종적으로 배치한 말의 수
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr); // 오름차순 정렬

        int lt = 1; // 말 사이 최소 거리
        int rt = arr[n - 1]; // 말 사이 최대 거리 (마지막 마구간 - 첫 번째 마구간)

        while (lt <= rt) { // 시작 값이 끝 값보다 커지면 탐색 종료
            int mid = (lt + rt) / 2; // 현재 시도해볼 최소 거리
            if (count(arr, mid) >= c) { // 말을 c마리 이상 놓을 수 있는지 확인
                answer = mid; // 말을 c마리 이상 놓을 수 있으면 answer를 갱신
                lt = mid + 1; // 최소 거리를 늘려서 다시 탐색
            } else {
                rt = mid - 1; // 말을 c마리 이상 놓을 수 없으면 최소 거리를 줄임
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        chooseStableMain T = new chooseStableMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt(); // 마구간 개수
        int c  = kb.nextInt(); // 말의 개수
        int[] arr = new int[n]; // 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        System.out.println(T.solution(n, c, arr));
    }
}