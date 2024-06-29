package learn.randevu.mapper;

import learn.randevu.dto.FeedbackDto;
import learn.randevu.dto.PersonelDto;
import learn.randevu.dto.UserDto;
import learn.randevu.entity.Feedback;
import learn.randevu.entity.Personel;
import learn.randevu.entity.User;


public class FeedbackMapper {
    public static FeedbackDto mapToFeedback(Feedback feedback) {
        User user = UserMapper.mapToUser(UserMapper.mapToUserDto(feedback.getUser_id()));
        Personel personel = PersonelMapper.mapToPersonel(PersonelMapper.mapToPersonelDto(feedback.getPersonel_id()));
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setComment_(feedback.getComment_());
        return feedbackDto;
    }

    public static Feedback mapToFeedbackDto(FeedbackDto feedbackDto) {
        UserDto userDto = UserMapper.mapToUserDto(feedbackDto.getUser_id());
        PersonelDto personelDto = PersonelMapper.mapToPersonelDto(feedbackDto.getPersonel_id());
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDto.getId());
        feedback.setComment_(feedbackDto.getComment_());
        return feedback;
    }
}
