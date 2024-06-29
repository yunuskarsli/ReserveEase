package learn.randevu.controller;

import learn.randevu.entity.Business;
import learn.randevu.entity.Services;
import learn.randevu.filter.ServiceFilter;
import learn.randevu.repository.ServiceReporisitory;
import learn.randevu.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")

public class ServiceController {
    @Autowired
    private ServiceReporisitory serviceReporisitory;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("all")
    public ResponseEntity<List<Services>> getAllService() {
        return serviceService.getAllService();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Services> delete(@RequestBody Services services) {
        serviceReporisitory.delete(services);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("page")
    public Page<Services> getServices(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return serviceReporisitory.findAll(pageRequest);
    }

    @PutMapping("update")
    public ResponseEntity<Services> update(@RequestBody Services services) {
        return serviceService.updateService(services);
    }

    @PostMapping("save")
    public ResponseEntity<Services> save(@RequestBody Services services) {
        return serviceService.save(services);
    }

    @GetMapping("filter")
    public List<Services> getServiceFilter(@RequestParam(required = false) Integer id,
                                           @RequestParam(required = false) String name_,
                                           @RequestParam(required = false) Integer salary_,
                                           @RequestParam(required = false) Business business_id) {
        ServiceFilter filter = new ServiceFilter();
        filter.setId(id);
        filter.setName_(name_);
        filter.setSalary_(salary_);
        filter.setBusiness_id(business_id);
        return serviceService.getServiceFilter(filter);
    }
}
