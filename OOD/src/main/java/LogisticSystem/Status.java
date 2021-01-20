package LogisticSystem;

public class Status {
    public enum VehicleStatus {
        FREE ,
        BUSY ,
        NOT_WORKING;
    }

    public enum OrderStatus {
        DELIVERED,
        PROCESSING,
        CANCELLED;
    }

    public enum PaymentStatus {
        PAID,
        UNPAID;
    }

    public enum OrderPriority {
        LOW,
        MEDIUM,
        HIGH;
    }
}
