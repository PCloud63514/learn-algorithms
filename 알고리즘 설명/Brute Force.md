# Brute Force

Brute Force는 탐색 알고리즘 중 모든 경우의 수를 탐색하여 결과를 도출하는 **완전탐색 알고리즘** 입니다.

당연하게도 효율이나, 시간을 고려하지 않고 오직 100% 정답을 도출하는 것을 목표로 하였으며,  전제 사항으로 '해가 하나 이상 존재한다.'가 있습니다.



- 경우의 수가 너무 많은 경우 결과를 도출하는 것에 적합하지 않습니다.
- native for, 순열, 재귀, bit mask 방식 등 다양한 구현 방법이 있습니다.
- 시간 복잡도는 O(경우의 수 * 소요시간) 입니다.  - 소요시간은 한 번 연산에 소요되는 시간입니다.







Brute Force의 목표는 완전 탐색이다보니, 자료구조에 따라 방법이 다릅니다.

**선형 구조**를 갖고 있다면 순차적으로 하나하나 탐색하는 **순차 탐색** 이며, **비선형 구조**를 갖고 있다면, **BFS(넓이 우선 탐색)** 과 DFS(깊이 우선 탐색)이 있습니다.

