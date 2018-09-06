package logic.entity;

import logic.UniformDistribution;

/**
 * Platos
 * @author Yuliamz
 */
public enum Dish {
 BANDEJA_PAISA,CUCHUCO_DE_TRIGO,PAELLA_VALENCIANA,ARROZ_CON_POLLO;
 
    public static Dish getRandomDish() {
        switch (UniformDistribution.RANDOM.nextInt(4)){
            case 0:return BANDEJA_PAISA;
            case 1:return CUCHUCO_DE_TRIGO;
            case 2:return PAELLA_VALENCIANA;
            case 3:return ARROZ_CON_POLLO;
            default:return null;
        }
    }
}
