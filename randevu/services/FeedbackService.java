package learn.randevu.services;

import learn.randevu.Specification.FeedbackSpecification;
import learn.randevu.entity.Feedback;
import learn.randevu.entity.Personel;
import learn.randevu.filter.FeedbackFilter;
import learn.randevu.repository.FeedbackRepository;
import learn.randevu.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private PersonelRepository personelRepository;

    public ResponseEntity<List<Feedback>> getAll() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    public ResponseEntity<Feedback> save(Feedback feedback) {
        Feedback feedback1 = feedbackRepository.save(feedback);

        Personel    personel=new Personel();
        int score=feedback1.getScor();
        feedback1.setScor(personel.getScor()+score);
        feedback1.setScor(personel.getScor()+feedback1.getScor());
        personelRepository.save(personel);


        return new ResponseEntity<>(feedback1, HttpStatus.CREATED);
    }

    public ResponseEntity<Feedback> updateFeedback(Feedback feedback) {
        Feedback feedback1 = feedbackRepository.save(feedback);
        if (feedback1 != null) {
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public List<Feedback> getFeedbackFilter(FeedbackFilter filter) {
        return feedbackRepository.findAll(FeedbackSpecification.filter(filter));
    }
}
