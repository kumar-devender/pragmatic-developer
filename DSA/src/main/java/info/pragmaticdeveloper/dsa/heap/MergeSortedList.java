package info.pragmaticdeveloper.dsa.heap;

import java.util.*;
import java.util.stream.Stream;

public class MergeSortedList {
    public ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        Stream.of(lists)
                .filter(Objects::nonNull)
                .forEach(minHeap::offer);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty() && curr != null) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
