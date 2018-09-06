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
    
    /**
     * Genera enteros pseudoaleatorios con la distribución uniforme 
     * @param min valor mínimo
     * @param max valor máximo
     * @param amount cantidad de enteros a generar
     * @return lista con los enteros generados
     */
    public static List<Integer> generate(int min,int max,int amount){
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add((int)(min+((max-min)*Math.random())));
        return nums;
    }
    /**
     * Genera numeros pseudoaleatorios con la distribución uniforme 
     * @param min valor mínimo
     * @param max valor máximo
     * @param amount cantidad de numeros a generar
     * @return lista con los numeros generados
     */
    public static List<Double> generate(double min,double max,int amount){
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add(min+((max-min)*Math.random()));
        return nums;
    }
    /**
     * Genera numeros pseudoaleatorios con la distribución uniforme y multiplica por la cantidad de horas a simular
     * @param min valor mínimo
     * @param max valor máximo
     * @param amount cantidad de números a generar
     * @param simulatedHours cantidad de horas a simular
     * @return lista con los números generados
     */
    public static List<Double> generateAndMultiply(double min,double max,int amount,int simulatedHours){
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) nums.add((min+((max-min)*Math.random()))*simulatedHours);
        return nums;
    }
}
