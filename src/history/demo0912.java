package history;

import java.util.*;
public class demo0912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<String[]> list = new ArrayList<>();
        ArrayList<String> rs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(sc.nextLine().split(" "));
        }
        list.remove(0);
        StringBuilder sb =new StringBuilder();
        dfs(0,new StringBuilder(sb),list,rs);
        System.out.println(rs.toString());

    }
    static void dfs(int index,StringBuilder sb,ArrayList<String[]> list, ArrayList<String> rs){
        if(index==list.size()){
            rs.add(sb.toString());
            return;
        }
        for (int j = 0; j < list.get(index).length; j++) {
            sb.append(list.get(index)[j]+" ");
            dfs( index+1,new StringBuilder(sb), list, rs);
            sb.delete(sb.length()-list.get(index)[j].length()-1,sb.length());
        }
    }


    void demo1(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        String rs=null;
        HashMap<Character,Integer> map =new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);
        map.put('x',0);
        map.put('y',0);
        map.put('z',0);
        boolean flag=true;
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i])==null){
                continue;
            }else {
                count=map.get(chars[i]);
                count++;
                map.put(chars[i],count);
            }
            for (Character character : map.keySet()) {
                if(map.get(character)%2!=0){
                    flag=false;
                }
            }
            if(flag){
                rs=str.substring(0,i);
            }
            flag=true;
        }
        System.out.println(rs.length());
    }
    void demo2(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashMap<String,String> left = new HashMap<>();
        HashMap<String,String> right = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(sc.nextLine());
        }
        System.out.println(list.toString());
        for (String strs : list) {
            if (strs.equals("")){
                continue;
            }
            String[] str = strs.split(" ");
            if (str[1].equals("left")){
                left.put(str[0],str[2]);
            }else {
                right.put(str[0],str[2]);
            }
        }
        ArrayList<String> keys =new ArrayList<>();
        for (String key : left.keySet()) {
            if (right.get(key)!=null){
                keys.add(key);
            }
        }
        int count=0;
        for (String key : keys) {
            if(keys.contains(left.get(key))||keys.contains(right.get(key))){
                count++;
            }
        }
        System.out.println(keys.size()-count);
    }
}
