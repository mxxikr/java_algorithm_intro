package sectionRecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단 노드까지의 가장 짧은 경로
 *
 * 아래 그림과 같은 이진 트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요
 * 각 경로의 길이는 루트 노드에서 말단 노드까지 가는데 이동하는 횟수를 즉 간선(예지)의 개수를 길이로 하겠습니다.
 *           1
 *        /    \
 *       2      3
 *     / \
 *    4   5
 *
 * 가장 짧은 길이는 3번 노드까지의 길이인 1이다.
 */
class NodeShortBFS {
    int data;
    NodeShortBFS lt, rt; // 왼쪽 자식과 오른쪽 자식 노드

    public NodeShortBFS(int val) {
        data = val;
        lt = rt = null; // 자식 노드는 초기 값 null로 설정
    }
}

public class shortPathEndNodBFSMain {
    // 말단 노드 : 자식이 아예 없는 노드
    NodeShortBFS root;
    public int BFS(NodeShortBFS root) {
        Queue<NodeShortBFS> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size(); // 현재 레벨의 노드 개수
            for (int i = 0; i < len; i++) {
                NodeShortBFS cur = Q.poll(); // 현재 노드
                if (cur.lt == null && cur.rt == null) { // 말단 노드인 경우
                    return L; // 현재 레벨을 반환
                }
                if (cur.lt != null) {
                    Q.offer(cur.lt); // 왼쪽 자식이 있으면 큐에 추가
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt); // 오른쪽 자식이 있으면 큐에 추가
                }
            }
            L++; // 레벨 증가
        }
        return 0;
    }

    public static void main(String[] args) {
        shortPathEndNodBFSMain tree = new shortPathEndNodBFSMain();

        tree.root = new NodeShortBFS(1);
        tree.root.lt = new NodeShortBFS(2);
        tree.root.rt = new NodeShortBFS(3);
        tree.root.lt.lt = new NodeShortBFS(4);
        tree.root.lt.rt = new NodeShortBFS(5);
        System.out.println(tree.BFS(tree.root));
    }
}