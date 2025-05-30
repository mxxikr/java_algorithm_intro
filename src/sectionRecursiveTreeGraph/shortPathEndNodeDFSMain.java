package sectionRecursiveTreeGraph;

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
class NodeShortDFS {
    int data;
    NodeShortDFS lt, rt; // 왼쪽 자식과 오른쪽 자식 노드

    public NodeShortDFS(int val) {
        data = val;
        lt = rt = null; // 자식 노드는 초기 값 null로 설정
    }
}

public class shortPathEndNodeDFSMain {
    // 말단 노드 : 자식이 아예 없는 노드
    NodeShortDFS root;
    public int DFS(int L, NodeShortDFS root) {
        if (root.lt == null && root.rt == null) { // 말단 노드에 도달했을 때
            return L;
        } else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt)); // 왼쪽 자식과 오른쪽 자식 노드로 각각 DFS 호출
        }
    }

    public static void main(String[] args) {
        shortPathEndNodeDFSMain tree = new shortPathEndNodeDFSMain();

        tree.root = new NodeShortDFS(1);
        tree.root.lt = new NodeShortDFS(2);
        tree.root.rt = new NodeShortDFS(3);
        tree.root.lt.lt = new NodeShortDFS(4);
        tree.root.lt.rt = new NodeShortDFS(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}