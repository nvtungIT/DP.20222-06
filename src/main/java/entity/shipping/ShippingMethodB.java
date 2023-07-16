package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class ShippingMethodA extends ShippingStrategy {
    @Override
    public int getShippingFee(DistanceCalculator distanceCalculator, Order order, String address, String province) {
        int distance = distanceCalculator.calculateDistance(address, province);
        
        // caculate kilos and V from orderMediaList items
        int kilos = 0;
        int v = 0;

        for(int i = 0; i < Order.orderMediaList.length; i++) {
            // giả sử tạm thời mỗi item là 1kg
            kilos += Order.orderMediaList[i].getQuantity() * 1;
            
            // giả sử tạm thời mỗi item kích thước là 20 x 30 x 40
            v += Order.orderMediaList[i].getQuantity() * 20 * 30 * 40 / 6000;
        }
        return (int) (distance * 1.2 + kilos * 10 + v * 10);
    }
}
