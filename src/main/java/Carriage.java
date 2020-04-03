import java.util.ArrayList;
import java.util.List;

public class Carriage implements Comparable<Carriage> {
    private int number;
    private Integer arrivalTime;
    private int unloadingTime;
    private int profit;

    private List<Carriage> children;
    private int sumProfit;
    private Carriage maxParent;

    public boolean isInserted = false;

    public Carriage(int number, int arrivalTime, int unloadingTime, int profit){
        this.number = number;
        this.arrivalTime = arrivalTime;
        this.unloadingTime = unloadingTime;
        this.profit = profit;
        children = new ArrayList<>();
        this.sumProfit = profit;
    }

    public int getNumber() {return number;}

    public int getArrivalTime() {return arrivalTime;}

    public int getUnloadingTime() {return unloadingTime;}

    public int getProfit() {return profit;}

    public void insertChild (Carriage carriage) {
        children.add(carriage);
    }

    public void setSumProfit (int profit) {
        sumProfit = profit;
    }

    public int getSumProfit () {return sumProfit;}

    public void setMaxParent (Carriage parent) {
        maxParent = parent;
    }

    public Carriage getMaxParent () {
        return maxParent;
    }

    public List<Carriage> getChildren () {
        return children;
    }

    public boolean isSuitable (Carriage o) {
        return this.getArrivalTime() >= o.getArrivalTime() + o.getUnloadingTime();
    }

    // compares by the time of arrival
    @Override
    public int compareTo(Carriage o) {
        return this.arrivalTime.compareTo(o.arrivalTime);
    }

}
