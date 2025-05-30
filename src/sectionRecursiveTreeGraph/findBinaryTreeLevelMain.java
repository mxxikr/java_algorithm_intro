package sectionRecursiveTreeGraph;

import java.util.Queue;

/**
 * 이진 트리 순회(넓이 우선 순위 탐색 : 레벨 탐색)
 *
 * 아래 그림과 같은 이진 트리를 레벨 탐색 연습하세요
 *
 *          1
 *       /    \
 *      2      3
 *     / \    / \
 *    4   5  6   7
 *
 *  레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
 */

class NodeBFS {
    int data;
    NodeBFS lt, rt; // 왼쪽 자식과 오른쪽 자식 노드

    public NodeBFS(int val) {
        data = val;
        lt = rt = null; // 자식 노드는 초기 값 null로 설정
    }
}

public class findBinaryTreeLevelMain {
    NodeBFS root;
    public void BFS(NodeBFS root) {
        Queue<NodeBFS> Q = new java.util.LinkedList<>(); // 큐 생성
        Q.offer(root); // 큐에 루트 노드 추가
        int L = 0; // 레벨 초기화

        while (!Q.isEmpty()) { // 비어있지 않으면 실행
            int len = Q.size(); // 현재 레벨의 노드 개수
            System.out.print(L + " 레벨 : "); // 레벨은 몇번만에 움직여서 가느냐를 의미(움직이는 횟수)
            for (int i = 0; i < len; i++) { // 현재 레벨의 노드 개수만큼 반복
                NodeBFS cur = Q.poll(); // 큐에서 노드 꺼내기
                System.out.print(cur.data + " "); // 노드 데이터 출력

                if (cur.lt != null) { // 현재 노드의 왼쪽 자식이 존재하면
                    Q.offer(cur.lt); // 왼쪽 자식 노드를 큐에 추가
                }
                if (cur.rt != null) { // 현재 노드의 오른쪽 자식이 존재하면
                    Q.offer(cur.rt); // 오른쪽 자식 노드를 큐에 추가
                }
            }
            L++; // 레벨 증가
            System.out.println();
        }
    }

    public static void main(String[] args) {
        findBinaryTreeLevelMain tree = new findBinaryTreeLevelMain(); // 객체 생성

        // 트리 구조 초기화
        tree.root = new NodeBFS(1); // 루트 노드 생성
        tree.root.lt = new NodeBFS(2); // 왼쪽 자식 노드 생성
        tree.root.rt = new NodeBFS(3); // 오른쪽 자식 노드 생성
        tree.root.lt.lt = new NodeBFS(4); // 왼쪽 자식의 왼쪽 자식 노드 생성
        tree.root.lt.rt = new NodeBFS(5); // 왼쪽 자식의 오른쪽 자식 노드 생성
        tree.root.rt.lt = new NodeBFS(6); // 오른쪽 자식의 왼쪽 자식 노드 생성
        tree.root.rt.rt = new NodeBFS(7); // 오른쪽 자식의 오른쪽 자식 노드 생성

        tree.BFS(tree.root); // 루트 노드의 주소
    }
}