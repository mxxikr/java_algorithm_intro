package sectionDFSBFSUtil;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로의 최단거리 통로(BFS)
 *
 * 설명
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 *
 * 출발 0  0  0  0  0  0
 *  0  1  1  1  1  1  0
 *  0  0  0  1  0  0  0
 *  1  1  0  1  0  1  1
 *  1  1  0  1  0  0  0
 *  1  0  0  0  1  0  0
 *  1  0  1  0  0  0 도착
 *
 * 입력
 * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 *
 * 예시 입력 1
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 *
 * 예시 출력 1
 * 12
 */

import java.util.*;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class findShortestMazeMain {
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1}; // 상, 우, 하, 좌
    static int[][] board, dis; // 7x7 격자판, 거리 배열

    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>(); // 큐 생성

        Q.offer(new Point(x, y)); // 시작점 (1, 1) 추가
        board[x][y] = 1; // 시작점 방문 표시
        while (!Q.isEmpty()) {
            Point tmp = Q.poll(); // 큐에서 현재 위치 꺼내기

            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nx = tmp.x + dx[i]; // 다음 x 좌표
                int ny = tmp.y + dy[i]; // 다음 y 좌표

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    // 다음 좌표가 범위 내에 있고, 벽이 아닌 경우
                    board[nx][ny] = 1; // 방문 표시
                    Q.offer(new Point(nx, ny)); // 큐에 추가
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 거리 업데이트
                }
            }
        }
    }

    public static void main(String[] args) {
        findShortestMazeMain T = new findShortestMazeMain();
        Scanner kb = new Scanner(System.in);

        board = new int[8][8]; // 1부터 7까지 사용하므로 8x8 배열 생성
        dis = new int[8][8]; // 거리 배열 초기화

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt(); // 입력 받기
            }
        }

        T.BFS(1, 1); // 시작점 (1, 1)에서 BFS 시작

        if (dis[7][7] == 0) {
            System.out.println(-1); // 도착점에 도달하지 못한 경우
        } else {
            System.out.println(dis[7][7]); // 도착점까지의 최단 거리 출력
        }
    }
}