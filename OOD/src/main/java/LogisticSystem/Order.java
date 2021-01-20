package LogisticSystem;

import java.sql.Time;
import java.util.List;

public class Order {
    int order_id;
    Status.OrderPriority priority_of_order;
    Client owner_of_order;
    Location destination;
    int amount_of_charge;
    List<Item> items;
    int total_weight;
    Status.OrderStatus current_status;
    Status.PaymentStatus status_of_payment;
    Time time_of_order_placed;
    Time time_of_delivery;
}
