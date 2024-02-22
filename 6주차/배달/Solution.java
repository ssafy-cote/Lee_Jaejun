package s배달;
/*
 * 문제
 * 1. 각 마을까지 가는데 경로에 값이 존재
 * 2. K의 시간이 주어짐
 * 3. 1번 마을에서 시간내에 이동이 가능한 마을 갯수 세기
 * 
 * 풀이
 * 1. N의 갯수 입력 받기
 * 2. 간선들이 주어짐
 * 3. dfs로 탐색 하며 K이하인 거리들 찾기
 * 
 * dfs
 * 1. K가 dis를 넘어가면 return
 * 2. count했던 노드가 아니면 answer++, count check해줌
 * 3. 자신과 연결된 노드 for문으로 돌기
 * 	3.1. visted면 pass
 * 	3.2. vistited 체크
 * 	3.3. dfs돌리기
 * 	3.4. visted 해제
 */
import java.util.*;
public class Solution {
	int k;
	boolean visited[];
	boolean checked[];
	List<int[]>[] listArr;
	int answer = 1;
    public int solution(int N, int[][] road, int K) {
    	listArr = new List[N+1];
    	for(int i =1;i<=N;i++) {
    		listArr[i] = new ArrayList<int[]>();
    	}
    	for(int i = 0;i<road.length;i++) {
    		listArr[road[i][0]].add(new int[] {road[i][1],road[i][2]});
    		listArr[road[i][1]].add(new int[] {road[i][0],road[i][2]});
    	}
    	visited = new boolean[N+1];
    	checked = new boolean[N+1];
    	visited[1] = true;
    	checked[1] = true;
    	k = K;
    	
		dfs(0,1);
    	
        return answer;
    }
    public void dfs(int dis,int node) {
    	if(dis>k) return;
    	if(!checked[node]) {
    		checked[node] = true;
    		answer++;
    	}
    	for(int[] data : listArr[node] ) {
			if(visited[data[0]]) continue;
			visited[data[0]]= true;
			dfs(dis+data[1],data[0]);
			visited[data[0]]= false;
			}
    }
}
