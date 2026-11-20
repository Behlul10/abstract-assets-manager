import java.math.BigDecimal;

public class Cash extends Asset{
    public Cash(String description, String dateAcquired, BigDecimal origionalCost) {
        super(description, dateAcquired, origionalCost);
    }

    @Override
    public BigDecimal getValue() {
        return null;
    }
//Issue:
    // Class 'Cash' must either be declared abstract or implement abstract method 'getValue()' in 'Asset'

    //I can either make this class abstract or override getValue + add a constructor
}
