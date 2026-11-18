import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition; //1, 2, 3, or 4
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public int getLotSize() { return lotSize; }

    public void setLotSize(int lotSize) { this.lotSize = lotSize; }

    public int getSquareFoot() { return squareFoot; }

    public void setSquareFoot(int squareFoot) { this.squareFoot = squareFoot; }

    public int getCondition() { return condition; }

    public void setCondition(int condition) { this.condition = condition; }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal lotSizeAddition = BigDecimal.ZERO;
        BigDecimal squareFootMultiplier = BigDecimal.ZERO;
        switch (this.condition) {
            case 1 -> squareFootMultiplier = BigDecimal.valueOf(180.00);
            case 2 -> squareFootMultiplier = BigDecimal.valueOf(130.00);
            case 3 -> squareFootMultiplier = BigDecimal.valueOf(90.00);
            case 4 -> squareFootMultiplier = BigDecimal.valueOf(80.00);
            default -> {
                throw new RuntimeException("WRONG ESTATE!");
            }
        }
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal lotSize = new BigDecimal(this.lotSize);
        BigDecimal squareFoot = new BigDecimal(this.squareFoot);

        lotSizeAddition = quarter.multiply(lotSize);
        return (squareFootMultiplier.multiply(squareFoot)).add(lotSizeAddition);
    }
}
