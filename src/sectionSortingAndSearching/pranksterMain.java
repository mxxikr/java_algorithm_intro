package sectionSortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 설명
 * 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
 * 철수네 반에는 N명의 학생들이 있습니다.
 * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
 * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
 * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
 * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
 * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
 * 차례로 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.
 * 두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다.
 * 키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.
 *
 *
 * 출력
 * 첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.
 *
 * 예시 입력 1
 * 9
 * 120 125 152 130 135 135 143 127 160
 *
 * 예시 출력 1
 * 3 8
 *
 * 힌트
 * 출력해설 : 키 정보 152가 철수이고, 127이 철수 짝꿍입니다.
 */
public class pranksterMain {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] tmp = arr.clone(); // 원본 배열을 복사하여 tmp 배열 생성
        Arrays.sort(tmp); // tmp 배열을 오름차순으로 정렬

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) { // 원본 배열과 정렬된 배열이 다르면
                answer.add(i + 1); // 현재 인덱스 i에 1을 더하여 반 번호를 추가
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        pranksterMain T = new pranksterMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " "); // 결과 출력
        }
    }
}