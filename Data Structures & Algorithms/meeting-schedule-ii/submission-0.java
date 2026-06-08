/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b) -> {
            return a.end - b.end;
        });
        int rooms = 0;
        for (Interval i : intervals) {
            while (!heap.isEmpty() && heap.peek().end <= i.start) {
                heap.poll();
            }
            heap.offer(i);
            rooms = Math.max(rooms,heap.size());
        }
        return rooms;
    }
}

// 5-10, 9-20, 