package history;

import java.util.ArrayList;
import java.util.Collections;

public class demo02 {
    public static void main(String[] args) {

    }
    /**
     * 获得剩余区域内的最大干净矩形面积
     * @param x1 int整型
     * @param y1 int整型
     * @param x2 int整型
     * @param y2 int整型
     * @param x3 int整型
     * @param y3 int整型
     * @param x4 int整型
     * @param y4 int整型
     * @return int整型
     */
    public int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // write code here
        ArrayList<Integer> area = new ArrayList<>();
        int rs1=10*(10-Math.max(Math.max(x1,x2),Math.max(x3,x4)));
        int rs2=10*(Math.min(Math.min(x1,x2),Math.min(x3,x4)));
        int rs3=10*(10-Math.max(Math.max(y1,y2),Math.max(y3,y4)));
        int rs4=10*(Math.min(Math.min(y1,y2),Math.min(y3,y4)));
        int rs5=Math.min(y1,y2)*Math.min(x3,x4);
        int rs6=Math.min(y3,y4)*Math.min(x1,x2);
        int rs7=Math.max(y3,y4)*Math.min(x1,x2);
        int rs8=Math.max(y3,y4)*Math.max(x1,x2);
        int rs9=Math.min(y3,y4)*Math.max(x1,x2);
        int rs10=Math.min(y1,y2)*Math.max(x3,x4);
        int rs11=Math.max(y1,y2)*Math.max(x3,x4);
        int rs12=Math.max(y1,y2)*Math.min(x3,x4);
        area.add(rs5);
        area.add(rs1);
        area.add(rs10);
        area.add(rs11);
        area.add(rs12);
        area.add(rs7);
        area.add(rs8);
        area.add(rs9);
        area.add(rs6);
        area.add(rs2);
        area.add(rs3);
        area.add(rs4);
        Collections.sort(area);
        return area.get(area.size()-1);
    }
}

