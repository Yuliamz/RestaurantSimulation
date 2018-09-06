package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Yuliamz
 */
public class UniformDistribution {
    
    public static final Random RANDOM = ThreadLocalRandom.current();
    
    public static List<Integer> generate(int min,int max,int amount){
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add((int)(min+((max-min)*Math.random())));
        return nums;
    }
    public static List<Double> generate(double min,double max,int amount){
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add(min+((max-min)*Math.random()));
        return nums;
    }
    public static List<Double> generateAndMultiply(double min,double max,int amount,int simulatedHours){
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add((min+((max-min)*Math.random()))*simulatedHours);
        return nums;
    }
}
