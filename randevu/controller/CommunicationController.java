package learn.randevu.controller;

import learn.randevu.entity.Communication;
import learn.randevu.services.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("communication")
public class CommunicationController {
    @Autowired
    private CommunicationService communicationService;
    @GetMapping("all")
    public ResponseEntity<List<Communication>> all() {
        return communicationService.getAll();
    }

}
