package entity.shipping;
import org.example.AlternativeDistanceCalculator;
import org.example.DistanceCalculator;
import entity.order.Order;

// Adapter pattern
public class AltDistanceCalculatorAdapter extends DistanceCalculator {
    private AlternativeDistanceCalculator altDistanceCalculator;

    public AltDistanceCalculatorAdapter(AlternativeDistanceCalculator altDistanceCalculator) {
        this.altDistanceCalculator = altDistanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        return this.altDistanceCalculator.calculateDistance(province + address);
    }
}
