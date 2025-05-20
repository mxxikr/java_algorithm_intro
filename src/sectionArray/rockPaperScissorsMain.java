package sectionArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 예를 들어 N=5이면
 * 회수        1 2 3 4 5
 * A의 정보    2 3 3 1 3
 * B의 정보    1 1 2 2 3
 * 승자        A B A B D
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 *
 * 출력
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 *
 *
 * 예시 입력 1
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 예시 출력 1
 * A
 * B
 * A
 * B
 * D
 */
public class rockPaperScissorsMain {
    public ArrayList<String> solution(int n, int[] arrA, int[] arrB) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) { // 비길 경우
                answer.add("D");
            } else if (arrA[i] == 1 && arrB[i] == 3) { // A가 가위, B가 보
                answer.add("A");
            } else if (arrA[i] == 2 && arrB[i] == 1) { // A가 바위, B가 가위
                answer.add("A");
            } else if (arrA[i] == 3 && arrB[i] == 2) { // A가 보, B가 바위
                answer.add("A");
            } else { // 나머지는 B가 이기는 경우
                answer.add("B");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        rockPaperScissorsMain T = new rockPaperScissorsMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arrA = new int[n]; // 배열 생성
        int[] arrB = new int[n]; // 배열 생성


        for (int i = 0; i < n; i++) {
            arrA[i] = kb.nextInt(); // 배열에 숫자 입력
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = kb.nextInt(); // 배열에 숫자 입력
        }
        for(String x : T.solution(n, arrA, arrB)) {
            System.out.print(x + " ");
        }
    }
}