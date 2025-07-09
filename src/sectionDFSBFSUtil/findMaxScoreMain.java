package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 설명
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 * 입력
 * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 *
 * 예시 입력 1
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 *
 * 예시 출력 1
 * 41
 */
public class findMaxScoreMain {
    static int answer = Integer.MIN_VALUE, n, m;
    public void DFS(int L, int sum, int time, int[] ps, int[] pt){
        if (time > m) { // 제한 시간을 넘으면 더 이상 탐색하지 않음
            return;
        }

        if (L == n) { // 레벨과 원소의 개수가 같으면(0번 인덱스부터 돌다가 n번 됐을 때 부분 집합이 완성)
            answer = Math.max(answer, sum); // 현재 점수와 가장 높은 점수를 비교하여 더 큰 값을 저장
        } else {
            // 포함, 불포함 2가지 경우를 가지 치기
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt); // 레벨 + 1하고 현재 원소를 부분 집합에 포함
            DFS(L + 1, sum, time, ps, pt); // 레벨 + 1하고 현재 원소를 부분 집합에 포함하지 않음
        }
    }

    public static void main(String[] args) {
        findMaxScoreMain T = new findMaxScoreMain();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt(); // 문제의 개수
        m = kb.nextInt(); // 제한 시간

        int[] a = new int[n]; // 문제를 풀었을 때의 점수
        int[] b = new int[n]; // 푸는데 걸리는 시간

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }

        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}