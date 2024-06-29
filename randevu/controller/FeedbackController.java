package learn.randevu.controller;

import learn.randevu.entity.Feedback;
import learn.randevu.entity.Personel;
import learn.randevu.entity.User;
import learn.randevu.filter.FeedbackFilter;
import learn.randevu.repository.FeedbackRepository;
import learn.randevu.services.FeedbackService;
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
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("all")
    public ResponseEntity<List<Feedback>> all() {
        return feedbackService.getAll();
    }

    @PostMapping("save")
    public ResponseEntity<Feedback> save(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Feedback> delete(@RequestBody Feedback feedback) {
        feedbackRepository.delete(feedback);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update")
    public ResponseEntity<Feedback> update(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }

    @GetMapping("page")
    public Page<Feedback> page(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return feedbackRepository.findAll(pageRequest);
    }

    @GetMapping("filter")
    public List<Feedback> getFeedback(@RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) User user_id,
                                      @RequestParam(required = false) LocalDate date_,
                                      @RequestParam(required = false) Time time_,
                                      @RequestParam(required = false) Integer scor,
                                      @RequestParam(required = false) String comment_,
                                      @RequestParam(required = false) Personel personel_id) {
        FeedbackFilter filter = new FeedbackFilter();
        filter.setId(id);
        filter.setUser_id(user_id);
        filter.setDate_(date_);
        filter.setTime_(time_);
        filter.setScor(scor);
        filter.setComment_(comment_);
        filter.setPersonel_id(personel_id);
        return feedbackService.getFeedbackFilter(filter);
    }
}
