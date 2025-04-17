package nextstep.courses.domain;

import nextstep.payments.domain.Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Session {

    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPaid;
    private int price;
    private int capacity;
    private int enrolledCount;
    private SessionStatusType status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Session(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Session(String title, boolean isPaid, int capacity, int price) {
        this(0L, title, null, null, isPaid, capacity, 0, SessionStatusType.PREPARING, price);
    }

    public Session(Long id, String title, LocalDate startDate, LocalDate endDate, boolean isPaid, int capacity, int enrolledCount, SessionStatusType status, int price) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        this.capacity = capacity;
        this.enrolledCount = enrolledCount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateStatus(SessionStatusType status) {
        this.status = status;
    }

    public void register(Payment payment) {

    }
}
