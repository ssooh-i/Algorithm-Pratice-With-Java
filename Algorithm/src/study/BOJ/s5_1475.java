package study.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//방번호
public class s5_1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int[] arr = new int[10];//숫자 10칸
        
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));//charAt() -'0'안해줘도 숫자로 변환할 수 있는 메소드
            if (num == 6) {//6=9, 6을 9에 자리에 카운트 시켜서 9만 계산하기
                arr[9]++;
            } else {
                arr[num]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max,arr[i]);//숫자배열에서 가장 큰 값을 max로
        }
        
        int nine = arr[9]/2;//6과 9가 9의 자리에 넣어주니까 나누기 2
        if (arr[9]%2==1) nine++;//홀수개로 나오면 1개 더 사야함
        max = Math.max(max,nine);//최종적으로 몇개를 사야할까
        System.out.print(max);
    }
}