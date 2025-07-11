package sectionDynamicProgramming;

import java.util.Scanner;

/**
 * 계단오르기
 *
 * 설명
 * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 *
 * 입력
 * 첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 올라가는 방법의 수를 출력합니다.
 *
 * 예시 입력 1
 * 7
 *
 * 예시 출력 1
 * 21
 */
public class stairCountMain {
    static int[] dy;
    public int solution(int n) {
        dy[1] = 1; // 1번 계단에 오르는 방법은 1가지
        dy[2] = 2; // 2번 계단에 오르는 방법은 2가지 (1+1, 2)

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1]; // 현재 계단에 오르는 방법 = 한칸 전 계단에서 오르는 방법 + 두 칸 전 계단에서 오르는 방법
        }
        return dy[n]; // n번 계단에 오르는 방법의 수를 반환
    }

    public static void main(String[] args) {
        stairCountMain T = new stairCountMain();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(); // 계단의 개수 입력
        dy = new int[n + 1]; // 1번부터 n번까지의 계단을 저장하기 위한 배열
        System.out.println(T.solution(n));
    }
}