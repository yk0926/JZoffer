package exercise;

import org.junit.Test;

import java.util.*;


public class 剑指offer {
    //003-从尾到头打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> rs = new ArrayList<>();
        if (listNode == null) {
            return rs;
        } else {
            stack.push(listNode.val);
        }
        while (listNode.next != null) {
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty()) {
            rs.add((Integer) stack.pop());
        }
        return rs;
    }

    //014-链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        ListNode cur = new ListNode(-1);
        pre.next = head;
        cur.next = head;
        if (head == null) {
            return head;
        }
        while (k > 0 && pre != null) {
            pre = pre.next;
            k--;
        }
        if (pre == null) {
            return pre;
        }
        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return cur.next;
    }

    //015-反转链表
    public ListNode ReverseList(ListNode head) {
        ListNode cur = new ListNode(-1);
        ListNode pre = null;
        ListNode temp = new ListNode(-1);
        if (head == null || head.next == null) {
            return head;
        }
        cur = head;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;
        return cur;
    }

    //016-合并两个或k个有序链表
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return temp.next.next;
    }

    //025-复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

    //036-两个链表的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null && pHead2 != null) {
            if (!set.contains(pHead1)) {
                set.add(pHead1);
                pHead1 = pHead1.next;
            } else {
                return pHead1;
            }
            if (!set.contains(pHead2)) {
                set.add(pHead2);
                pHead2 = pHead2.next;
            } else {
                return pHead2;
            }
        }
        while (pHead1 != null) {
            if (set.contains(pHead1)) {
                return pHead1;
            } else {
                pHead1 = pHead1.next;
            }
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            } else {
                pHead2 = pHead2.next;
            }
        }
        return null;


    }

    //055-链表中环的入口结点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    //056-删除链表中重复的结点
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = null;
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre.next = cur;
                pre = pre.next;//pre=cur
                cur = cur.next;
            }
        }
        return head.next;
    }


    //004-重建二叉树
    @Test
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||pre==null){
            return null;
        }
        TreeNode root= new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[0]){
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }

    //017-树的子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val==root2.val&&equalNode(root1,root2)){
                return true;
        }
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean equalNode(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val==root2.val){
            return equalNode(root1.left,root2.left)&&equalNode(root1.right,root2.right);
        }
        return false;
    }

    //018-二叉树的镜像
    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    public void Mirror1(TreeNode root) {
        if (root==null){
            return;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        TreeNode temp , cur;

        queue.offer(root);
        while (!queue.isEmpty()){
            cur=queue.poll();
            temp=cur.left;
            cur.left=cur.right;
            cur.right=temp;
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }

        }

    }

    //022-从上往下打印二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        ArrayList<Integer> rs= new ArrayList<>();
        nodes.offer(root);
        TreeNode cur;
        while (!nodes.isEmpty()){
            cur = nodes.poll();
            if(cur.left!=null){
                nodes.offer(cur.left);
            }
            if(cur.right!=null){
                nodes.offer(cur.right);
            }
            rs.add(cur.val);
        }
        return rs;
    }

    //023-二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0){
            return false;
        }
        return helpVerify(sequence,0,sequence.length-1);
    }
    public boolean helpVerify(int[] sequence,int start,int root){
        if(start>=root){
            return true;
        }
        int key=sequence[root];
        int i;
        for (i = start; i <root; i++) {
            if(sequence[i]>key){
                break;
            }
        }
        for (int j=i;j<root;j++){
            if(sequence[j]<key){
                return false;
            }
        }
        return helpVerify(sequence,start,i-1)&&helpVerify(sequence,i,root-1);
    }

    //024-二叉树中和为某一值的路径
    private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return resList;
        }
        if(target<root.val){
            return resList;
        }
        ArrayList<Integer> rs = new ArrayList<>();
        search(root,target,rs);
        return  resList;
    }
    public void search(TreeNode node,int target,ArrayList<Integer> rs){
        if(node==null){
            return;
        }
        rs.add(node.val);
        target=target-node.val;
        if(0>target){
            return;
        }
        if(0==target&&node.left==null&&node.right==null){
            resList.add(rs);
            return;
        }
        search(node.left,target,new ArrayList<>(rs));
        search(node.right,target,new ArrayList<>(rs));
        return;
    }

    //026-二叉搜索树与双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return pRootOfTree;
        }
        ArrayList<TreeNode> list =new ArrayList<>();
        inOrder(pRootOfTree,list);
        for (int i = 0; i < list.size()-2; i++) {
            list.get(i).right=list.get(i+1);
            list.get(i+1).left=list.get(i);
        }
        list.get(0).left=null;
        list.get(list.size()-1).right=null;
        return list.get(0);
    }
    public void inOrder(TreeNode node, ArrayList<TreeNode> list){
        if (node.left!=null){
            inOrder(node.left,list);
        }
        list.add(node);
        if(node.right!=null){
            inOrder(node.right,list);
        }
    }

    //038-二叉树的深度
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }
    public int TreeDeepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int depth=0;
        int size=0;
        while (!queue.isEmpty()){
            size=queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                size--;
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }

            }
            depth++;
        }
        return depth;
    }

    //039-平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return false;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }
        return true;

    }

    //057-二叉树的下一个结点
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        TreeLinkNode root = pNode;
        while (root.next!=null){
            root=root.next;
        }
        preOrder(root);
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1){
                return null;
            }
            if(list.get(i).val==pNode.val){
                return list.get(i+1);
            }
        }
        return null;
    }
    public void preOrder(TreeLinkNode node){
        if(node.left!=null){
            preOrder(node.left);
        }
        list.add(node);
        if(node.right!=null){
            preOrder(node.right);
        }
    }

    //058-对称的二叉树
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        return judge(pRoot.left,pRoot.right);
    }
    boolean judge(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }else if(node1==null||node2==null||node1.val!=node2.val){
            return false;
        }
        return judge(node1.left,node2.right)&&judge(node1.right,node2.left);
    }

    //059-按之字形顺序打印二叉树
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs =new ArrayList<>();
        if(pRoot==null){
            return rs;
        }
        LinkedList<TreeNode> queue =new LinkedList<>();
        queue.offer(pRoot);
        int size;
        boolean flag =true;
        while (!queue.isEmpty()){
            size=queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            flag=!flag;
            while (size>0){
                if(flag){
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if(node.right!=null){
                        queue.addFirst(node.right);
                    }
                    if(node.left!=null){
                        queue.addFirst(node.left);
                    }

                }else {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if(node.left!=null){
                        queue.addLast(node.left);
                    }
                    if(node.right!=null){
                        queue.addLast(node.right);
                    }
                }
                size--;
            }
            rs.add(list);
        }
        return rs;
    }

    //060-把二叉树打印成多行
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs =new ArrayList<>();
        if(pRoot==null){
            return rs;
        }
        LinkedList<TreeNode> queue =new LinkedList<>();
        queue.offer(pRoot);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {

                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            rs.add(list);
        }
        return rs;
    }

    //061-序列化二叉树
    int index=-1;
    String Serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        return root.val+"!"+Serialize(root.left)+"!"+Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        String[] strs = str.split("!");
        index ++;
        if(index>strs.length){
            return null;
        }
        TreeNode node =null;
        if (!strs[index].equals("#")){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }

    //062-二叉搜索树的第k个结点
    ArrayList<TreeNode> list62 = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null){
            return null;
        }
        infixOrder(pRoot);
        if(list62.size()<k||k==0){
            return null;
        }

        return list62.get(k-1);
    }
    void infixOrder(TreeNode Node){
        if (Node.left!=null){
            infixOrder(Node.left);
        }
        list62.add(Node);
        if(Node.right!=null)
            infixOrder(Node.right);
    }

}
 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

