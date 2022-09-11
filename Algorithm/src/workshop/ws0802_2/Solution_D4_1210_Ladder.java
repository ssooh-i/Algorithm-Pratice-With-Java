package workshop.ws0802_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[SW문제해결 기본] 2일차 Ladder (1210-D4)
public class Solution_D4_1210_Ladder {
	public static int ladder[][] = new int[100][100];
	public static boolean find = false;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ws0802_2/input4.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for (int tc=1; tc<=10; tc++){
        	int tc_cnt=Integer.parseInt(br.readLine());
            int result = 0;
            find = false;

            //사다리 배열 생성---------------------------------------
            for (int row=0; row<100; row++){
            	String line=br.readLine();
            	StringTokenizer st=new StringTokenizer(line," ");
                for (int col = 0; col < 100; col++){
                    ladder[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            //사다리 타기-------------------------------------------
            for (int col=0; col<100; col++)
            {
                if (ladder[0][col]==1){
                    findX(0, col);  // 출발점: (0,0) (0,1) (0,2) ~ (0,9)   

                    if (find){
                        result = col;
                        break;
                    }
                }
            }
            System.out.println("#" + tc_cnt + " " + result);
        }
    }
    public static void findX(int i, int j){
        boolean visited[][] = new boolean[100][100];
        
        while(i<100){
            visited[i][j]=true;          //지나온 길 표시
            if(ladder[i][j]==2){
                find = true;
                break;
            }
            if(j-1>=0 && ladder[i][j-1] == 1 && visited[i][j-1] == false){		    //왼쪽으로 이동
                j--;
            }else if(j+1<100 && ladder[i][j+1] == 1 && visited[i][j+1] == false){	//오른쪽으로 이동
                j++;
            }else{										                            //아래로 이동
                i++;
            }
        }
	}
}
//-------------------------------------------------------------------------------------------
/*
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder {
	public static int ladder[][] = new int[100][100];
	public static boolean find = false;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/ws0802_2/input4.txt"));
		Scanner sc = new Scanner(System.in);

        for (int tc=1; tc<=10; tc++){
            int tc_cnt = sc.nextInt();
            int result = 0;
            find = false;

            //사다리 배열 생성---------------------------------------
            for (int row=0; row<100; row++){
                for (int col = 0; col < 100; col++){
                    ladder[row][col] = sc.nextInt();
                }
            }
            //사다리 타기-------------------------------------------
            for (int col=0; col<100; col++)
            {
                if (ladder[0][col]==1){
                    findX(0, col);  // 출발점: (0,0) (0,1) (0,2) ~ (0,9)   

                    if (find){
                        result = col;
                        break;
                    }
                }
            }
            System.out.println("#" + tc_cnt + " " + result);
        }
    }
    public static void findX(int i, int j){
        boolean visited[][] = new boolean[100][100];
        
        while(i<100){
            visited[i][j]=true;          //지나온 길 표시
            if(ladder[i][j]==2){
                find = true;
                break;
            }
            if(j-1>=0 && ladder[i][j-1] == 1 && visited[i][j-1] == false){		    //왼쪽으로 이동
                j--;
            }else if(j+1<100 && ladder[i][j+1] == 1 && visited[i][j+1] == false){	//오른쪽으로 이동
                j++;
            }else{										                            //아래로 이동
                i++;
            }
        }
	}
}
*/