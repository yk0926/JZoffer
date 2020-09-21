package history;

import java.util.*;

public class demo10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        if(m==1){
//            System.out.println(n);
//            return;
//        }
        boolean[] arr =new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=true;
        }
        int num=n;
        boolean flag =true;
        int count=0;
        int index=-1;
        int temp=0;
        while (num>1){
            if(flag){
                index++;
                if(index==n-1){
                    flag=false;
                }
            }else {
                index--;
                if(index==0){
                    flag=true;
                }
            }
            if(!arr[index]){
                continue;
            }
            if(temp==index){
                continue;
            }else {
                count++;
                temp=index;
                if(count==m){
                    arr[index]=false;
                    count=0;
                    num--;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==true){
                System.out.println(i+1);
                break;
            }
        }
    }
}

