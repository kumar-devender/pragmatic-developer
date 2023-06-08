package info.pragmaticdeveloper.dsa.heap;



public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        if (next != null && listNode.next != null) {
            return val == listNode.val && next.equals(listNode.next);
        } else if (next == null && listNode.next == null) {
            return val == listNode.val;
        }
        return false;
    }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(val, next);
//    }
}