//대학생 철수는 새 학기를 맞아 대학 수업 시간표를 만들려고 합니다. 철수는 이번 학기에 총 5가지 과목을 듣고자 하며, 각 과목은 4개의 분반으로 나누어져 있습니다. 즉 1번 과목은 ‘A’분반, ‘B’분반, ‘C’분반, ‘D’분반으로 나누어져 있고, 2,3,4,5번 과목 또한 각각 ‘A’분반, ‘B’분반, ‘C’분반, ‘D’분반으로 나누어져 있습니다. 과목별로 각 분반은 서로 다른 교수님이 강의 하므로, 각 분반의 수업 시간은 서로 다를 수도 있고, 겹칠 수도 있습니다.
//철수는 5가지 과목을 모두 들을 수 있도록 각 과목마다 4개의 분반 중 하나씩을 선택하여 시간표를 만들려 합니다.
//
//예를 들어 5개의 과목 분반들의 수업 시간이 서로 다른 과목 분반들의 수업 시간과 전혀 겹치지 않는다면,
//철수가 만들 수 있는 시간표는 총 1024(=4 x 4 x 4 x 4 x 4)가지입니다. 하지만 어떤 과목의 분반이 다른 과목의 분반과 수업 시간이 서로 겹치게 된다면 만들 수 있는 시간표의 가짓수는 줄어들게 됩니다.
//
//철수가 만들 수 있는 올바른 시간표는 몇 개인지를 구하려고 합니다. 올바른 시간표란, 듣고자 하는 5개의 과목 중 어떤 과목도 다른 과목과 수업 시간이 겹치지 않는 시간표를 말합니다.
//
//분반의 수업 시작 시각을 과목별로 담은 2차원 문자열 배열 schedule이 매개변수로 주어집니다. 만들 수 있는 올바른 시간표의 개수를 return 하도록 solution 함수를 완성해주세요.

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Program {
    public static void main(String[] args) {
        Program program = new Program();

    }

    static int START_TIME = 0;
    static int END_TIME = 1;
    public int solution(String[][] schedule) {
        int answer = -1;

        for (String[] classSchedules : schedule) {
            for (String classSchedule : classSchedules) {
                String[] split = classSchedule.split(" ");

                int day1 = DayEnum.valueOf(split[0]).value;
                int time1 = 0;
                String[] time1Split = split[1].split(":");
                time1 = (Integer.parseInt(time1Split[0]) * 60 * 60) + (Integer.parseInt(time1Split[1]) * 60);

            }
        }

        return answer;
    }

    class Node {
        DayEnum dayEnum;
        // 시간이 하나만 입력되면 3시간 수업
        // 두개가 입력되면 하나 씩 1시간 30분 수업
        // 시간을 정수로 변환해서 계산하는 것이 편해보임
        // 요일도 숫자로 변경? ㅇㅇ 요일도 숫자로 변경해서 곱하자
        // 끝나는 시간이 같으면 이건 통과해줘야함
        public Node(String schedule) {

        }
    }

    enum DayEnum {
        MO(1),
        TU(2),
        WE(3),
        TH(4),
        FR(5);

        final int value;
        DayEnum(int value) {
            this.value = value;
        }
    }
}
