package sectionArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 * 첫 자리부터의 연속된 0은 무시한다.
 *
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 *
 * 예시 입력 1
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * 예시 출력 1
 * 23 2 73 2 3
 */
public class reversePrimeNumMain {
    public boolean isPrime(int n) {
        if (n == 1) return false; // 1은 소수가 아님
        for (int i = 2; i < n; i++) { // 2부터 자기 자신 전까지 나누어 떨어지는지 확인
            if (n % i == 0) { // 나누어 떨어지면 소수가 아님
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i]; // arr[i]를 tmp에 저장
            int res = 0; // 뒤집은 수를 저장할 변수

            while (tmp > 0) {
                int t = tmp % 10; // tmp를 10으로 나눈 나머지(일의 자리 수)
                res = res * 10 + t;// 뒤집기(res에 저장)
                tmp = tmp / 10; // tmp를 10으로 나누기(일의 자리 수 제거)
            }
            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer; // 소수의 개수를 반환
    }

    public static void main(String[] args) {
        reversePrimeNumMain T = new reversePrimeNumMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}