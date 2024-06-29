package learn.randevu.mapper;

import learn.randevu.dto.PaymentHistoryDto;
import learn.randevu.dto.ServiceDto;
import learn.randevu.dto.UserDto;
import learn.randevu.entity.PaymentHistory;
import learn.randevu.entity.Services;
import learn.randevu.entity.User;


public class PaymentHistoryMapper {
    public static PaymentHistory mapToPaymentHistory(PaymentHistoryDto paymentHistoryDto) {
        User users = UserMapper.mapToUser(UserMapper.mapToUserDto(paymentHistoryDto.getUser_id()));
        Services services = ServiceMapper.mapToService(ServiceMapper.mapToServiceDto(paymentHistoryDto.getServices_id()));
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setId(paymentHistoryDto.getId());
        paymentHistory.setAmount(paymentHistoryDto.getAmount());
        return paymentHistory;
    }

    public static PaymentHistoryDto mapToPaymentHistoryDto(PaymentHistory paymentHistory) {
        UserDto userDto = UserMapper.mapToUserDto(paymentHistory.getUser_id());
        ServiceDto serviceDto = ServiceMapper.mapToServiceDto(paymentHistory.getServices_id());
        PaymentHistoryDto paymentHistoryDto = new PaymentHistoryDto();
        paymentHistoryDto.setId(paymentHistory.getId());
        paymentHistoryDto.setAmount(paymentHistory.getAmount());
        return paymentHistoryDto;
    }
}
