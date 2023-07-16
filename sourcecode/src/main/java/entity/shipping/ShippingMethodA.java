package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class ShippingMethodA extends ShippingStrategy {
    @Override
    public int getShippingFee(DistanceCalculator distanceCalculator, Order order, String address, String province) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }
}
