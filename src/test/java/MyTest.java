import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    private final CarriagesTree tree = new CarriagesTree();

    @Test
    public void MyTest() {
        List<Carriage> carriageList = new ArrayList<>();
        carriageList.add(new Carriage(1, 1, 2, 2));
        carriageList.add(new Carriage(2, 1, 4, 6));
        carriageList.add(new Carriage(3, 2, 4, 8));
        carriageList.add(new Carriage(4, 3, 3, 7));
        carriageList.add(new Carriage(5, 4, 2, 5));
        carriageList.add(new Carriage(6, 5, 1, 2));
        carriageList.add(new Carriage(7, 7, 1, 1));

        tree.insertAll(carriageList);

        StringBuilder result = tree.getMaxPathResult();
        Assert.assertEquals("7 <- 4 <- 1", result.toString());
        Assert.assertEquals(10, tree.getResultProfit());
    }
}
