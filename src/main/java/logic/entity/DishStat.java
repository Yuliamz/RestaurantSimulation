package logic.entity;

/**
 *
 * @author Yuliamz
 */
public class DishStat {
    private Dish dish;
    private int totalSells;
    private int rankedSells;
    private double rank;
    private int totalRank;

    public DishStat(Dish dish) {
        this.dish=dish;
        totalSells=0;
        rank=0;
        rankedSells=0;
        totalRank=0;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
    }
    

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getTotalSells() {
        return totalSells;
    }

    public void setTotalSells(int totalSells) {
        this.totalSells = totalSells;
    }

    public int getRankedSells() {
        return rankedSells;
    }

    public void setRankedSells(int rankedSells) {
        this.rankedSells = rankedSells;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
    
    public void addSell(){
        this.totalSells+=1;
    }
    public void addRatedSell(){
        this.rankedSells+=1;
    }
    public void addRank(int rank){
        this.totalRank+=rank;
        this.rank=totalRank/rankedSells;
    }
    
    public void plusDishStat(DishStat ds){
        this.totalSells+=ds.getTotalSells();
        this.rank+=ds.getRank();
        this.rankedSells+=ds.getRankedSells();
        this.totalRank+=ds.getTotalRank();
    }

    @Override
    public String toString() {
        return dish.name()+" {Ventas Totales: "+totalSells+", Ventas calificadas: "+rankedSells+", Calificación total: "+totalRank+", Calificación: "+rank+"}";
    }
    
}
