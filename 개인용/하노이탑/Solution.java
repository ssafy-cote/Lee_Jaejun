package 백준.하노이탑;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*
 * 0. (자기위치, 타겟 , 갯수)
 * 1. 원판이 1개인 경우 -> (1,3,1)
 * 2. 원판이 2개인 경우 -> 1개를 2번 타겟으로(1,2) -> 1개를 3번 타겟으로(1,3) -> 1개를 3번 타겟으로(2,3)
 * 3. 원판이 3개인 경우 -> 2개를 2번 타겟으로 -> 1개를 3번 타겟으로 -> 2개를 3번 타겟으로
 * 4. 원판이 4개인 경우 -> 3개를 2번 타겟으로 -> 1개를 3번 타겟으로 -> 3개를 3번 타겟으로
 * 재귀함수
 * 1. (자기위치, 타겟 , 갯수) -> (자기위치, (자기,타겟 제외 타겟), 개수 -1) => (자기위치, 타겟,1) => ((자기,타겟 제외 타겟),타겟,개수-1)
 */
class Solution {
	public static List<int[]> arr = new ArrayList();
	public static void bfs(int myPoint, int targetPoint, int count) {
		if(count == 1) {
			arr.add(new int[]{myPoint,targetPoint});
			return;
		}
		int target = 6- myPoint - targetPoint;
		bfs(myPoint,target,--count);
		bfs(myPoint,targetPoint,1);
		bfs(target,targetPoint,count);
	}
    public static int[][] solution(int n) {
    	bfs(1,3,n);
    	int[][] answer = arr.toArray(new int[arr.size()][]);
        return answer;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(5)));
	}
}
