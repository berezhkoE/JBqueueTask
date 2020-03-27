import java.util.Collections;
import java.util.List;

public class CarriagesTree {
    private Carriage root = new Carriage(0, 0, 0, 0);
    private Carriage max = root;

    public void insertAll (List<Carriage> carriages) {
        Collections.sort(carriages);

        for (Carriage carriage: carriages) {
            insert(root, carriage);
            if (carriage.getSumProfit() > max.getSumProfit()) {
                max = carriage;
            }
        }
    }

    private void insert (Carriage current, Carriage o) {
        if (o.isSuitable(current) && current.getChildren().size() > 0) {
            for (Carriage child : current.getChildren()) {
                insert(child, o);
            }
            if (!o.isInserted) {
                addChild(current, o);
            }
        }
        else if (o.isSuitable(current)) {
            addChild(current, o);
        }
    }

    private void addChild (Carriage parent, Carriage child) {
        parent.insertChild(child);
        if (child.getSumProfit() < parent.getSumProfit() + child.getProfit()) {
            child.setSumProfit(parent.getSumProfit() + child.getProfit());
            child.setMaxParent(parent);
        }
        child.isInserted = true;
    }

    private void maxPathResult (Carriage max, StringBuilder result) {
        if (max.getMaxParent() != null) {
            result.append(max.getNumber()).append(" <- ");
            maxPathResult(max.getMaxParent(), result);
        }
        else
            result.append(max.getNumber());
    }

    public StringBuilder getMaxPathResult() {
        StringBuilder result = new StringBuilder();
        maxPathResult(max, result);
        return result;
    }

    public int getResultProfit() {
        return max.getSumProfit();
    }
}
