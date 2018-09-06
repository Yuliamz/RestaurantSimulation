package logic.entity;

import java.util.List;

/**
 *  Simulacion correspondiente a X horas de trabajo, con X cantidad de comensales
 * @author Yuliamz
 */
public class SimulatedDiner {
        DishStat pl1 = new DishStat(Dish.BANDEJA_PAISA);
        DishStat pl2 = new DishStat(Dish.CUCHUCO_DE_TRIGO);
        DishStat pl3 = new DishStat(Dish.PAELLA_VALENCIANA);
        DishStat pl4 = new DishStat(Dish.ARROZ_CON_POLLO);
        /**
         * constructor
         * @param diners lista de comensales con sus correspondientes platos
         */
    public SimulatedDiner(List<Diner> diners) {
        for (int i = 0; i < diners.size(); i++) {
            Diner diner = diners.get(i);
            switch(diner.getDish()){
                case BANDEJA_PAISA:addDinnerToStat(diner, pl1);break;
                case CUCHUCO_DE_TRIGO:addDinnerToStat(diner, pl2);break;
                case PAELLA_VALENCIANA:addDinnerToStat(diner, pl3);break;
                case ARROZ_CON_POLLO:addDinnerToStat(diner, pl4);break;
                default:break;
            }
        }
    }
    /**
     * agrega un nuevo comensal a las estadisticas
     * @param d comensal
     * @param ds estadísticas
     */
    private void addDinnerToStat(Diner d,DishStat ds){
        ds.addSell();
        if (d.isIsRated()) {
            ds.addRatedSell();
            ds.addRank(d.getRate());
        }
    }
/**
 * gets y sets
 */
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
