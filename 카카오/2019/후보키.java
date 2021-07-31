import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    @Test
    public void Test() {
        int solution = solution2(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
        Assertions.assertEquals(solution, 2);
    }
    int STUDENT_NUM = 0;
    int NAME = 1;
    int MAJOR = 2;
    int GRADE = 3;
    Comparator<Integer> comparator = new Comparator<Integer>() {
        int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0) ++ret;
                n = n >> 1;
            }
            return ret;
        }
        @Override
        public int compare(Integer o1, Integer o2) {
            int x = countBits(o1), y = countBits(o2);
            if (x > y) {
                return 1;
            } else if ( x < y) {
                return -1;
            }
            else {
                return 0;
            }
        }
    };

    public int solution2(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;
        List<Integer> candidates = new LinkedList<>();

        for (int i = 1; i < (1 << colSize); ++i) {
            if (check(relation, rowSize, colSize i)) {
                candidates.add(i);
            }
        }

        Collections.sort(candidates, comparator);

        while (!candidates.isEmpty()) {
            int n = candidates.remove(0);
            ++answer;
            // candidates.removeIf(c -> (n & c) == n);
            for (Iterator<Integer> it = candidates.iterator(); it.hasNext();) {
                int c = it.next();
                if ((n & c) == n)
                    it.remove();
            }
        }

        return answer;
    }

    // 유일성 체크 (유일성이 확인되면 true 반환)
    public boolean check(String[][] relation, int rowSize, int colSize, int subset) {
        for (int i = 0; i < rowSize - 1; ++i) {
            for (int j = i + 1; j < rowSize; ++j) {
                boolean isSame = true;
                for (int z = 0; z < colSize; ++z) {
                    if ((subset & 1 << z) == 0) continue;
                    if (relation[i][z].equals(relation[j][z]) == false) {
                        isSame = false;
                        break;
                    }
                }
                // 모든 속성이 같다.
                if (isSame) {
                    return false;
                }
            }
        }
        return true;
    }
}