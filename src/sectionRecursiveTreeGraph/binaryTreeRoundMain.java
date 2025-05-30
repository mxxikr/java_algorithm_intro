package sectionRecursiveTreeGraph;

/**
 * 이진 트리 순회(깊이 우선 탐색)
 *
 * 아래 그림과 같은 이진 트리를 전위 순회와 후위 순회를 연습해보세요.
 *          1
 *       /    \
 *      2      3
 *     / \    / \
 *    4   5  6   7
 *
 * 전위 순회 출력 : 1 2 4 5 3 6 7
 * 중위 순회 출력 : 4 2 5 1 6 3 7
 * 후위 순회 출력 : 4 5 2 6 7 3 1
 */

class NodeDFS {
    int data;
    NodeDFS lt, rt; // 왼쪽 자식과 오른쪽 자식 노드

    public NodeDFS(int val) {
        data = val;
        lt = rt = null; // 자식 노드는 초기 값 null로 설정
    }
}

public class binaryTreeRoundMain {
    /**
     * 전위 순회 : 부모를 제일 먼저 방문하고 그 다음에 왼쪽 자식 그 다음에 오른쪽 자식
     * 중위 순회 : 왼쪽 자식을 먼저 방문하고 그 다음에 부모 그 다음에 오른쪽 자식
     * 후위 순회 : 왼쪽 자식을 먼저 방문하고 그 다음에 오른쪽 자식 그 다음에 부모
     **/
    NodeDFS root;

    // 전위 순회 : 부모 -> 왼쪽 -> 오른쪽
    public void preOrder(NodeDFS root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " "); // 부모 노드 방문
            preOrder(root.lt); // 왼쪽 자식 노드 방문
            preOrder(root.rt); // 오른쪽 자식 노드 방문
        }
    }

    // 중위 순회 : 왼쪽 -> 부모 -> 오른쪽
    public void inOrder(NodeDFS root) {
        if (root == null) {
            return; // 노드가 null이면 말단 노드이기 때문에 종료
        } else {
            inOrder(root.lt); // 왼쪽 자식 노드 방문
            System.out.print(root.data + " "); // 부모 노드 방문
            inOrder(root.rt); // 오른쪽 자식 노드 방문
        }
    }

    // 후위 순회 : 왼쪽 -> 오른쪽 -> 부모
    public void postOrder(NodeDFS root) {
        if (root == null) {
            return; // 노드가 null이면 말단 노드이기 때문에 종료
        } else {
            postOrder(root.lt); // 왼쪽 자식 노드 방문
            postOrder(root.rt); // 오른쪽 자식 노드 방문
            System.out.print(root.data + " "); // 부모 노드 방문
        }
    }

    public static void main(String[] args) {
        binaryTreeRoundMain tree = new binaryTreeRoundMain(); // 객체 생성

        // 트리 구조 초기화
        tree.root = new NodeDFS(1); // 루트 노드 생성
        tree.root.lt = new NodeDFS(2); // 왼쪽 자식 노드 생성
        tree.root.rt = new NodeDFS(3); // 오른쪽 자식 노드 생성
        tree.root.lt.lt = new NodeDFS(4); // 왼쪽 자식의 왼쪽 자식 노드 생성
        tree.root.lt.rt = new NodeDFS(5); // 왼쪽 자식의 오른쪽 자식 노드 생성
        tree.root.rt.lt = new NodeDFS(6); // 오른쪽 자식의 왼쪽 자식 노드 생성
        tree.root.rt.rt = new NodeDFS(7); // 오른쪽 자식의 오른쪽 자식 노드 생성

        System.out.print("전위 순회 출력: ");
        tree.preOrder(tree.root); // 전위 순회 호출
        System.out.println();

        System.out.print("중위 순회 출력: ");
        tree.inOrder(tree.root); // 중위 순회 호출
        System.out.println();

        System.out.print("후위 순회 출력: ");
        tree.postOrder(tree.root); // 후위 순회 호출
        System.out.println();
    }
}