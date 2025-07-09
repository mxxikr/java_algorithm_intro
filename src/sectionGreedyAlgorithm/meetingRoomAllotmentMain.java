package sectionGreedyAlgorithm;

import java.util.*;

/**
 * 회의실 배정
 * 설명
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *
 * 입력
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
 * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 *
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 *
 * 예시 입력 1
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 *
 * 예시 출력 1
 * 3
 *
 * 예시 입력 2
 * 3
 * 3 3
 * 1 3
 * 2 3
 *
 * 예시 출력 2
 * 2
 */
class meetingRoomTime implements Comparable<meetingRoomTime> {
    public int s, e;
    meetingRoomTime(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(meetingRoomTime o) {
        if (this.e == o.e) {
            return this.s - o.s; // 끝나는 시간이 같으면 시작 시간을 기준으로 오름차순 정렬(음수)
        } else {
            return this.e - o.e; // 끝나는 시간을 기준으로 오름차순 정렬
        }
    }
}

public class meetingRoomAllotmentMain {
    public int solution(ArrayList<meetingRoomTime> arr, int n) {
        int cnt = 0; // 회의수
        Collections.sort(arr); // 회의 시간을 기준으로 정렬
        int endTime = 0; // 마지막 회의의 끝나는 시간

        for (meetingRoomTime mt : arr) { // 정렬된 회의 시간 리스트를 순회
            if (mt.s >= endTime) { // 현재 회의의 시작 시간이 마지막 회의의 끝나는 시간보다 크거나 같으면
                cnt++; // 회의 수 증가
                endTime = mt.e; // 마지막 회의의 끝나는 시간을 갱신
            }
        }
        return cnt; // 최대 사용할 수 있는 회의 수 반환
    }

    public static void main(String[] args) {
        meetingRoomAllotmentMain T = new meetingRoomAllotmentMain();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 회의의 수
        ArrayList<meetingRoomTime> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = kb.nextInt(); // 시작 시간
            int e = kb.nextInt(); // 끝나는 시간
            arr.add(new meetingRoomTime(s, e)); // 회의 정보를 리스트에 추가
        }

        System.out.print(T.solution(arr, n));
    }
}