package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Doctor;
import se331.rest.entity.DoctorComment;
import se331.rest.entity.Patient;
import se331.rest.repository.DoctorCommentRepository;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorCommentRepository doctorCommentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        Doctor d1,d2,d3,admin,user;
        d1 = doctorRepository.save(Doctor.builder().doctor_name("Dr.Kittisak").build());
        d2 = doctorRepository.save(Doctor.builder().doctor_name("Dr.Burussakorn").build());
        d3 = doctorRepository.save(Doctor.builder().doctor_name("Dr.Panadon").build());
        admin = doctorRepository.save(Doctor.builder().doctor_name("Admin").build());
        user = doctorRepository.save(Doctor.builder().doctor_name("Anan").build());
        Patient tempPatient = null;
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Anan")
                        .last_name("Kongdecha")
                        .age(22)
                        .hometown("Bangkok")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Pfizer")
                        .vaccine_date1("02/05/2021")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("05/11/2021")
                        .doctor(d1)
                .build());
//        tempPatient.getImageUrls().add("gs://imageupload-7351c.appspot.com/2022-10-31 005630225-reviewer3.jpg");
        DoctorComment dc = doctorCommentRepository.save(DoctorComment.builder()
                .title("safe")
                .comment("the patient is good")
                .patient(tempPatient)
                .build());
        tempPatient.getDoctorComments().add(dc);
        d1.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Kitti")
                        .last_name("Mamaung")
                        .age(24)
                        .hometown("Tak")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("AstraZeneca")
                        .vaccine_date1("11/06/2021")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("15/12/2021")
                        .doctor(d1)
                .build());
        d1.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Patikool")
                        .last_name("Konpetch")
                        .age(35)
                        .hometown("Phetchabun")
                        .vaccine_stat("First Dose")
                        .vaccine_brand1("AstraZeneca")
                        .vaccine_date1("03/03/2022")
                        .doctor(d3)
                .build());
        d3.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Kingkaew")
                        .last_name("Klaewklad")
                        .age(26)
                        .hometown("Nan")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Sinovac")
                        .vaccine_date1("22/06/2021")
                        .vaccine_brand2("Sinovac")
                        .vaccine_date2("28/12/2021")
                        .doctor(d2)
                .build());
        d2.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Tongrak")
                        .last_name("Jakkajee")
                        .age(46)
                        .hometown("Prae")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Sinovac")
                        .vaccine_date1("03/04/2021")
                        .vaccine_brand2("AstraZeneca")
                        .vaccine_date2("07/10/2021")
                        .doctor(d1)
                .build());
        d1.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Pimchanok")
                        .last_name("Kongkhakhet")
                        .age(17)
                        .hometown("ChiangMai")
                        .vaccine_stat("First Dose")
                        .vaccine_brand1("Pfizer")
                        .vaccine_date1("12/06/2021")
                        .doctor(d2)
                .build());
        d2.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Jason")
                        .last_name("Brown")
                        .age(30)
                        .hometown("Bangkok")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Pfizer")
                        .vaccine_date1("30/06/2021")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("02/01/2022")
                        .doctor(d2)
                .build());
        d2.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Mutisorn")
                        .last_name("Kornkamol")
                        .age(30)
                        .hometown("ChaingMai")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("AstraZeneca")
                        .vaccine_date1("05/05/2021")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("07/11/2021")
                        .doctor(d3)
                .build());
        d3.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Joe")
                        .last_name("Mama")
                        .age(60)
                        .hometown("Lumphun")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Sinovac")
                        .vaccine_date1("11/03/2021")
                        .vaccine_brand2("Sinovac")
                        .vaccine_date2("15/09/2021")
                        .doctor(d3)
                .build());
        d3.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Adisorn")
                        .last_name("Gonzalez")
                        .age(25)
                        .hometown("SaraBuri")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Pfizer")
                        .vaccine_date1("02/02/2022")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("03/08/2022")
                        .doctor(d3)
                .build());
        d3.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Burapa")
                        .last_name("AongAad")
                        .age(54)
                        .hometown("Phetchabun")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Sinovac")
                        .vaccine_date1("16/05/2021")
                        .vaccine_brand2("Sinovac")
                        .vaccine_date2("18/11/2021")
                        .doctor(d2)
                .build());
        d2.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Dumrong")
                        .last_name("Kongkoi")
                        .age(48)
                        .hometown("Nakhon Ratchasima")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("AstraZeneca")
                        .vaccine_date1("11/01/2022")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("22/07/2022")
                        .doctor(d1)
                .build());
        d1.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Pattinson")
                        .last_name("Roy")
                        .age(26)
                        .hometown("Bangkok")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Pfizer")
                        .vaccine_date1("11/06/2021")
                        .vaccine_brand2("Pfizer")
                        .vaccine_date2("15/12/2021")
                        .doctor(d1)
                .build());
        d1.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Lung")
                        .last_name("Dum")
                        .age(64)
                        .hometown("Lumphun")
                        .vaccine_stat("Second Dose")
                        .vaccine_brand1("Sinovac")
                        .vaccine_date1("26/04/2021")
                        .vaccine_brand2("AstraZeneca")
                        .vaccine_date2("30/10/2021")
                        .doctor(d2)
                .build());
        d2.getPatients().add(tempPatient);
        tempPatient = patientRepository.save(Patient.builder()
                        .first_name("Timothy")
                        .last_name("Lawrence")
                        .age(35)
                        .hometown("Bangkok")
                        .vaccine_stat("First Dose")
                        .vaccine_brand1("Johnson&Johnson")
                        .vaccine_date1("20/06/2021")
                        .doctor(d3)
                .build());
        d3.getPatients().add(tempPatient);
        addUser();
        admin.setUser(user1);
        user1.setDoctor(admin);
        d1.setUser(user2);
        user2.setDoctor(d1);
        d2.setUser(user3);
        user3.setDoctor(d2);
        d3.setUser(user4);
        user4.setDoctor(d3);
        user5.setDoctor(user);
        user.setUser(user5);
    }
    User user1,user2,user3,user4,user5;
    private  void addUser(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("Dr.Kittisak")
                .password(encoder.encode("Kittisak"))
                .password(encoder.encode("kittisak"))
                .firstname("Kittisak")
                .lastname("Kaewbunmaung")
                .email("Kittisak.K@doctor.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("Dr.Burussakorn")
                .password(encoder.encode("Burussakorn"))
                .password(encoder.encode("burussakorn"))
                .firstname("Burussakorn")
                .lastname("Ruangon")
                .email("Burussakorn.R@doctor.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("Dr.Panadon")
                .password(encoder.encode("Panadon"))
                .password(encoder.encode("panadon"))
                .firstname("Panadon")
                .lastname("Saikaew")
                .email("Panadon.S@doctor.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user5 = User.builder()
                .username("Anan")
                .password(encoder.encode("Anan"))
                .password(encoder.encode("anan"))
                .firstname("Anan")
                .lastname("Kongdecha")
                .email("Anan.K@patient.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authDoctor);
        user3.getAuthorities().add(authDoctor);
        user4.getAuthorities().add(authDoctor);
        user5.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

    }
}
