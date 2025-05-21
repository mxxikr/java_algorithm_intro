package sectionArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 * 입력
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 *
 * 출력
 * 입력된 순서대로 등수를 출력한다.
 *
 * 예시 입력 1
 * 5
 * 87 89 92 100 76
 *
 * 예시 출력 1
 * 4 3 2 1 5
 */
public class getScoreMain {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) { // 현재 기준이 되는 학생 선택
            int score = 1;
            for (int j = 0; j < n; j++) { // 다른 모든 학생과 비교
                if (arr[j] > arr[i]) { // 나보다 점수가 높은 학생이 있으면
                    score++; // 등수 증가
                }
            answer[i] = score; // 등수 저장
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        getScoreMain T = new getScoreMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr) ) {
            System.out.print(x + " ");
        }
    }
}