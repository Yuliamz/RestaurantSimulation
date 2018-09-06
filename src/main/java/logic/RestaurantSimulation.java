package logic;

import java.util.ArrayList;
import java.util.List;
import logic.entity.Diner;
import logic.entity.Dish;
import logic.entity.DishStat;
import logic.entity.SimulatedDiner;

/**
 *
 * @author Yuliamz
 */
public class RestaurantSimulation {
    private final int maxDiner;
    private final int minDiner;
    private final int maxWorkDayHours;
    private final int minWorkDayHours;
    private final int simulatedHours;
    private final double maxDinerPerHour;
    private final double minDinerPerHour;
    private final List<Double> dinersPerSimulatedHours;
    private final DishStat plato1;
    private final DishStat plato2;
    private final DishStat plato3;
    private final DishStat plato4;
    private final List<SimulatedDiner> simulatedDiners;
    

    public RestaurantSimulation(int maxDiner, int minDiner, int maxWorkDayHours, int minWorkDayHours, int simulatedHours) {
        this.maxDiner = maxDiner;
        this.minDiner = minDiner;
        this.maxWorkDayHours = maxWorkDayHours;
        this.minWorkDayHours = minWorkDayHours;
        this.simulatedHours = simulatedHours;
        this.maxDinerPerHour=maxDiner/minWorkDayHours;
        this.minDinerPerHour=minDiner/maxWorkDayHours;
        dinersPerSimulatedHours=UniformDistribution.generateAndMultiply(minDinerPerHour, maxDinerPerHour, 100, simulatedHours);
        dinersPerSimulatedHours.forEach(System.out::println);
        simulatedDiners = new ArrayList<>();
        plato1 = new DishStat(Dish.PLATO1);
        plato2 = new DishStat(Dish.PLATO2);
        plato3 = new DishStat(Dish.PLATO3);
        plato4 = new DishStat(Dish.PLATO4);
        
    }

    public List<Diner> simulateDiners(int diners){
        List<Diner> dsList = new ArrayList<>();
        for (int i = 0; i < diners; i++) {
            dsList.add(new Diner());
        }
        return dsList;
    }
    public void startSimulation(){
        for (int i = 0; i < dinersPerSimulatedHours.size(); i++) {
            List<Diner> ds = simulateDiners(dinersPerSimulatedHours.get(i).intValue());
            SimulatedDiner diner = new SimulatedDiner(ds);
            simulatedDiners.add(diner);
        }
        calcFinalStats();
    }
    
    void calcFinalStats(){
        
        for (int i = 0; i < simulatedDiners.size(); i++) {
            plato1.plusDishStat(simulatedDiners.get(i).getPl1());
            plato2.plusDishStat(simulatedDiners.get(i).getPl2());
            plato3.plusDishStat(simulatedDiners.get(i).getPl3());
            plato4.plusDishStat(simulatedDiners.get(i).getPl4());
        }
        plato1.setTotalSells(plato1.getTotalSells()/simulatedDiners.size());
        plato2.setTotalSells(plato2.getTotalSells()/simulatedDiners.size());
        plato3.setTotalSells(plato3.getTotalSells()/simulatedDiners.size());
        plato4.setTotalSells(plato4.getTotalSells()/simulatedDiners.size());
        
        plato1.setRankedSells(plato1.getRankedSells()/simulatedDiners.size());
        plato2.setRankedSells(plato2.getRankedSells()/simulatedDiners.size());
        plato3.setRankedSells(plato3.getRankedSells()/simulatedDiners.size());
        plato4.setRankedSells(plato4.getRankedSells()/simulatedDiners.size());
        
        plato1.setTotalRank(plato1.getTotalRank()/simulatedDiners.size());
        plato2.setTotalRank(plato2.getTotalRank()/simulatedDiners.size());
        plato3.setTotalRank(plato3.getTotalRank()/simulatedDiners.size());
        plato4.setTotalRank(plato4.getTotalRank()/simulatedDiners.size());
        
        plato1.setRank(plato1.getTotalRank()/(double)plato1.getRankedSells());
        plato2.setRank(plato2.getTotalRank()/(double)plato2.getRankedSells());
        plato3.setRank(plato3.getTotalRank()/(double)plato3.getRankedSells());
        plato4.setRank(plato4.getTotalRank()/(double)plato4.getRankedSells());
    }
    
    public void printStats(){
        System.out.println(plato1.toString());
        System.out.println(plato2.toString());
        System.out.println(plato3.toString());
        System.out.println(plato4.toString());
    }

    public DishStat getPlato1() {
        return plato1;
    }

    public DishStat getPlato2() {
        return plato2;
    }

    public DishStat getPlato3() {
        return plato3;
    }

    public DishStat getPlato4() {
        return plato4;
    }
    
    
}
