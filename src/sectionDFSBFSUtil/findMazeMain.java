package sectionDFSBFSUtil;

import java.util.Scanner;

/**
 * 미로탐색(DFS)
 *
 * 설명
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 *
 * 출발 0  0  0  0  0  0
 *  0  1  1  1  1  1  0
 *  0  0  0  1  0  0  0
 *  1  1  0  1  0  1  1
 *  1  1  0  0  0  0  1
 *  1  1  0  1  1  0  0
 *  1  0  0  0  0  0 도착
 *
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.

 * 입력
 * 7*7 격자판의 정보가 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 경로의 가지수를 출력한다.
 *
 * 예시 입력 1
 *
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 *
 *  예시 출력 1
 * 8
 */
public class findMazeMain {
    static int[] dx = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
    static int[] dy = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer++; // 도착점에 도달하면 경로의 개수 증가
        } else { // 도착점까지 갈 수 있으면 뻗어나가야함
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nx = x + dx[i]; // 다음 x 좌표
                int ny = y + dy[i]; // 다음 y 좌표

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    // 다음 좌표가 범위 내에 있고, 0아 아닌 경우
                    board[nx][ny] = 1; // 방문 표시
                    DFS(nx, ny); // 다음 좌표로 이동
                    board[nx][ny] = 0; // 백트래킹: 방문 표시 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        findMazeMain T = new findMazeMain();
        Scanner kb = new Scanner(System.in);

        board = new int[8][8]; // 7*7 격자판 + 1행, 0번 인덱스가 아닌 1번 인덱스부터 사용
        // 입력 받기
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        // DFS 시작
        board[1][1] = 1; // 시작점 방문 표시
        T.DFS(1, 1);

        // 결과 출력
        System.out.println(answer);
    }
}