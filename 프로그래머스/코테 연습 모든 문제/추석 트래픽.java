import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int solution(String[] lines) {
        LinkedList<TimeStamp> timeStamps = new LinkedList<>();

        for (int i = 0; i < lines.length; i++) {
            int[] ints = convertMSAndWork(lines[i]);

            timeStamps.addLast(new TimeStamp(ints[0] - ints[1] + 1, State.START));
            timeStamps.addLast(new TimeStamp(ints[0] + 999, State.END));
        }

        timeStamps.sort(new Comparator<TimeStamp>() {
            @Override
            public int compare(TimeStamp o1, TimeStamp o2) {
                if(o1.timeMS != o2.timeMS) {
                    return o1.timeMS < o2.timeMS ? -1 : 1;
                }
                if(o1.state != o2.state) {
                    return o1.state.ordinal() < o2.state.ordinal() ? -1 : 1;
                }
                return 0;
            }
        });

        int workingCount = 0;
        int maxWorkingCount = 0;

        for(int i = 0; i < timeStamps.size(); i++) {
            if(timeStamps.get(i).state == State.START) {
                workingCount += 1;
            } else {
                workingCount -= 1;
            }

            maxWorkingCount = Integer.max(workingCount, maxWorkingCount);
        }
        return maxWorkingCount;
    }
    
    int[] convertMSAndWork(String s) {
        String[] split = s.split(" ");
        String[] temp = split[1].split("[:.]");

        int hh = Integer.parseInt(temp[0]) * 60 * 60;
        int mm = Integer.parseInt(temp[1]) * 60;
        int ss = Integer.parseInt(temp[2]);
        int ms = Integer.parseInt(temp[3]);

        ms += (hh + mm + ss) * 1000;
        int workMs = (int) (Double.parseDouble(split[2].replace("s", "")) * 1000);
        return new int[]{ms, workMs};
    }
    
    enum State {
        START, END
    }

    static class TimeStamp {
        int timeMS;
        State state;

        public TimeStamp(int timeMS, State state) {
            this.timeMS = timeMS;
            this.state = state;
        }
    }
}