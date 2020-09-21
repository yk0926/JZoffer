package history;

import java.util.*;

public class demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        if(arr==null||arr.length==0){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        if(arr[0]*3>arr[n-1]){
            System.out.println(n);
            return;
        }
        int st = 0;
        int nd = 0;
        while (nd<arr.length){
            while (nd<arr.length&&(arr[st]*3)>arr[nd]){
                nd++;
            }
            if(nd>=arr.length){
                break;
            }
            if((arr[st]*3)<=arr[nd]){
                st++;
                nd++;
                n--;
            }
        }
        System.out.println(n);
    }

}