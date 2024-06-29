package learn.randevu.mapper;

import learn.randevu.dto.BusinessDto;
import learn.randevu.dto.ServiceDto;
import learn.randevu.entity.Business;
import learn.randevu.entity.Services;

public class ServiceMapper {

    public static ServiceDto mapToServiceDto(Services services) {
        BusinessDto businessDto = BusinessMapper.mapToBusinessDto(services.getBusiness());
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(services.getId());
        serviceDto.setName_(services.getName_());

        return serviceDto;
    }

    public static Services mapToService(ServiceDto serviceDto) {
        Business business = BusinessMapper.mapToBusiness(BusinessMapper.mapToBusinessDto(serviceDto.getBusiness_id()));
        Services services = new Services();
        services.setId(serviceDto.getId());
        services.setName_(serviceDto.getName_());
        return services;
    }

}
