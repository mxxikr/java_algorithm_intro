package sectionArray;

import java.util.Scanner;

/**
 * 설명
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 *
 *
 * 입력
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 *
 *
 * 출력
 * 선생님이 볼 수 있는 최대학생수를 출력한다.
 *
 *
 * 예시 입력 1
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * 예시 출력 1
 * 5
 */
public class visibleStudentMain {
    public int solution(int n, int[] arr) {
        int answer = 1; //첫 번째 학생은 무조건 보임
        int max = arr[0]; // 첫 번째 학생의 키를 max에 저장

        // 두 번째 학생부터 마지막 학생까지 반복
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) { // 현재 학생의 키가 max보다 크면
                answer++; // 보이는 학생 수 증가
                max = arr[i]; // max를 현재 학생의 키로 갱신
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        visibleStudentMain T = new visibleStudentMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        System.out.print(T.solution(n, arr) + " ");
    }
}