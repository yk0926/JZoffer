package history;

public class demo3 {


    public static void main(String[] args) {
        int count = dfs(3);
        System.out.println(count);
    }
   static int dfs(int target){
        if (target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        int ans=0;
        for (int i = 1; i <= 6; i++) {
            ans+=dfs(target-i);
        }
        return ans;
    }
}
