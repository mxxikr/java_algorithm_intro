package sectionSortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 설명
 * 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
 * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
 * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
 * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
 * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
 * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
 * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
 *
 * 입력
 * 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
 * 다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
 * 부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
 *
 * 출력
 * 첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
 *
 * 예시 입력 1
 * 9 3
 * 1 2 3 4 5 6 7 8 9
 *
 * 예시 출력 1
 * 17
 *
 * 힌트
 * 설명 : 3개의 DVD용량이 17분짜리이면 (1, 2, 3, 4, 5) (6, 7), (8, 9) 이렇게 3개의 DVD로 녹음을 할 수 있다.
 * 17분 용량보다 작은 용량으로는 3개의 DVD에 모든 영상을 녹화할 수 없다.
 */
public class musicVideoMain {
    public int count(int[] arr, int capacity) {
        int cnt = 1; // DVD 장수
        int sum = 0; // 현재 DVD에 담긴 곡의 총 길이

        for (int x: arr) { // 각 곡의 길이를 순회
            if (sum + x > capacity) { // 현재 DVD에 담을 수 있는 용량을 초과하면
                cnt++; // 새로운 DVD를 사용
                sum = x; // 현재 곡의 길이로 초기화
            } else {
                sum += x; // 현재 곡의 길이를 더함
            }
        }
        return cnt;
    }

    public int solution(int n, int[] arr, int m) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); // 배열을 스트림으로 변환해 최댓값을 구하고 기본형 int로 변환
        int rt = Arrays.stream(arr).sum(); // 배열을 스트림으로 변환해 합계를 구함

        while (lt <= rt) { // rt가 lt보다 크거나 같을 때까지 반복
            int mid = (lt + rt) / 2; // 중간 값 계산

            if (count(arr, mid) <= m) { // 리턴한 값이 m보다 작거나 같으면 가능함
                answer = mid; // 가능한 용량을 저장
                rt = mid - 1; // 최소 값 찾기 위해 더 작은 용량으로 탐색
            } else {
                lt = mid + 1; // 불가능한 경우 더 큰 용량으로 탐색
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        musicVideoMain T = new musicVideoMain(); // 객체 생성
        Scanner kb = new Scanner(System.in); // 콘솔 입출력

        int n = kb.nextInt();
        int m  = kb.nextInt();
        int[] arr = new int[n]; // 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 배열에 숫자 입력
        }

        System.out.println(T.solution(n, arr, m));
    }
}