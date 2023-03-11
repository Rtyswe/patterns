package rtyswe.edu.strategy;

import java.util.HashMap;
import java.util.Map;

public class OptimalStrategy implements Strategy {
    @Override
    public Map<Integer, Integer> countNumberOfOccurrences(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}
