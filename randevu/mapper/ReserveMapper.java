package learn.randevu.mapper;

import learn.randevu.dto.ReserveDto;
import learn.randevu.dto.UserDto;
import learn.randevu.entity.Reserve;
import learn.randevu.entity.User;


public class ReserveMapper {
    public static Reserve mapToReserve(ReserveDto reserveDto) {
        User user = UserMapper.mapToUser(UserMapper.mapToUserDto(reserveDto.getUser_id()));
        Reserve reserve = new Reserve();
        reserve.setId(reserveDto.getId());
        reserve.setAppointmentDateTime(reserveDto.getAppointmntDateTime());

        return reserve;
    }

    public static ReserveDto mapToReserveDto(Reserve reserve) {
        UserDto userDto = UserMapper.mapToUserDto(reserve.getUser_id());


        ReserveDto reserveDto = new ReserveDto();
        reserveDto.setId(reserve.getId());
        reserveDto.setAppointmntDateTime(reserve.getAppointmentDateTime());
        return reserveDto;
    }
}
