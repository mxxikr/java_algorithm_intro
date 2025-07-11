김태원 님의 [자바(Java) 알고리즘 문제풀이 입문: 코딩테스트 대비](https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/dashboard) 실습 코드 아카이브

### 💻 Development Environment
* Java 21
* IntelliJ IDEA

### 📝 Curriculum

### Section - String(문자열)
| 핵심 개념 | 설명                                                                                               |
|------|--------------------------------------------------------------------------------------------------|
| **대소문자 통일** | 문자열 비교 시 `toLowerCase()` 또는 `toUpperCase()`로 대소문자 차이를 제거해 일관된 비교 수행                              |
| **String vs StringBuilder** | `String`은 불변(Immutable) → 수정 시 새로운 객체 생성, `StringBuilder`는 가변(Mutable) → 기존 객체 내에서 수정 가능 (성능 유리) |
| **정규표현식을 이용한 전처리** | `replaceAll("[^a-zA-Z0-9]", "")`로 알파벳과 숫자 외 제거 후 대소문자 통일 처리                                      |
| **문자열 분리 (split)** | `split(" ")` 등으로 문자열을 배열로 나눈 뒤, 각 요소(단어)를 순회하며 조건 처리 가능                                          |
| **문자의 첫 등장 위치 판별** | `indexOf(c) == 현재 인덱스`이면 해당 문자는 처음 등장한 문자로 판단 가능                                                 |
| **숫자 조합의 수학 원리** | 자연수 생성 시 기존 숫자에 `* 10`한 뒤 새 숫자를 더해 자릿수 반영                                                        |
| **진수 변환 및 문자 변환** | `#` → 1, `*` → 0 치환 후 → `Integer.parseInt(이진문자열, 2)` → `(char) 정수`로 ASCII 문자 변환                  |

| 패턴 | 설명                                                                  |
|------|---------------------------------------------------------------------|
| **양쪽 포인터(LT/RT)로 문자 교환** | 문자열을 배열로 변환 후, 앞/뒤 포인터를 이용해 알파벳일 때만 swap, 특수문자는 건너뛰고 위치 유지 가능       |
| **양방향 순회로 최단 거리 계산** | 문자열을 왼→오, 오른→왼으로 두 번 순회해 타겟 문자까지의 거리 각각 계산 후 최소값 선택                 |
| **문자열 끝에 더미 문자 추가** | 압축 로직에서 마지막 문자 시퀀스 누락 방지를 위해 원본에 없는 문자(예: 공백) 추가하여 루프에서 마지막 문자까지 처리 |
| **중복 문자 제거 (순서 유지)** | 각 문자 순회 시 `indexOf(c) == 현재 인덱스`인 경우에만 결과 문자열에 추가하여 처음 등장 문자만 유지    |

- [x] 1. 문자 찾기
- [x] 2. 대소문자 변환
- [x] 3. 문장 속 단어(indexOf(), substring())
- [x] 4. 단어 뒤집기(StringBuilder 이용법 또는 직접 뒤집기)
- [x] 5. 특정 문자 뒤집기(toCharArray())
- [x] 6. 중복 문자 제거
- [x] 7. 회문 문자열
- [x] 8. 팰린드롬(replaceAll 정규식 이용)
- [x] 9. 숫자만 추출
- [x] 10. 문자 거리
- [x] 11. 문자열 압축
- [x] 12. 암호(replace(), parseInt(string, 2))

### Section - Array(1, 2차원 배열)
| 핵심 개념 | 설명 |
|-----------|------|
| 최댓값 누적 비교 | 지금까지의 최댓값을 저장하며 현재 값과 비교하는 방식 |
| 조건 기반 비교 | 명확한 규칙을 if문 등 조건문으로 구현하여 비교 판단 |
| 피보나치 수열 생성 | 앞의 두 수를 더하여 다음 항을 만드는 기본 수열 원리 |
| 소수 판별 - 에라토스테네스의 체 | 소수의 배수를 제거하여 남은 수만 소수로 간주하는 방법 |
| 숫자 분해 연산 | `%`로 자릿수 추출, `/`로 숫자 줄여가며 각 자리 처리 |
| 연속 상태 초기화 | 특정 조건(예: 0)을 만나면 누적값 또는 상태를 초기화함 |
| 동점 처리 규칙 | 동점자는 같은 등수, 다음 등수는 동점자 수만큼 건너뜀 |
| 격자에서 최대값 탐색 | 행, 열, 대각선을 개별 계산하여 최대 합 비교 |
| 경계 검사 | 2차원 배열 탐색 시, 인덱스가 배열 범위를 벗어나지 않도록 검사 |
| 멘토링 성립 조건 | 멘토는 모든 시험에서 멘티보다 높은 순위를 가져야 관계 성립 |


| 패턴 | 설명 |
|------|------|
| 한 번의 순회로 조건 추적 | 한 루프 내에서 최댓값이나 상태(점수, 누적 등)를 동시에 갱신 |
| 조건문으로 규칙 처리 | 문제의 규칙을 if-else 또는 switch문으로 간단하게 구현 |
| 누적 변수 활용 | 점수 계산, 연속 성공 등의 문제에서 누적 변수로 흐름 유지 |
| 중첩 반복문 활용 | 2차원 배열을 탐색하거나 두 요소 간 모든 쌍을 비교할 때 사용 |
| 배열 경계 체크 | 2차원 배열 내 이웃 탐색 시 인덱스 유효성 확인 필수 |
| 정렬 또는 등수 계산 알고리즘 | 점수 기반 등수 매기기에서 정렬 또는 직접 순위 비교 사용 |
| 배수 제거 로직 | 소수 판별처럼 특정 조건의 배수 또는 값을 걸러낼 때 반복적으로 제거 |

- [x] 1. 큰 수 출력하기
- [x] 2. 보이는 학생
- [x] 3. 가위바위보
- [x] 4. 피보나치 수열
- [x] 5. 소수(에라토스테네스의 체)
- [x] 6. 뒤집은 소수
- [x] 7. 점수 계산
- [x] 8. 등수 구하기
- [x] 9. 격자판 최대 합
- [x] 10. 봉우리
- [x] 11. 임시 반장 정하기
- [x] 12. 멘토링

### Section - Two pointers, Sliding window [효율성: O(n^2) → O(n)]
| 핵심 개념 | 설명 |
|-----------|------|
| 시간 복잡도 개선 | 투 포인터, 슬라이딩 윈도우는 이중 반복문(O(N²)) 대신 한 번의 선형 탐색(O(N)) 가능 |
| 정렬 상태 활용 | 정렬된 배열에서 두 포인터로 작은 값을 골라 결과 배열에 추가하며 합병 가능 |
| 구간 합 갱신 | 슬라이딩 윈도우 내에서 이동 시, 새로 들어온 값 더하고 빠진 값 빼서 합 갱신 효율화 |
| 합계 조절 | 현재 구간 합이 목표값 초과 시 왼쪽 포인터를 이동시켜 합을 줄임 |
| 제한 조건 유지 | 최대 변경 횟수(k) 초과 시 왼쪽 포인터 이동, 조건을 만족하도록 윈도우 크기 조절 |


| 패턴 | 설명                                             |
|------|------------------------------------------------|
| 두 포인터 병렬 이동 | 두 포인터가 배열을 따로 움직이며 문제 해결                       |
| 슬라이딩 윈도우 합 갱신 | 윈도우가 이동할 때마다 새로운 값 추가, 빠진 값 제거로 합 재계산 최소화      |
| 조건 만족 시 윈도우 확장/축소 | 조건 불만족 시 왼쪽 포인터 이동해 윈도우 크기 조절, 만족 시 오른쪽 포인터 확장 |
| 카운터 변수 사용 | 특정 조건을 세는 변수를 두고 윈도우 내 상태 관리                   |
| 정렬된 배열에서 병합 | 두 배열의 값을 비교하며 결과 배열에 하나씩 추가하는 병합 과정            |


- [x] 1. 두 배열 합치기(two pointers algorithm)
- [x] 2. 공통 원소 구하기(two pointers algorithm)
- [x] 3. 최대 매출(Sliding window)
- [x] 4. 연속 부분 수열(복합적 문제)
- [x] 5. 연속된 자연수의 합(two pointers)
- [x] 6. 연속된 자연수의 합(수학)
- [x] 7. 최대 길이 연속 부분 수열(복합적 문제)

### Section - HashMap, TreeSet (해시, 정렬 지원 Set)

| 핵심 개념 | 설명 |
|-----------|------|
| 기본값 반환 (getOrDefault) | HashMap에서 키가 없으면 지정한 기본값을 반환해 안전하게 값 조회 가능 |
| 아나그램 판별 | 한 단어 문자별 개수를 HashMap에 저장 후, 다른 단어 문자로 감소시켜 모두 0이면 아나그램 |
| 윈도우 요소 관리 | 슬라이딩 윈도우에서 빠져나가는 요소 개수를 HashMap에서 1 감소시켜 상태 유지 |
| 중복 제거 | Set은 중복을 허용하지 않아 유일한 값만 저장하고 관리할 때 효과적 |
| 정렬된 TreeSet | 내림차순 TreeSet에서 first()는 최대값, 오름차순에서는 최소값을 반환 |

| 패턴 | 설명 |
|------|------|
| getOrDefault 활용 | HashMap에서 키 존재 여부 확인 없이 기본값을 지정해 카운팅 등 간단히 처리 |
| 문자 개수 카운팅 | HashMap으로 문자 빈도수를 세고 감소시켜 아나그램, 부분 문자열 문제 해결 |
| 슬라이딩 윈도우와 HashMap | 윈도우 확장 시 개수 증가, 축소 시 개수 감소로 윈도우 내 상태 실시간 유지 |
| Set으로 중복 제거 | 결과 집합에서 중복을 제거할 때 Set을 사용하여 효율적으로 유일 값 관리 |
| TreeSet 정렬 활용 | 정렬된 자료구조를 이용해 최소값, 최대값 빠르게 조회 및 제거 가능 |

- [x] 1. 학급 회장(영상 후반 HashMap 추가 설명)
- [x] 2. 아나그램(HashMap)
- [x] 3. 매출액의 종류(Hash, sliding window)
- [x] 4. 모든 아나그램 찾기(Hash, sliding window: 시간 복잡도 O(n))
- [x] 5. K번째 큰 수(TreeSet 추가 설명)

### Section - Stack, Queue(자료 구조)

| 핵심 개념 | 설명 |
|-----------|------|
| 데이터 처리 순서 차이 | 스택은 LIFO(나중에 들어온 게 먼저 나감), 큐는 FIFO(먼저 들어온 게 먼저 나감) 방식으로 처리 |
| 괄호 짝 검사 | 닫는 괄호를 만났을 때 스택이 비어있으면 유효하지 않은 괄호 순서임 |
| 후위식 계산 | 숫자는 스택에 push하고, 연산자는 스택에서 피연산자 pop하여 계산 |
| 대기열 처리 | 큐는 FIFO 원칙으로 순서대로 항목을 처리하는 시뮬레이션에 적합 |
| 큐 요소 이동 | poll()로 앞에서 꺼내고, offer()로 뒤에 넣어 요소를 앞에서 뒤로 이동 가능 |

| 패턴 | 설명 |
|------|------|
| LIFO와 FIFO 이해 | 문제에 맞게 스택(LIFO) 혹은 큐(FIFO)를 선택하여 효율적 자료 처리 |
| 스택 기반 괄호 유효성 검사 | 여는 괄호는 push, 닫는 괄호는 pop하며 스택 상태로 괄호 쌍 확인 |
| 후위 연산 계산 흐름 | 숫자는 push, 연산자는 pop 2개로 연산 수행 후 결과 push 반복 |
| 큐를 이용한 순차 처리 | 대기열, 작업 순서 처리 시 큐 사용하여 자연스러운 순서 유지 |
| 큐 회전 처리 | 특정 위치까지 poll 후 offer 반복하여 큐 내 순서 조정 |

- [x] 1. 올바른 괄호
- [x] 2. 괄호 문자 제거
- [x] 3. 크레인 인형뽑기
- [x] 4. 후위식 연산(postfix)
- [x] 5. 쇠막대기
- [x] 6. 공주 구하기
- [x] 7. 교육 과정 설계
- [x] 8. 응급실

### Section - Sorting and Searching (정렬, 이분 검색과 결정 알고리즘)


| 핵심 개념                       | 설명                                                                                               |
|-----------------------------|--------------------------------------------------------------------------------------------------|
| 버블 정렬                     | 인접한 두 요소를 비교하며 위치를 바꿔 큰 값을 뒤로 보내는 방식,  반복적으로 순회하며 리스트를 정렬함            |
| Comparable 인터페이스         | 자바에서 사용자 정의 객체의 기본 정렬 기준을 직접 지정하고 싶을 때 구현하는 인터페이스, compareTo 메서드 필요  |
| 정렬된 데이터 필요            | 이분 검색은 데이터가 반드시 정렬되어 있어야 하며 중앙 값을 기준으로 탐색 범위를 반씩 줄이면서 검색함              |
| 이분 검색 (Binary Search)     | 탐색/결정 문제에서 가능한 값의 범위를 절반씩 줄여가며 원하는 조건을 만족하는 최적의 값(답)을 찾는 기법임         |
| LRU 캐시 최근 사용 갱신 방식  | 캐시 적중(Hit) 시 해당 요소를 배열의 맨 앞으로 이동시켜 가장 최근에 사용된 것으로 처리함                       |


| 패턴                               | 설명                                                                                      |
|----------------------------------|-----------------------------------------------------------------------------------------|
| 인접 원소 반복 비교 및 교환         | 버블 정렬 등에서 사용, 리스트를 순회하면서 인접한 값들을 비교, 조건에 따라 위치를 교환함                                 |
| 사용자 정의 비교 기준 구현         | 자바의 Comparable 인터페이스(또는 Comparator)로 compareTo를 오버라이드하여 커스텀 객체 정렬 기준을 지정함             |
| 중앙값 기준, 탐색 구간 축소        | 이분 검색에서는 항상 중간 값을 구해 목표 값과 비교 후 탐색 구간을 왼쪽/오른쪽 절반으로 좁혀가는 방식                      |
| 값의 범위에 대해 이분 결정 탐색     | 결정 알고리즘에서는 답이 될 수 있는 전체 값을 정렬된 범위로 두고 이분 검색을 통해 최소/최대 등 최적값을 탐색함            |
| 최근 요소를 앞으로 이동            | LRU 등에서 특정 값 참조 시 해당 값을 배열/리스트의 가장 앞으로 옮겨서 사용 순서 또는 우선순위를 갱신함                   |


- [x] 1. 선택 정렬
- [x] 2. 버블 정렬
- [x] 3. 삽입 정렬
- [x] 4. LRU(캐시, 카카오 변형)
- [x] 5. 중복 확인
- [x] 6. 장난꾸러기
- [x] 7. 좌표 정렬(compareTo)
- [x] 8. 이분 검색
- [x] 9. 뮤직비디오(결정 알고리즘)
- [x] 10. 마구간 정하기(결정 알고리즘)

### Section - Recursive, Tree, Graph (DFS, BFS 기초)

| 핵심 개념                                    | 설명                                                                                                  |
|-------------------------------------------|-----------------------------------------------------------------------------------------------------|
| 스택 프레임 (Stack Frame)                  | 재귀 함수 호출 시, 스택 메모리에 함수 정보(매개변수, 지역 변수, 복귀 주소 등)를 저장해 함수 호출 상태를 관리함           |
| 종료 조건 (Base Case)                      | 재귀가 무한 반복되지 않도록, 명확한 반환 조건을 정의해야 하며, 이를 만족할 때 더 이상 재귀 호출을 진행하지 않음           |
| 동일 값 중복 계산                           | 나이브한 재귀(예: 피보나치)에서는 동일 결과를 여러 번 재계산해 시간/자원이 불필요하게 소모됨, 메모이제이션 등으로 개선 가능 |
| 전위 순회 (Pre-order Traversal)             | DFS 기반 이진트리 순회 시, 현재 노드 → 왼쪽 자식 → 오른쪽 자식 순서로 탐색함                                         |
| 부분집합 분기 결정                         | 부분집합 구하기 문제에서는 각 원소마다 '포함/제외' 중 하나를 선택해 구조적으로 모든 경우를 탐색함                      |
| 너비 우선 탐색 (BFS)                        | 최단 거리 탐색에 적합, 큐(Queue)를 이용해 시작점에서 가까운 노드부터 차례로 탐색함                                     |
| 인접 리스트 (Adjacency List)                | 희소 그래프에 효율적인 저장 구조. 간선이 적은 경우에도 메모리를 절약할 수 있음                                         |
| 체크 배열(방문 여부 배열)                   | DFS/BFS 탐색 시 같은 노드를 두 번 이상 방문하지 않도록 방문 여부를 별도 배열에 저장하여 무한루프 방지                   |
| 거리 배열 (Distance Array)                  | BFS에서 각 정점까지의 최단 거리를 저장, 배열로 관리하여 효율적 계산 및 추적 가능                                       |
| 전역 변수                                  | 스택 프레임에 포함되지 않고 별도의 메모리 영역에 저장됨, 함수 호출과 무관하게 전체 프로그램에서 유지되는 값              |


| 패턴                                              | 설명                                                                                  |
|------------------------------------------------|-------------------------------------------------------------------------------------|
| 상태 공간 트리                                | 부분집합/경로 찾기 등에서 DFS로 각 단계마다 두 가지(포함/제외, 방문/비방문 등) 선택지로 분기하여 전체 탐색           |
| 방문 체크 및 백트래킹                           | DFS에서 현재 노드 방문 표시 후, 재귀 후에는 방문표시를 원래대로 복원(백트래킹)                                           |
| 큐를 이용한 수준 탐색                           | BFS에서 큐를 사용하여 현재 레벨(깊이)의 모든 노드를 먼저 방문하고, 다음 레벨 노드를 큐에 추가해서 탐색 반복             |
| 배열/리스트 기반 정보 관리                      | 탐색/거리/상태 추적 등을 위해 배열이나 리스트를 사용하여 노드별로 정보를 관리                                           |
| 재귀 종료 조건 선언 및 빠른 반환                 | 재귀 함수 구현 시, 함수 시작 부분에서 항상 종료 조건(Base Case)부터 확인하고 만족시 즉시 반환                          |
| 불필요한 중복 계산 방지 (메모이제이션)           | 동일 상태, 동일 값 등에 대해 이미 구한 결과를 별도 배열(테이블)에 저장하여 중복 연산을 최소화                         |
| 분기 전위/중위/후위 처리                        | 트리 순회 문제에서, 분기(재귀) 전/후 위치에 따라 전위, 중위, 후위 순회 패턴을 적용                                      |


- [x] 1. 재귀 함수(스택 프레임)
- [x] 2. 이진수 출력(재귀)
- [x] 3. 팩토리얼
- [x] 4. 피보나치 재귀(메모리제이션)
- [x] 5. 이진 트리 순회(DFS: Depth-First Search)
- [x] 6. 부분 집합 구하기(DFS)
- [x] 7. 이진 트리 레벨 탐색(BFS: Breadth-First Search)
- [x] 8. 송아지 찾기1(BFS)
- [x] 9. 트리 말단 노드까지의 가장 짧은 경로(DFS)
- [x] 10. 트리 말단 노드까지의 가장 짧은 경로(BFS)
- [x] 11. 그래프와 인접 행렬
- [x] 12. 경로 탐색(DFS)
- [x] 13. 경로 탐색(인접 리스트, ArrayList)
- [x] 14. 그래프 최단 거리(BFS)

### Section - DFS, BFS 활용

| 핵심 개념            | 설명                                                                   |
|------------------|----------------------------------------------------------------------|
| 분기와 순서/중복의 구분    | 부분 집합은 포함/비포함, 순열은 순서 고려, 조합은 순서 무시, 중복 순열 · 중복 조합은 선택의 반복 허용 방식이 다름 |
| 제약 조건 기반 가지 치기   | 무게 · 점수 등 임계치 초과 시 중단(탐색량 줄임)                                        |
| 체크 배열의 목적        | 순열에서 같은 원소의 중복을 막고, 이미 선택된 값은 제외                                     |
| 조합/순열의 재귀적 생성 원리 | 조합은 인덱스 제한(이전보다 큰 값), 순열은 모든 원소 탐색                                   |
| 메모이제이션의 필요성      | 중복되는 재귀 계산의 성능 개선                                                    |
| BFS의 최단거리 원리     | 큐를 써서 시작점부터 인접한 곳을 단계별로 방문, 목표에 처음 도달한 경로가 최단 거리                     |
| BFS 동시 진행(토마토 등) | 여러 시작점 동시 탐색을 위해 초기 상태에서 큐에 모두 삽입하여 진행함                              |
| 완전 탐색 + 최적 값 갱신  | 모든 조합의 결과를 계산해서 그 중 최적값을 선별함                                         |

| 패턴                | 설명                                                        |
|-------------------|-----------------------------------------------------------|
| 분기(포함/미포함) 재귀 탐색  | 각 원소를 선택하거나 선택하지 않는 두 가지 경로로 분기하여 모든 조합/부분 집합을 탐색함        |
| 가지 치기(Pruning)    | 제약 조건(무게 · 점수 등)을 초과하면 더 깊이 탐색하지 않고 즉시 종료하여 효율을 높임        |
| 체크 배열 사용          | 순열 등에서 중복 선택을 방지하기 위해 원소 사용 여부를 표시하는 배열 활용                |
| 시작 인덱스 활용 조합 생성   | 조합은 중복을 피하고 사전식 생성 위해 매 단계마다 이전보다 큰 인덱스(또는 다음 원소)부터 탐색 시작 |
| 메모이제이션            | 동일한 부문제 결과를 저장했다가 재활용해 중복 계산을 피하고 속도 향상                   |
| BFS와 DFS 활용       | 2차원 격자 등에서 모든 영역 방문, 연결성 확인 시 DFS, 최단 거리 탐색 시 BFS 선택      |
| 큐 초기화(여러 시작점 BFS) | 여러 시작점에서 동시에 확산되는 문제(BFS)는 모든 시작 지점을 미리 큐에 넣고 탐색을 동시 진행함  |
| 완전 탐색(조합 + 최적화)   | 모든 조합을 만들어 각 조합별로 최적 값 계산 및 비교                            |

- [x] 1. 합이 같은 부분 집합
- [x] 2. 바둑이 승차
- [x] 3. 최대 점수 구하기
- [x] 4. 중복 순열
- [x] 5. 동전 교환
- [x] 6. 순열 구하기
- [x] 7. 조합 수(메모이제이션)
- [x] 8. 수열 추측하기
- [x] 9. 조합 구하기
- [x] 10. 미로 탐색(DFS)
- [x] 11. 미로의 최단 거리 통로(BFS)
- [x] 12. 토마토(BFS)
- [x] 13. 섬나라 아일랜드(DFS)
- [x] 14. 섬나라 아일랜드(BFS)
- [x] 15. 피자 배달 거리(DFS)

### Section - Greedy Algorithm

| 핵심 개념                         | 설명                                                                 |
|-------------------------------|--------------------------------------------------------------------|
| 그리디 최적해 조건                    | 각 단계에서 최적(로컬 최적)을 선택하면 전체에서도 최적(글로벌 최적)이 되는 구조에서만 그리디 적용 가능        |
| 정렬 기준의 중요성                    | 회의실 배정처럼 이벤트를 최적화하려면 종료 시간(또는 조건에 따른 기준) 정렬이 해답의 핵심이 됨             |
| Union-Find의 Find/Union 구분     | Find는 집합 대표 찾기, Union은 합치기, 대표가 같으면 같은 집합, 다르면 Union 후 하나의 집합으로 만듦 |
| MST(Minimum Spanning Tree) 원리 | 모든 정점을 최소 비용으로 연결하며 사이클이 없어야 함, 크루스칼은 간선 정렬, 프림은 연결 확장             |
| 다익스트라의 음수 가중치 제약              | 간선에 음수 가중치가 있으면 잘못된 경로가 나올 수 있어 다익스트라는 양수 혹은 0의 가중치에서만 안전하게 작동함    |
| 이벤트 처리 순서                     | 동시 이벤트(출발 · 도착)가 있으면 출발 이벤트를 먼저 처리해야 인원이 올바르게 계산됨                  |
| 우선 순위 큐 스케줄 큐의 장점             | 최소 값, 최대 값 등 필요한 값을 빠르게 뽑아 작업 순서를 효율적으로 결정할 수 있음                   |

| 패턴                 | 설명                                                             |
|--------------------|----------------------------------------------------------------|
| 정렬 후 선택(그리디)       | 종료 시간, 시작 시간 등 특정 기준으로 정렬해 최적의 선택을 반복함                         |
| 이벤트 시뮬레이션          | 시간순으로 출입 이벤트를 처리하여 상태 변화 추적함                                   |
| 우선 순위 큐 활용         | 가장 작은 값 또는 가장 효율적인 요소를 빠르게 뽑아내기 위해 우선 순위 큐 자료구조를 사용함           |
| Union-Find(서로소 집합) | 집합을 빠르게 합치고 같은 집합 여부를 확인함                                      |
| 크루스칼 알고리즘(간선 정렬)   | 모든 간선을 가중치 기준 오름차순 정렬 후, 사이클이 생기지 않게 최소 신장 트리를 만들어감            |
| 프림 알고리즘(점진적 트리 확장) | 한 정점에서 시작해 트리를 확장하며, 연결되지 않은 점 중 가장 비용이 적은 간선을 우선 순위 큐로 뽑아 추가함 |
| 그리디 + 큐 스케줄링       | 각 이벤트나 작업을 우선 순위나 마감일 기준으로 처리하며, 최적의 선택만 반복함                   |

- [x] 1. 씨름 선수
- [x] 2. 회의실 배정
- [x] 3. 결혼식
- [x] 4. 최대 수입 스케줄(PriorityQueue)
- [x] 5. 다익스트라 알고리즘
- [x] 6. 친구인가(Union & Find 알고리즘)
- [x] 7. 원더랜드(최소 스패닝 트리 - 크루스칼)
- [x] 8. 원더랜드(최소 스패닝 트리 - 프림)

### Section - Dynamic Programming(동적 계획법)

| 핵심 개념                                   | 설명                                                                                             |
|--------------------------------------------|------------------------------------------------------------------------------------------------|
| 하위 문제 분할과 메모이제이션                   | 복잡한 문제를 더 단순한 여러 하위 문제로 쪼개고, 각 하위 결과를 저장해서 전체 문제를 효율적으로 해결함               |
| dp/dy 배열의 의미                              | 각 상태(i)에 대해 최적 결과(최대값, 최소값, 경우의 수 등)가 dp[i] 또는 dy[i]에 저장됨                  |
| 계단 오르기·피보나치 형태 점화식                  | 현재 상태가 1칸 또는 2칸 전 등, 앞의 상태들에 기반해서 만들어지는 구조(예: dy[i]=dy[i-1]+dy[i-2])      |
| 반복문 방향을 통한 중복 방지 및 중복 허용 조절        | 동전 무한 사용(작은 값→큰 값), 한 번만 사용(큰 값→작은 값) 등 반복문 방향을 바꿔 중복 사용 여부를 제한함           |
| LIS 및 조건에 맞는 누적 구조                      | 앞의 해답을 참고해서 지금 조건에 맞으면 누적값을 늘려가며 최적값을 찾아감(예: LIS, 블록 쌓기 등)                   |

| 패턴                                         | 설명                                                                                             |
|--------------------------------------------|------------------------------------------------------------------------------------------------|
| 큰 문제 분할 및 해답 재활용                     | 큰 문제를 작은 하위 문제로 나누고, 각 하위 문제의 해답을 저장(메모이제이션)해서 중복 계산 없이 재활용함            |
| 상태 배열(dp, dy 등) 정의                   | 상태를 배열로 정의해서 해당 인덱스에 원하는 특성(최댓값, 최솟값, 경우의 수 등)을 누적함                         |
| 점화식 사용                                 | 한 상태를 이전 상태(들)로 표현하는 공식으로, 규칙성 있게 값을 계산함                                        |
| 반복문 방향(증가/감소)                      | 동전 무한 사용(증가)과 각 아이템 한 번만 선택(감소) 문제에서 올바른 상태 갱신을 위해 반복문 방향을 적절히 설정함|
| LIS 구조 및 응용                            | 가장 긴 증가 부분수열처럼 조건에 맞는 부분을 계속 누적해서 최적해를 만듦|

- [x] 1. 계단 오르기
- [x] 2. 돌다리 건너기
- [x] 3. 최대 부분 증가 수열(LIS)
- [x] 4. 가장 높은 탑 쌓기(LIS 응용)
- [x] 5. 동전 교환(냅색 알고리즘)
- [x] 6. 최대 점수 구하기(냅색 알고리즘)