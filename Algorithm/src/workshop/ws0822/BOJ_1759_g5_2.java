package workshop.ws0822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 - 암호만들기
public class BOJ_1759_g5_2 {

    public static int L, C;// 비밀번호 길이, 재료 길이
    public static char[] list; //비밀번호 공간
    public static char[] code; // 재료 담는 공간
    
    public static void makeCode(int x,int idx) {
        if (idx == L) { 
            if (isValid()) { // 최소 한개의 모음, 최소 2개의 자음인지 확인하는 메소드
                System.out.println(code);//만들어진 비밀번호 출력
            }
            return;
        }

        // 길이 충족 X, 재료도 아직 남은 상태
        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            makeCode(i+1, idx + 1);
        }
    }

    // 최소 모음 1개, 최소 자음 2개인지 확인하는 메소드
    public static boolean isValid() {
        int mo = 0;//모음
        int ja = 0;//자음

        for (char x : code) {//코드 길이만큼 반복
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) { // 최소치를 충족하는 가?
            return true;
        }
        return false;
    }
    

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }


        // 정렬하고 계산해야 쉽게 풀수있다
        Arrays.sort(list);

        makeCode(0,0);//비밀번호 만드는 메소드 부르기

    }

    

}