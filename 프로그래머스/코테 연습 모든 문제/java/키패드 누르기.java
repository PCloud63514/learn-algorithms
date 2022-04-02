class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        int leftIndex = 10;
        int rightIndex = 12;


        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7: builder.append("L"); leftIndex = number; break;
                case 3:
                case 6:
                case 9: builder.append("R"); rightIndex = number; break;
                default:
                    int leftDistance = getRemainDistance(leftIndex, number);
                    int rightDistance = getRemainDistance(rightIndex, number);

                    if (leftDistance < rightDistance) {
                        builder.append("L");
                        leftIndex = number;
                    } else if (rightDistance < leftDistance) {
                        builder.append("R");
                        rightIndex = number;
                    } else {
                        if ("left".equals(hand)) {
                            builder.append("L");
                            leftIndex = number;
                        } else {
                            builder.append("R");
                            rightIndex = number;
                        }
                    }
                    break;
            }
        }

        answer = builder.toString();

        return answer;
    }

    public int getRemainDistance(int index, int number) {
        index = index == 0 ? 11 : index;
        number = number == 0 ? 11 : number;

        int indexX = (index - 1) / 3;
        int indexY = (index - 1) % 3;

        int numberX = number / 3;
        int numberY = 1; // 어차피 이 함수를 호출하는 숫자는 가운데 위치하기 때문에 1
        int remainDistanceX = Math.abs(indexX - numberX); // 절댓값 처리
        int remainDistanceY = Math.abs(indexY - numberY); // 절댓값 처리

        return remainDistanceX + remainDistanceY;
    }
}