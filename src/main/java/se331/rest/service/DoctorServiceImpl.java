package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.DoctorDao;
import se331.rest.entity.Doctor;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorDao doctorDao;
    @Override
    public List<Doctor> getAllDoctor() {
        return doctorDao.getDoctor(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Doctor> getDoctor(Integer page, Integer pageSize) {
        return doctorDao.getDoctor(PageRequest.of(page,pageSize));
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDao.getDoctor(id);
    }
}
