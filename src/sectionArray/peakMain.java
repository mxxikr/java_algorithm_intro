package sectionArray;

import java.util.Scanner;

/**
 * 설명
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 *
 * 0 0 0 0 0 0 0
 * 0 5 3 7 2 3 0
 * 0 3 7 1 6 1 0
 * 0 7 2 5 3 4 0
 * 0 4 3 6 4 1 0
 * 0 8 7 3 5 2 0
 * 0 0 0 0 0 0 0
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 봉우리의 개수를 출력하세요.
 *
 * 예시 입력 1
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 *
 * 예시 출력 1
 * 10
 */
public class peakMain {
    int[] dx = {-1, 0, 1, 0}; // 위, 오른쪽, 아래, 왼쪽 이동 시 행 변화
    int[] dy = {0, -1, 0, 1}; // 위, 오른쪽, 아래, 왼쪽 이동 시 열 변화
    // 현재 위치 i, j에서 dx[0] = -1, dy[0] = 0 -> (i-1, j) -> 위쪽으로 이동
    // 현재 위치 i, j에서 dx[1] = 0, dy[1] = -1 -> (i, j-1) -> 왼쪽으로 이동
    // 현재 위치 i, j에서 dx[2] = 1, dy[2] = 0 -> (i+1, j) -> 아래쪽으로 이동
    // 현재 위치 i, j에서 dx[3] = 0, dy[3] = 1 -> (i, j+1) -> 오른쪽으로 이동

    public int solution(int n, int[][] arr) {
        int answer = 0;

        // 2차원 배열 순회
        for (int i = 0; i < n; i++) { // 행의 증가, 감소는 위아래로 움직이는 방향
            for (int j = 0; j < n; j++) { // 열의 증가, 감소는 좌우로 움직이는 방향
                boolean flag = true; // 봉우리 지역인지 확인하는 플래그
                for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                    int nx = i + dx[k]; // 새로운 행 위치
                    int ny = j + dy[k]; // 새로운 열 위치

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && // 유효한 경계 안에 있는 경우에만 비교
                            arr[nx][ny] >= arr[i][j] && nx >= 0 && nx < n && ny >= 0 && ny < n) { // 주변 지역이 더 크거나 같으면 봉우리 아님
                        flag = false;
                        break; // 더 이상 탐색할 필요 없음
                    }
                }
                if (flag) {
                    answer++; // 봉우리 지역이면 카운트 증가
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        peakMain T = new peakMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력
        int n = kb.nextInt(); // 숫자 하나 읽어들임
        int[][] arr = new int[n][n]; // 2차원 배열 생성

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}