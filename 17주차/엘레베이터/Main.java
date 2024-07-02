    import java.util.*;
    /*
    문제
    1. 엘레베이터 존재
    2. 버튼이 +- 10의 n승 값들 존재
    3. 0층으로 이동하기

    풀이
    1. 층수 입력 => n
    2. while문 돌기 => n==0
        2.1. n%10 => 4이하인 경우 answer+=값 => n/10
        2.2. n%10 => 6이상인 경우
            2.2.1. five==false인 경우 answer+=(10-값) => n/10 +1
            2.2.2. five==true인 경우 answer+=(9-값) => n/10 +1
        2.3. n%10 => 5인 경우 answer += 5 => five = true 
    3. answer 출력
    */
    class Solution {
        public int solution(int storey) {
            int answer = 0;
            boolean five = false;
            long n = storey;
            while(n!=0){
                long temp = n%10;
                if(temp<=4){
                    answer += temp;
                    n /= 10;
                    five=false;
                } else if(temp==5){
                    if(five){
                        answer += (9-temp);
                        n /= 10;
                        n += 1;
                        five=false;
                    }else{
                        answer += (10-temp);
                        n /= 10;
                        five=true;
                    }
                } else {
                    if(five){
                        answer += (9-temp);
                        n /= 10;
                        n += 1;
                    }else{
                        answer += (10-temp);
                        n /= 10;
                         n += 1;
                    }
                    five=false;
                }
            }
            return answer;
        }
    }s