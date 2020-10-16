package thc.utils;

/**
 * @author thc
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/246:50 下午
 */

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public void output(){
        ListNode p = this;
        while(p!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
