package workshop.ws0808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Password2_D3
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            LinkedList<String> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < N; i++) {
                list.offer(st.nextToken());
            }
            int O = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine()," ");
            int x = 0;
            int y = 0;
            int cnt=0;
            while (st.hasMoreTokens()) {
                st.nextToken();
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for (int i = 0; i < y; i++) {
                    list.add(x+i, st.nextToken());
                }
            }
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.poll()+" ");
            }
            System.out.println();
        }
    }
}
