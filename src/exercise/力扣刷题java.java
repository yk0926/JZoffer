package exercise;
import java.util.*;
public class 力扣刷题java{
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
    //39
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        for (int i = 0; i < len; i++) {
            int sum=0;
            List<Integer>  rs =new ArrayList<>();
            rs=add(i,candidates,sum,target,rs);
            if(!rs.isEmpty()){
                res.add(rs);
            }
        }
        return res;
    }
    public static List<Integer> add(int index, int[] candidates,int sum, int target,List<Integer> rs){
        sum+=candidates[index];
        if(sum==target){
            rs.add(candidates[index]);
            return rs;
        }
        if(sum<target){
            rs.add(candidates[index]);
            add(index,candidates,sum,target,rs);
        }else {
            if(index==candidates.length-1){
                return null;
            }
            sum-=candidates[index];
            sum-=candidates[index];
            rs.remove(rs.size()-1);
            add(++index, candidates, sum, target, rs);
            }
        return rs;
        }
}