class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < phone_number.length - 4; i++) {
            builder.append("*");
        }

        for (int i = phone_number.length - 4; i < phone_number.length; i++) {
            builder.append(phone_number.charAt(i));
        }

        answer = builder.toString();

        return answer;
    }
}