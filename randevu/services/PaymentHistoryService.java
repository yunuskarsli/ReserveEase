package learn.randevu.services;

import learn.randevu.Specification.PaymentHistorySpecification;
import learn.randevu.entity.PaymentHistory;
import learn.randevu.filter.PaymentHistoryFilter;
import learn.randevu.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentHistoryService {
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    public ResponseEntity<List<PaymentHistory>> getAll() {
        List<PaymentHistory> paymentHistories = paymentHistoryRepository.findAll();
        return new ResponseEntity<>(paymentHistories, HttpStatus.OK);
    }

    public ResponseEntity<PaymentHistory> save(PaymentHistory paymentHistory) {
        PaymentHistory paymentHistory1 = paymentHistoryRepository.save(paymentHistory);
        return new ResponseEntity<>(paymentHistory, HttpStatus.CREATED);

    }

    public ResponseEntity<PaymentHistory> updatePayment(PaymentHistory paymentHistory) {
        PaymentHistory paymentHistory1 = paymentHistoryRepository.save(paymentHistory);

        if (paymentHistory1 != null) {
            return new ResponseEntity<>(paymentHistory1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(paymentHistory1, HttpStatus.NO_CONTENT);
        }
    }

    public List<PaymentHistory> getPaymentHistoryFilter(PaymentHistoryFilter filter) {
        return paymentHistoryRepository.findAll(PaymentHistorySpecification.filter(filter));
    }


}
