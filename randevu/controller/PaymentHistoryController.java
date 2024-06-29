package learn.randevu.controller;

import learn.randevu.entity.PaymentHistory;
import learn.randevu.entity.Services;
import learn.randevu.entity.User;
import learn.randevu.filter.PaymentHistoryFilter;
import learn.randevu.repository.PaymentHistoryRepository;
import learn.randevu.services.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("paymenthistory")
public class PaymentHistoryController {
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;
    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping("all")
    public ResponseEntity<List<PaymentHistory>> getAll() {
        return paymentHistoryService.getAll();
    }

    @GetMapping("page")
    public Page<PaymentHistory> page(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return paymentHistoryRepository.findAll(pageRequest);
    }

    @PostMapping("save")
    public ResponseEntity<PaymentHistory> save(@RequestBody PaymentHistory paymentHistory) {
        return paymentHistoryService.save(paymentHistory);
    }

    @PutMapping("update")
    public ResponseEntity<PaymentHistory> update(@RequestBody PaymentHistory paymentHistory) {
        return paymentHistoryService.updatePayment(paymentHistory);
    }

    @DeleteMapping("delete")
    public ResponseEntity<PaymentHistory> delete(@RequestBody PaymentHistory paymentHistory) {
        paymentHistoryRepository.delete(paymentHistory);
        return new ResponseEntity<>(paymentHistory, HttpStatus.NO_CONTENT);
    }

    @GetMapping("filter")
    public List<PaymentHistory> getPaymentHistoryFilter(@RequestParam(required = false) Integer id,
                                                        @RequestParam(required = false) User user_id,
                                                        @RequestParam(required = false) Services service_id,
                                                        @RequestParam(required = false) Integer amount,
                                                        @RequestParam(required = false) LocalDate date_,
                                                        @RequestParam(required = false) Time time_) {
        PaymentHistoryFilter filter = new PaymentHistoryFilter();
        filter.setId(id);
        filter.setUser_id(user_id);
        filter.setServices_id(service_id);
        filter.setAmount(amount);
        filter.setDate_(date_);
        filter.setTime_(time_);
        return paymentHistoryService.getPaymentHistoryFilter(filter);

    }
}
