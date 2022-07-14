import java.util.PriorityQueue;

class MyCalendar {
    PriorityQueue<MyDate> queue;

    public MyCalendar() {
        queue = new PriorityQueue<>();
    }

    public boolean book(int start, int end) {
        MyDate input = new MyDate(start, end);
        for (MyDate date : queue) {
            if (date.cmp(input)) return false;
        }
        queue.add(input);
        return true;
    }

    class MyDate implements Comparable<MyDate> {
        int start;
        int end;

        public MyDate(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public boolean cmp(MyDate date) {
            if (start >= date.end) return true;
            return end <= date.start;
        }

        @Override
        public int compareTo(MyDate date) {
            return start - date.start;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */