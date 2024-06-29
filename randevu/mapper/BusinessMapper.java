package learn.randevu.mapper;

import learn.randevu.dto.BusinessDto;
import learn.randevu.entity.Business;


public class BusinessMapper {
    public static BusinessDto mapToBusinessDto(Business business){
        BusinessDto businessDto=new BusinessDto();
        businessDto.setId(business.getId());
        businessDto.setName_(business.getName_());
        businessDto.setType(business.getType());
        businessDto.setAddress(business.getAddress());
        return businessDto;
    }


    public static Business mapToBusiness(BusinessDto businessDto){
        Business business=new Business();
        business.setId(businessDto.getId());
        business.setName_(businessDto.getName_());
        business.setType(businessDto.getType());
        business.setAddress(businessDto.getAddress());

        return business;
    }



}
