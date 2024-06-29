package learn.randevu.services;

import learn.randevu.Specification.BusinessSpecification;
import learn.randevu.entity.Account;
import learn.randevu.entity.Business;
import learn.randevu.entity.Communication;
import learn.randevu.entity.Reserve;

import learn.randevu.filter.BusinessFilter;
import learn.randevu.repository.BusinessRepository;
import learn.randevu.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;
    private Reserve reserve;
    private Account account;
    private Communication communication;
    @Autowired
    private CommunicationRepository communicationRepository;


    public List<Business> getAll() {
        return businessRepository.findAll();
    }

    public ResponseEntity<Business> updateBusiness(Business business) {
        Business updateBusiness = businessRepository.save(business);
        if (updateBusiness != null) {
            return new ResponseEntity<>(updateBusiness, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Business> save(Business business) {
        Business business1 = businessRepository.save(business);

        business1.setName_(communication.getName());
        business1.setType(communication.getType());
        business1.setEmail(communication.getEmail());
        business1.setAddress(communication.getAddress());
        business1.setPhone(communication.getTelNumber());
        communicationRepository.save(communication);
        return new ResponseEntity<>(business, HttpStatus.CREATED);
    }

    public List<Business> getBusinessFilter(BusinessFilter filter) {
        return businessRepository.findAll(BusinessSpecification.filter(filter));
    }
//    @PostPersist
//    public void postPersist(Reserve reserve) {
//        int incomes = reserve.getPersonel_id().getServices_id().getSalary_();
//        account.setRevenues(account.getRevenues()+incomes);
//        a




}
