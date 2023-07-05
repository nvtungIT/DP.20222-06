package entity.shipping;

import entity.order.Order;
import entity.shipping.ShippingStrategy;
import org.example.DistanceCalculator;

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;
    private ShippingStrategy shippingStrategy = new ShippingStrategy();

// strategy: Khi có thêm một cách tính toán khác, đòi hỏi cần thay đổi mã nguồn trực tiếp tại đây, tuy nhiên ta thấy các thông tin liên quan vận chuyển trừ shipping không thay đổi, 
// ta cũng muốn mình có thể thay đổi bất kỳ hình thức tính phí trong thời gian chạy => strategy pattern
    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

    // vi phạm OCP: hiện tại chỉ tính phí ship theo khoảng cách, sau này nếu thêm hình thức tính phí ship theo cân nặng thì phải sửa đổi trực tiếp mã nguồn
    // vi phạm DIP: phụ thuộc trực tiếp vào lớp concrete CalculateDistance. Sau này có thêm hình thức ship khác, cách tính phí vận chuyển khác thì cần phải thay đổi
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    // strategy
    public int calculateShippingFeeByStrategy(Order order) {
        return this.shippingStrategy.getShippingFee(distanceCalculator, order, address, province);
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
