package logic.entity;

import java.util.List;
import logic.UniformDistribution;

/**
 *
 * @author Yuliamz
 */
public class SimulatedDiner {
        DishStat pl1 = new DishStat(Dish.PLATO1);
        DishStat pl2 = new DishStat(Dish.PLATO2);
        DishStat pl3 = new DishStat(Dish.PLATO3);
        DishStat pl4 = new DishStat(Dish.PLATO4);
    public SimulatedDiner(List<Diner> diners) {
        for (int i = 0; i < diners.size(); i++) {
            Diner diner = diners.get(i);
            switch(diner.getDish()){
                case PLATO1:addDinnerToStat(diner, pl1);break;
                case PLATO2:addDinnerToStat(diner, pl2);break;
                case PLATO3:addDinnerToStat(diner, pl3);break;
                case PLATO4:addDinnerToStat(diner, pl4);break;
                default:break;
            }
        }
    }
    
    private void addDinnerToStat(Diner d,DishStat ds){
        ds.addSell();
        if (d.isIsRated()) {
            ds.addRatedSell();
            ds.addRank(d.getRate());
        }
    }

    public DishStat getPl1() {
        return pl1;
    }

    public void setPl1(DishStat pl1) {
        this.pl1 = pl1;
    }

    public DishStat getPl2() {
        return pl2;
    }

    public void setPl2(DishStat pl2) {
        this.pl2 = pl2;
    }

    public DishStat getPl3() {
        return pl3;
    }

    public void setPl3(DishStat pl3) {
        this.pl3 = pl3;
    }

    public DishStat getPl4() {
        return pl4;
    }

    public void setPl4(DishStat pl4) {
        this.pl4 = pl4;
    }
}
