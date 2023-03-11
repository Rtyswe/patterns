package rtyswe.edu.strategy;

import java.util.*;

public class BadStrategy implements Strategy {

    @Override
    public Map<Integer, Integer> countNumberOfOccurrences(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num: array) {
            set.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num: set) {
            map.put(num, (int) Arrays.stream(array).filter(el -> el == num).count());
        }

        return map;
    }
}
