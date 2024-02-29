package 미생물;
/*
 * 문제
 * 1. 미생물 군집 존재
 * 2. 약품을 칠해놓은 곳에 도달하면 군집이 절반으로 줄어들고 방향 변경
 * 3. 만약 한 곳에 도달하면 가장 군집이 많은애의 방향으로 이동
 * 4. 특정 시간이 지난 후에 미생물 수 구하기
 * 
 * 풀이
 * 1. 테케 입력
 * 2. N M K입력
 * 3. board[N][N]생성 arr[K][5]생성 -> 세로위치, 가로위치 ,미생물 수 , 이동방향, 겹칠 때 미생물 수(기본 0)
 * 4. arr채우기
 * 5. M번 이동 시작 for문 돌기
 * 	5.0 board초기화
 * 	5.1. arr을 보고 board에 두기
 * 	5.2. 이동시에 겹치는 부분 발생시 => 해당 번호의 arr로 이동
 * 		5.2.1. arr -> 세로,가로,합친 미생물, 최대 미생물의 이동 방향, 최대 미생물의 숫자
 * 		5.2.2. 최대 미생물의 숫자를 보고 이동 방향 업데이트
 * 		5.2.3. 방금 온 미생물은 제거 => 미생물 수 0
 * 	5.3. 이동시에 약품으로 도착시 => 0 or N-1
 * 		5.3.1. 미생물 수 절반 + 이동 방향 반대
 * 6. 다 돌았을 때 미생물 수 합 출력
 * 
 * 시간 복잡도
 * 1. 1000 * 1000 * 10 => 천만 정도 충분
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
		for(int test_case = 1;test_case <= T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] board;
			int[][] arr = new int[K][5];
			for(int i = 0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //가로
				arr[i][1] = Integer.parseInt(st.nextToken()); //세로
				arr[i][2] = Integer.parseInt(st.nextToken()); // 미생물 수 
				arr[i][3] = Integer.parseInt(st.nextToken()); // 이동방향
				arr[i][4] = arr[i][2]; // 최대 미생물 수
			}
			for(int i = 0;i<M;i++) {
				board = new int[N][N];
				for(int x = 0 ;x<N;x++) {
					for(int y = 0 ; y<N;y++) {
						board[x][y] = -1;
					}
				}
				for(int j = 0;j<K;j++) {
					if(arr[j][2]==0) continue;
					int mdir = arr[j][3];
					int nr = arr[j][0] + dir[mdir][0];
					int nc = arr[j][1] + dir[mdir][1];
					arr[j][0] = nr;
					arr[j][1] = nc;
					if(nr==0 || nc == 0 || nr == N-1 || nc == N-1) {
						arr[j][2] /= 2;
						if(mdir == 1 || mdir == 3) {
							mdir++;
						}else {
							mdir--;
						}
						arr[j][3] = mdir;
					}
					arr[j][4] = arr[j][2];
					if(board[nr][nc]!=-1) {
						int mnum = board[nr][nc];
						if(arr[mnum][4]>arr[j][2]) {
							arr[mnum][2] += arr[j][2];
							arr[j][2] = 0;
						}else {
							arr[j][2] += arr[mnum][2];
							arr[mnum][2] = 0;
							board[nr][nc] = j;
						}
					}else {
						board[nr][nc] = j;
					}
				}
//				for(int x = 0;x<N;x++) {
//					System.out.println(Arrays.toString(board[x]));
//				}
//				System.out.println();
//				for(int y = 0 ; y<K;y++) {
//					System.out.println(Arrays.toString(arr[y]));
//				}
//				System.out.println();
				
			}
			int answer = 0;
			for(int i = 0 ;i<K;i++) {
				answer += arr[i][2];
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}

