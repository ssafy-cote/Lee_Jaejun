package b16928;
/*
 * 문제
 * 1. 뱀을 밟으면 뒤로 가고
 * 2. 사다리를 밟으면 위로 올라간다.
 * 3. 최소 회숫로 이동
 * 
 * 풀이
 * 1. arr[101]생성
 * 2. line[101][101];
 * 3. for문 돌면서 i -> i+1,2,3,4,5,6 연결
 * 4. N , M 입력
 * 5. arr[a][b] 연결
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] line = new int[101][101];
		for(int i =1;i<=100;i++) {
			for(int j = 1;j<=6;j++) {
				if(i+j>100) continue;
				line[i][i+j] = 1;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i =0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j =  1;j<=6;j++) {
				if(a-j<=0) continue;
				line[a-j][b] =1;
				line[a-j][a] =0;
			}
		}
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j =  1;j<=6;j++) {
				if(a-j<=0) continue;
				line[a-j][b] =1;
				line[a-j][a] =0;
			}
		}
		Deque<int[]> que = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		que.add(new int[] {1,0});
		visited[1] = true;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int x = loc[0];
			for(int i = 1; i<=100; i++) {
				if(line[x][i]==0) continue;
				if(i==100) {
					System.out.println(loc[1]+1);
					return;
				}
				if(visited[i]) continue;
				visited[i] = true;
				que.add(new int[] {i,loc[1]+1});
			}
		}	
	}
}
