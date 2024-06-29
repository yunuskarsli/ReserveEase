package learn.randevu.services;

import learn.randevu.Specification.ServiceSpecification;
import learn.randevu.entity.Services;
import learn.randevu.filter.ServiceFilter;
import learn.randevu.repository.ServiceReporisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceReporisitory serviceReporisitory;

    public ResponseEntity<List<Services>> getAllService() {
        List<Services> service = serviceReporisitory.findAll();
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    public ResponseEntity<Services> updateService(Services services) {
        Services updateService = serviceReporisitory.save(services);
        if (updateService != null) {
            return new ResponseEntity<>(updateService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Services> save(Services services) {
        Services services1 = serviceReporisitory.save(services);
        return new ResponseEntity<>(services1, HttpStatus.CREATED);
    }

    public List<Services> getServiceFilter(ServiceFilter filter) {
        return serviceReporisitory.findAll(ServiceSpecification.filter(filter));
    }

}
