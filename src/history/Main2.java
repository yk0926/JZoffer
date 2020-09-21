package history;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        String regex ="110";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(str);
        ArrayList<Integer> arr = new ArrayList<>();
        while (matcher.find()){
            arr.add(matcher.start());
        }
        if(arr.size()==0){
            System.out.println(len);
        }else if(arr.size()==1){
            System.out.println(Math.max(arr.get(0)+2,len-arr.get(0)-1));
        }else {
            int max=arr.get(0)+2;
            for (int i = 0; i < arr.size()-1; i++) {
                max=max>arr.get(i+1)-arr.get(i)+1?max:arr.get(i+1)-arr.get(i)+1;
            }
            System.out.println(max);
        }
    }
}
