package learn.randevu.mapper;

import learn.randevu.dto.PersonelDto;
import learn.randevu.dto.UserDto;
import learn.randevu.entity.Personel;
import learn.randevu.entity.User;

public class PersonelMapper {
    public static PersonelDto mapToPersonelDto(Personel personel) {
        UserDto userDto = UserMapper.mapToUserDto(personel.getUser_id());
        PersonelDto personelDto = new PersonelDto();
        personelDto.setId(personel.getId());
        personelDto.setScor(personel.getScor());
        return personelDto;
    }

    public static Personel mapToPersonel(PersonelDto personelDto) {
        User user = UserMapper.mapToUser(UserMapper.mapToUserDto(personelDto.getUser_id()));
        Personel personel = new Personel();
        personel.setId(personelDto.getId());
        personel.setScor(personelDto.getScor());
        return personel;
    }


}
