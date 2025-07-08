package sectionDFSBFSUtil;

/**
 * 섬나라 아일랜드
 *
 * 설명
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 *
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 *
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 격자판 정보가 주어진다.
 *
 * 출력
 * 첫 번째 줄에 섬의 개수를 출력한다.
 *
 * 예시 입력 1
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 *
 * 예시 출력 1
 * 5
 */
import java.util.*;

public class islandNationDFSMain {
    static int answer = 0, n; // 섬의 개수, 격자판 크기
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1}; // 상, 우, 하, 좌, 대각선 상좌, 상우, 하좌, 하우
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1}; // 상, 우, 하, 좌, 대각선 상좌, 상우, 하좌, 하우

    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) { // 8방향 탐색
            int nx = x + dx[i]; // 다음 x 좌표
            int ny = y + dy[i]; // 다음 y 좌표

            // 다음 좌표가 범위 내에 있고, 섬(1)인 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0; // 방문 표시
                DFS(nx, ny, board); // 재귀 호출로 연결된 섬 탐색
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // 섬을 발견한 경우
                    answer++; // 섬의 개수 증가
                    board[i][j] = 0; // 출발점 방문 표시
                    DFS(i, j, board); // DFS로 연결된 섬 탐색
                    board[i][j] = 0; // 방문 표시
                }
            }
        }
    }

    public static void main(String[] args) {
        islandNationDFSMain T = new islandNationDFSMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 격자판 크기 입력
        int[][] arr = new int[n][n]; // 격자판 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt(); // 격자판 정보 입력
            }
        }

        T.solution(arr);
        System.out.println(answer);
    }
}