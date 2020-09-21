package history;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        for (String s : strs) {
            if(s.length()<8||s.length()>120){
                System.out.println(1);
                continue;
            }
            boolean num =false;
            boolean big = false;
            boolean small = false;
            boolean fuhao = false;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if(c>='0'&&c<='9'){
                    num=true;
                }else if(c>='A'&&c<='Z'){
                    big=true;
                }else if(c>='a'&&c<='z'){
                    small=true;
                }else{
                    fuhao=true;
                }
            }
            if (num&&big&&small&&fuhao){
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }

}
