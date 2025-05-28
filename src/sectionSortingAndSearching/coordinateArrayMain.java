package sectionSortingAndSearching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * 설명
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 *
 * 입력
 * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 *
 * 출력
 * N개의 좌표를 정렬하여 출력하세요.
 *
 * 예시 입력 1
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 *
 * 예시 출력 1
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 */

class Point implements Comparable<Point> { // Comparable 인터페이스를 구현하여 정렬 기준을 정의
    int x, y;

    Point(int x, int y) { // 생성자
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) { // 정렬하는 기준을 설정하는 메소드 재정의
        // 반환 값이 음수 - 현재 객체가 비교 대상 객체보다 앞에 오도록 정렬
        if (this.x == o.x) {
//            return this.y - o.y; // x값이 같으면 y값에 의해 정렬(오름차순)
            return o.y - this.y; // x값이 같으면 y값에 의해 정렬(내림차순)
        } else {
//            return this.x - o.x; // x값이 다르면 x값에 의해 정렬(오름차순)
            return o.x - this.x; // x값이 다르면 x값에 의해 정렬(내림차순)
        }
    }
}

public class coordinateArrayMain {
    public static void main(String[] args) {
        coordinateArrayMain T = new coordinateArrayMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = kb.nextInt(); // x 좌표 입력
            int y = kb.nextInt(); // y 좌표 입력
            arr.add(new Point(x, y));
        }

        Collections.sort(arr); // Point 클래스의 compareTo 메소드를 사용하여 정렬
        for (Point p : arr) {
            System.out.println(p.x + " " + p.y); // 정렬된 좌표 출력
        }
    }
}