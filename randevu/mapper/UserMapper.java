package learn.randevu.mapper;

import learn.randevu.dto.UserDto;
import learn.randevu.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName_(user.getUsername());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setSurname(userDto.getName_());
        user.setUsername(userDto.getName_());
        return user;
    }

}
