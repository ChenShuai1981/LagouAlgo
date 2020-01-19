package lesson7;


import java.util.*;

/**
 * 贪婪算法
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 *
 * Given [[7, 10],[2, 4]],
 * return 1.
 */
public class ArrangeMeetingRoom {

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
//        Interval[] intervals = {new Interval(7,10), new Interval(2,4)};
        int min = minMeetingRooms(intervals);
        System.out.println(min);
    }

    public static int minMeetingRooms(Interval[] intervals) {
        // 按会议开始时间排好序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // 按已安排会议结束时间排好序
        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        heap.offer(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            Interval current = intervals[i];
            Interval last = heap.peek();
            if (last.end <= current.start && current.end > last.end) {
                // 如果会议时间不冲突则修改当前会议室的结束时间（相当于延续会议）
                last.end = current.end;
            } else {
                // 否则，提供一个新会议室
                heap.offer(current);
            }
        }
        return heap.size();
    }

//    public static int minMeetingRooms2(Interval[] intervals) {
//        // 按会议开始时间排好序
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//
//        List<PriorityQueue<Interval>> rooms = new ArrayList();
//
//        for (Interval interval : intervals) {
//            boolean found = false;
//            for (PriorityQueue<Interval> room : rooms) {
//                Interval lastInterval = room.peek();
//                if (lastInterval == null || lastInterval.end < interval.start) {
//                    found = true;
//                    room.offer(interval);
//                    break;
//                }
//            }
//            if (!found) {
//                PriorityQueue<Interval> room = createRoom();
//                rooms.add(room);
//                room.offer(interval);
//            }
//        }
//
//        return rooms.size();
//    }
//
//    // 按已安排会议结束时间排好序
//    static PriorityQueue<Interval> createRoom() {
//        return new PriorityQueue<>(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.end - o2.end;
//            }
//        });
//    }

    static class Interval {
        int start;
        int end;
        public Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }
    }
}
