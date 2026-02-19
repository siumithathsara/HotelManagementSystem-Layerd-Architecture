package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private String payment_id;
    private String bill_id;
    private LocalDate payment_date;
    private double amount;
    private String payment_method;
    private String payment_status;
    private String received_by;

    public Payment(String paymentId, LocalDate paymentDate, double amount, String paymentMethod, String paymentStatus) {
                                this.payment_id = paymentId;
                                this.payment_date = paymentDate;
                                this.amount = amount;
                                this.payment_method = paymentMethod;
                                this.payment_status = paymentStatus;

    }
}
