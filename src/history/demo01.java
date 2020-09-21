package history;

public class demo01 {

    public static void main(String[] args) {
        int[] arr1={3,5,7,2,8,8,15,3};
        int[] arr2={1,0,1,0,1,0,1,0};
        int n  =3;
        int i = maxCandies(arr1, arr2, 3);
        System.out.println(i);
    }
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        if(candies.length==0||candies==null){
            return 0;
        }
        int len = candies.length;
        int meibaoSum=0;
        int dipuSum=0;
        int[] dipu =new int[len];
        for (int i = 0; i < len; i++) {
            if(coin[i]==1){
                dipu[i]=candies[i];
                dipuSum+=candies[i];
            }else {
                dipu[i]=0;
                meibaoSum+=candies[i];
            }
        }
        if(n==0){
            return meibaoSum;
        }
        if(n>=dipu.length){
            return meibaoSum+dipuSum;
        }
        int maxNSum=0;
        int tempSum=0;
        for (int i = 0; i <= dipu.length-n; i++) {
            for (int j = 0; j < n; j++) {
                tempSum+=dipu[i+j];
            }
            maxNSum=maxNSum>tempSum?maxNSum:tempSum;
            tempSum=0;
        }
        return meibaoSum+maxNSum;
    }
}
