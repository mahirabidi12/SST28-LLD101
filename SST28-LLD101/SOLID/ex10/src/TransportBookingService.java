public class TransportBookingService {

    private final DistanceService distanceService;
    private final FarePolicy farePolicy;
    private final DriverService driverService;
    private final PaymentService paymentService;


    public TransportBookingService(
            DistanceService distanceService,
            FarePolicy farePolicy,
            DriverService driverService,
            PaymentService paymentService) {
        this.distanceService = distanceService;
        this.farePolicy = farePolicy;
        this.driverService = driverService;
        this.paymentService = paymentService;
    }


    public void book(TripRequest req) {

        double km = distanceService.computeKm(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverService.assignDriver(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = farePolicy.computeFare(km);

        String txn = paymentService.processPayment(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
