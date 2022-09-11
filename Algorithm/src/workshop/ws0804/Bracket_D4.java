package workshop.ws0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket_D4{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
 
            int answer = 0;
            //Stack 사용법 다시 보기
            Stack<Character> stack = new Stack();
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);//한 char씩 가져와서 확인
                // 닫힌 괄호 종류에 맞는 쌍 유효성 여부를 확인하여 제거
                // stack이 비어있지 않은 상태에서 peek() 가능
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') 
                	// 가져온 c가 비어있지 않고 ')'일때 top부분을 가지고 오는데 걔가 '('라서 쌍이면
                	//pop해서 삭제
                    stack.pop();
                else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else if (c == '>' && !stack.isEmpty() && stack.peek() == '<')
                    stack.pop();
                else // 여는 괄호이거나 닫는 괄호 쌍이 맞지 않은 경우 닫는 괄호도 stack push
                    stack.push(c);
            }
 
            if (stack.isEmpty()) {
                // 스택이 모두 비워진 경우
                answer = 1;
            } 
            else {
                answer = 0;
            }
 
            //출력
            System.out.println("#" + tc + " " + answer);
        }
    }
}