package sectionSortingAndSearching;

import java.util.Scanner;

/**
 * 설명
 *
 * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 *
 * 만약 캐시 사이즈가 5이고, 작업이 2, 3, 1, 6, 7 순으로 저장되어 있다면,
 * (맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 사용하지 않은 작업이다.)
 *
 * 1) Cache Miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면 Cache Miss가 되고
 * 모든 작업이 뒤로 밀리고 5번 작업은 캐시의 맨 앞에 위치 한다.
 * 5 2 3 1 6 (7번 작업은 캐시에서 삭제 된다.)
 *
 * 2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면 Cache Hit가 되고,
 * 3번 앞에 있는 5, 2번 작업은 한 칸 뒤로 밀리고, 3번이 맨 앞으로 위치하게 된다.
 * 5 2 3 1 6  -> 3 5 2 1 6
 *
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
 * 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
 *
 * 출력
 * 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 *
 * 예시 입력 1
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 *
 * 예시 출력 1
 * 7 5 3 2 6
 *
 * 힌트
 * 캐시 메모리 상태 변화
 * 1 0 0 0 0
 * 2 1 0 0 0
 * 3 2 1 0 0
 * 2 3 1 0 0
 * 6 2 3 1 0
 * 2 6 3 1 0
 * 3 2 6 1 0
 * 5 3 2 6 1
 * 7 5 3 2 6
 */
public class leastRecentlyUsedMain {
    public int[] solution(int size, int n, int[] arr) {
        int [] cache = new int[size]; // 캐시 메모리 배열

        // 작업 번호마다 캐시에 이미 있으면 맨 앞으로, 없으면 맨 앞으로 넣고 가장 뒤는 버림 -> 가장 최근 사용 된 작업이 맨 앞에 위치, 오래 된 작업은 맨 뒤에 위치
        for (int x : arr) {
            int pos = -1; // 캐시에서 작업을 찾을 위치
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) { // 작업이 캐시에 존재한다면 cache Hit
                    pos = i; // 해당 작업의 위치를 저장
                }
            }
            if (pos == -1) { // 작업이 캐시에 존재하지 않으면 cache Miss
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1]; // 한칸 씩 뒤로 밀기
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1]; // Hit인 경우 해당 작업을 맨 앞으로 이동
                }
            }
            cache[0]= x; // 새로운 작업을 캐시의 맨 앞에 추가
        }

        return cache;
    }

    public static void main(String[] args) {
        leastRecentlyUsedMain T = new leastRecentlyUsedMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n]; // 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}