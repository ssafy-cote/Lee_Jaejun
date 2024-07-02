import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
/*
문제
1. Si에서 Ti로 끝나는 N개 수업이 존재
2. 최소 강의실로 수업 진행
3. 끝난 직후에 수업도 가능

풀이
1. N입력
2. arr[N][2]생성
3. arr 채우기
4. arr정렬 arr[0]기준
5. proiorityque 생성 (arr[1]기준으로 정렬)
6. for문 돌리기 =>arr크기
    6.1.while => que가 비었는지 확인
        6.1.1. que에서 꺼내기 =>  temp[0] >= 꺼낸 값
        6.1.2. temp[0] < 꺼낸값 => que에 다시 넣고 brak
    6.3. que에 temp[1] 넣기
    6.4. que크기로 anser 갱신 => 최대 값
7. answer 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] temp : arr){
            while(!pq.isEmpty()){
                if(temp[0] >= pq.peek()) {
                    pq.poll();
                    continue;
                }
                break;
            }
            pq.add(temp[1]);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}