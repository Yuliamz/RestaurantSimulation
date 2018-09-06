package logic.entity;

import logic.UniformDistribution;

/**
 *
 * @author Yuliamz
 */
public enum Dish {
 PLATO1,PLATO2,PLATO3,PLATO4;
 
    public static Dish getRandomDish() {
        switch (UniformDistribution.RANDOM.nextInt(4)){
            case 0:return PLATO1;
            case 1:return PLATO2;
            case 2:return PLATO3;
            case 3:return PLATO4;
            default:return null;
        }
    }
}
