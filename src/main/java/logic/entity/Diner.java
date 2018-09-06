package logic.entity;

import logic.UniformDistribution;

/**
 *  Comensal
 * @author Yuliamz
 */
public class Diner {
    private Dish dish;
    private boolean isRated;
    private int rate;
    /**
     * constructor
     * genera un plato aleatorio
     * determina si califica o no el plato
     * se califica aleatoriamente el plato
     */
    public Diner() {
        dish=Dish.getRandomDish();
        isRated=UniformDistribution.RANDOM.nextBoolean();
        if (isRated) rate=UniformDistribution.RANDOM.nextInt(6);
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public boolean isIsRated() {
        return isRated;
    }

    public void setIsRated(boolean isRated) {
        this.isRated = isRated;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return dish.name()+": {Calificado: "+(isRated?"si":"no")+", calificacion:"+(isRated?rate:"")+"}";
    }
    
    
    
}