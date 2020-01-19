package lesson9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

/**
 * 给定若干个区间，求合并后的区间
 * 例如，输入 [1,6],[4,5],[10,15],[17,20]
 *      输出 [1,6],[10,15],[17,20]
 *
 *      输入 [1,6],[4,8],[10,18],[17,20]
 *      输出 [1,8],[10,20]
 */
public class MergeIntervals {

    public static void main(String[] args) {
        Range r1 = new Range(1, 3);
        Range r2 = new Range(2, 8);
        Range r3 = new Range(3, 5);
        Range r4 = new Range(5, 8);
        Range[] ranges = {r1, r2, r3, r4};
        List<Range> list = deletedRanges(ranges);
        for (Range range : list) {
            System.out.println(range);
        }

//        int[][] intervals = {{1,3}, {2,8}, {3,5}, {5,8}};
//        int eraseCount = eraseOverlapIntervals(intervals);
//        System.out.println(eraseCount);
    }

//    static int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0) return 0;
//
//        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
//
//        int end = intervals[0][1], count = 1;
//
//        for (int i=1; i<intervals.length; i++) {
//            if (intervals[i][0] > end) {
//                end = intervals[i][1];
//                count ++;
//            }
//        }
//
//        return intervals.length - count;
//    }

    private static List<Range> deletedRanges(Range[] ranges) {
        List<Range> deleted = new ArrayList<>();

        Arrays.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return o1.start - o2.start;
            }
        });

        Range previous = null;
        for (int i=0; i<ranges.length; i++) {
            Range current = ranges[i];
            if (previous == null) {
                previous = current;
            } else {
                if (previous.end > current.start) {
                    // 有重叠
                    if (previous.end > current.end) {
                        // 删除 previous
                        deleted.add(previous);
                        previous = current;
                    } else {
                        // 删除 current
                        deleted.add(current);
                    }
                } else {
                    previous = current;
                }
            }
        }

        return deleted;
    }

//    private static List<Range> mergeRanges(Range[] ranges) {
//        Arrays.sort(ranges, new Comparator<Range>() {
//            @Override
//            public int compare(Range o1, Range o2) {
//                return o1.start - o2.start;
//            }
//        });
//
//        PriorityQueue<Range> queue = new PriorityQueue<>(new Comparator<Range>() {
//            @Override
//            public int compare(Range o1, Range o2) {
//                return o1.end - o2.end;
//            }
//        });
//
//        queue.offer(ranges[0]);
//        for (int i=1; i<ranges.length; i++) {
//            Range range = ranges[i];
//            Range peek = queue.peek();
//            if (peek.end > range.start && range.end > peek.end) {
//                peek.end = range.end;
//            } else {
//                queue.offer(range);
//            }
//        }
//
//        List<Range> merges = new ArrayList<>(queue.size());
//        Range poll = null;
//        while ((poll = queue.poll()) != null) {
//            merges.add(poll);
//        }
//        return merges;
//    }

    @Data
    @AllArgsConstructor
    @ToString
    static class Range {
        public int start;
        public int end;
    }
}
