package learn.randevu.services;

import learn.randevu.Specification.ReserveSpecification;
import learn.randevu.entity.Account;
import learn.randevu.entity.Business;
import learn.randevu.entity.Personel;
import learn.randevu.entity.Reserve;
import learn.randevu.filter.ReserveFilter;
import learn.randevu.repository.AccountRepository;
import learn.randevu.repository.PersonelRepository;
import learn.randevu.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;
    @Autowired
    private PersonelRepository personelRepository;

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    private Business business;
    private Personel personel;



    public ResponseEntity<List<Reserve>> getAll(Reserve reserve) {
        List<Reserve> reserves = reserveRepository.findAll();
        return new ResponseEntity<>(reserves, HttpStatus.OK);
    }

    public ResponseEntity<Reserve> save(Reserve reserve) {
//        Reserve reserve1 = reserveRepository.save(reserve);
//        Account account=accountService.findByBusinessId(reserve.getPersonel_id().getServices_id().getBusiness_id().getId().longValue());
//        account.setRevenues(account.getRevenues() + reserve.getPersonel_id().getServices_id().getSalary_());
//        account.setBalance(account.getBalance()+reserve.getPersonel_id().getServices_id().getSalary_());
//        accountService.save(account);
        return new ResponseEntity<>(reserve, HttpStatus.CREATED);
    }

    public ResponseEntity<Reserve> updateReserve(Reserve reserve) {
        Reserve reserve1 = reserveRepository.save(reserve);
        if (reserve != null) {
            return new ResponseEntity<>(reserve1, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(reserve1, HttpStatus.NO_CONTENT);
        }
    }

    public List<Reserve> getReserveFilter(ReserveFilter filter) {
        return reserveRepository.findAll(ReserveSpecification.filter(filter));
    }

    public ResponseEntity<?> saveReservation(LocalDateTime appointmentDateTime, Reserve reserve) {
        if (appointmentDateTime == null || reserve == null) {
            return ResponseEntity.badRequest().body("Geçersiz istek. Lütfen tüm alanları doldurun.");
        }
        // Geçerli tarih ve saat kontrolü
        if (!isValidDateTime(appointmentDateTime)) {
            return ResponseEntity.badRequest().body("Geçersiz tarih veya saat seçimi. " +
                    "Lütfen 14 gün içinde ve 08:00 - 18:00 arasnda bir zaman seçinn.");
        }
        try {
            // Business ID'yi Personel'den al
            Integer businessId = reserve.getPersonel_id().getServices_id().getBusiness().getId();


            // Account tablosundan ilgili kaydı bul
            Account account = accountService.findByBusinessId(businessId);
            if (account == null) {
                return ResponseEntity.badRequest().body("İlgili Account bulunamadı.");
            }
            account.setRevenues(account.getRevenues() + reserve.getPersonel_id().getServices_id().getSalary_());
            account.setBalance(account.getBalance() + reserve.getPersonel_id().getServices_id().getSalary_());
            accountService.save(account);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }




        if (isAppointmentAvailable(appointmentDateTime)) {
//            Personel personel1=reserve.getPersonel_id();
//            reserve.setAppointmentDateTime(personel1.getPersonAppointment());
//
//            Reserve savedReserve = reserveRepository.save(reserve);
//
//            Business business1=reserve.getPersonel_id().getServices_id().getBusiness();
//            reserve.setAppointmentDateTime(business1.getBusiness_appointment());
//
////
            reserve.setAppointmentDateTime(reserve.getAppointmentDateTime());
            reserve.setPersonel_id(reserve.getPersonel_id());
            reserve.setUser_id(reserve.getUser_id());
////
//            reserve.setAppointmentDateTime(reserve.getPersonel_id().getPersonAppointment());
//            reserve.setAppointmentDateTime(reserve.getPersonel_id().getServices_id().getBusiness().getBusiness_appointment());
//            personelRepository.save(personel);


            reserveRepository.save(reserve);

//            PersonelAppointment personelAppointment = new PersonelAppointment();
//            personelAppointment.setAppointmentDatetime(appointmentDateTime);
//            PersonelAppointment savedPersonelAppointment=personelAppointmentRepository.save(personelAppointment);
//            Reserve tablosuna kayıt ekleme


            return ResponseEntity.ok("Rezervasyon başarıyla kaydedildi.");
        } else {
            return ResponseEntity.badRequest().body("Belirtilen saat ve tarih için randevu mevcut. Lütfen başka bir saat seçin.");
        }
    }

    private boolean isValidDateTime(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime maxDate = now.plusDays(14);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(18, 0);
        LocalTime selectedTime = dateTime.toLocalTime();
        return !dateTime.isBefore(now) && !dateTime.isAfter(maxDate) &&
                selectedTime.isAfter(startTime) && selectedTime.isBefore(endTime);
    }

    private boolean isAppointmentAvailable(LocalDateTime dateTime) {
        List<Reserve> existingAppointments = reserveRepository.findByAppointmentDateTime(dateTime);
        return existingAppointments.isEmpty();
    }
    @Scheduled(cron = "0 00  00 * * ?")
    public void expiredReserves(){
        LocalDateTime now=LocalDateTime.now();
        List<Reserve> expiredReservations = reserveRepository.findByAppointmentDateTimeBefore(now);

        if (!expiredReservations.isEmpty()) {
            reserveRepository.deleteAll(expiredReservations);
            System.out.println("Günü geçmiş rezervasyonlar silindi.");
        } else {
            System.out.println("Silinecek günü geçmiş rezervasyon bulunamadı.");
        }
    }




}


