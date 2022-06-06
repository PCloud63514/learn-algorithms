import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> queue = new PriorityQueue();
        Integer currentMinutes = parseTime("09:00");

        for (String time : timetable) {
            queue.add(parseTime(time));
        }
        // 마지막 탑승자를 기록 -> 해당 탑승자들 보다 빠르기만 하면 된다.
        ArrayList<Integer> passList = new ArrayList<>();
        // 셔틀버스 운행 횟수
        for (int i = 0; i < n; i++) {
            // 수용 인원
            passList = new ArrayList<>();
            // 대기자 존재 여부
            while (!queue.isEmpty()) {
                // 현재 시간 이후에 온 대기자는 지금 계산할 필요 없으므로 브레이크
                if (currentMinutes < queue.peek())
                    break;
                // 입장한 대기자의 수가 수용인원 수가 되었을 경우 브레이크
                if (passList.size() == m)
                    break;
                passList.add(queue.poll());
            }
            // 버스가 출발했으므로 다음 도착 시간만큼 더함
            currentMinutes += t;
        }

        // 마지막 셔틀버스가 수용인원을 최대로 채우지 못했다면 해당 버스를 탈 수 있는 시간이 정답
        // 하지만 셔틀버스가 이미 수용인원을 최대로 채웠다면 맨 마지막 셔틀버스에 탑승한 사람보다 1분 더 일찍 도착하면 정답
        int result = passList.size() < m ? (currentMinutes - t) :
                (passList.get(passList.size() - 1) - 1);


        return convertTime(result);
    }


    Integer parseTime(String time) {
        String[] split = time.split(":");
        Integer hour = Integer.parseInt(split[0]) * 60;
        Integer min = Integer.parseInt(split[1]);

        return hour + min;
    }

    String convertTime(int time) {
        int hour = time / 60;
        int min = time % 60;

        String strHour = hour >= 10 ? String.valueOf(hour) : "0" + hour;
        String strMin = min >= 10 ? String.valueOf(min) : "0" + min;

        return strHour + ":" + strMin;
    }
}