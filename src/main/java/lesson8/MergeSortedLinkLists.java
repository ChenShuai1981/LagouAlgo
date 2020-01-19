package lesson8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 合并多个有序链表
 *
 * 示例：
 * 输入 [
 *   1 -> 4 -> 5
 *   1 -> 3 -> 4
 *   2 -> 6
 * ]
 * 输出 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 */
public class MergeSortedLinkLists {

    public static void main(String[] args) {
        ListNode a5 = new ListNode(5, null);
        ListNode a4 = new ListNode(4, a5);
        ListNode ah = new ListNode(1, a4);

        ListNode b4 = new ListNode(4, null);
        ListNode b3 = new ListNode(3, b4);
        ListNode bh = new ListNode(1, b3);

        ListNode c6 = new ListNode(6, null);
        ListNode ch = new ListNode(2, c6);

        ListNode[] heads = {ah, bh, ch};

        ListNode merged = mergeSortedLinkLists(heads);
        System.out.println(merged.show());
    }

    /**
     * 每轮从各链表头选取最小的元素输出到合并链表，同时将选中的链表头向前移一位，直到所有的元素都合并完成
     * @param heads
     * @return
     */
    private static ListNode mergeSortedLinkLists(ListNode[] heads) {
        ListNode merged = null;
        ListNode curr = null;

        while(true) {
            int min = Integer.MAX_VALUE; // 该轮最小元素值
            int minBy = -1; // 记录该轮哪一个链表元素最小，以便后面链表头推进
            for (int i = 0; i < heads.length; i++) {
                ListNode head = heads[i];
                if (head != null) {
                    int headValue = head.value;
                    if (headValue < min) {
                        min = headValue;
                        minBy = i;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                break;
            } else {
                heads[minBy] = heads[minBy].next; // 链表头推进
                if (merged == null) {
                    merged = new ListNode(min, null);
                    curr = merged;
                } else {
                    ListNode p = new ListNode(min, null);
                    curr.setNext(p);
                    curr = p;
                }
            }
        }


        return merged;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ListNode {
        private int value;
        private ListNode next;

        public String show() {
            StringBuilder sb = new StringBuilder();
            ListNode p = this;
            while (p != null) {
                sb.append(p.value + " -> ");
                p = p.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }
}
