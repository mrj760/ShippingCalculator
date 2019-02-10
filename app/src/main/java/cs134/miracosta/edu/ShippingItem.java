package cs134.miracosta.edu;

public class ShippingItem {

    final private double baseCost = 3;
    private int weight;
    private double addedCost;
    private double totalCost;

    // instantiate with no data on item, to be added in TextEdit
    public ShippingItem() {
        weight =0;
        addedCost=0;
        totalCost=0;
    }

    // just need to know the new weight. This will take care of the rest. No setters necessary
    public void updateTotalCost(int weight) {
        this.weight = weight;
        if (weight<=16)
        {
            addedCost=0;
            totalCost=3;
            return;
        }
        addedCost+=(((weight-12)/4)*.50);
        totalCost = baseCost+addedCost;
    }


    public double getAddedCost() {
        return addedCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getWeight() {
        return weight;
    }
}
