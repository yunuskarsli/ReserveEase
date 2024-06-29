package learn.randevu.controller;

import learn.randevu.entity.Business;
import learn.randevu.entity.User;
import learn.randevu.filter.BusinessFilter;
import learn.randevu.repository.BusinessRepository;
import learn.randevu.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessRepository  businessRepository;

    @GetMapping("all")
    public List<Business> getAll(){
        return businessService.getAll();
    }
    @GetMapping("page")
    public Page<Business> getBusiness(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest=PageRequest.of(page, size);
        return businessRepository.findAll(pageRequest);
    }
    @DeleteMapping("delete")
    public ResponseEntity<User> deleteUser(@RequestBody Business business){
        businessRepository.delete(business);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("updaate")
    public ResponseEntity<Business> update(@RequestBody Business business){
        return businessService.updateBusiness(business);
    }
    @PostMapping("save")
    public  ResponseEntity<Business> save(@RequestBody Business business ) {
        return businessService.save(business);
    }
    @GetMapping("filter")
    public List<Business> getUserFilter(@RequestParam (required = false) Integer id,
                                    @RequestParam (required = false) String name,
                                    @RequestParam (required = false) String type,
                                    @RequestParam(required = false) String address,
                                    @RequestParam(required = false) User owner_id){
        BusinessFilter filter=new BusinessFilter();
        filter.setId(id);
        filter.setName_(name);
        filter.setType(type);
        filter.setAddress(address);
        filter.setOwner_id(owner_id);
        return businessService.getBusinessFilter(filter);
    }
}

