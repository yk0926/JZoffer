package history;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char[][] board ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            String str=scan.nextLine();
            boolean res=search(board,str);
            System.out.println(res);
        }
    }
    public static boolean[][] isVisited;//是否访问过
    private static boolean search(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        isVisited=new boolean[board.length][board[0].length];
        if(word==null||word.length()==0)
            return false;
        if(dfs(board,word,0,0,0)){
            return true;
        }
        else{
            return false;
        }
    }
    //start为当前的字符串第几个字符，x为二维矩阵中当前位置的行坐标，y为列坐标
    private static boolean dfs(char[][] board,String str,int start,int x,int y){
        if(start==str.length()){//当所有字符串字符都有有效解则返回
            return true;
        }
        char temp=str.charAt(start);
        if(start==0){//start=0时要找到第一个字符的解
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==temp){
                        isVisited[i][j]=true;
                        if(dfs(board,str,start+1,i,j))
                            return true;
                        isVisited[i][j]=false;
                    }
                }
            }
            return false;
        }
        else{
            if(y-1>=0){//左边
                if(board[x][y-1]==temp&&!isVisited[x][y-1]){
                    isVisited[x][y-1]=true;
                    if(dfs(board,str,start+1,x,y-1))
                        return true;
                    isVisited[x][y-1]=false;
                }
            }
            if(x-1>=0){//上边
                if(board[x-1][y]==temp&&!isVisited[x-1][y]){
                    isVisited[x-1][y]=true;
                    if(dfs(board,str,start+1,x-1,y))
                        return true;
                    isVisited[x-1][y]=false;
                }
            }
            if(y+1<board[0].length){//右边
                if(board[x][y+1]==temp&&!isVisited[x][y+1]){
                    isVisited[x][y+1]=true;
                    if(dfs(board,str,start+1,x,y+1))
                        return true;
                    isVisited[x][y+1]=false;
                }
            }
            if(x+1<board.length){//下边
                if(board[x+1][y]==temp&&!isVisited[x+1][y]){
                    isVisited[x+1][y]=true;
                    if(dfs(board,str,start+1,x+1,y))
                        return true;
                    isVisited[x+1][y]=false;
                }
            }
            return false;
        }
    }
}
