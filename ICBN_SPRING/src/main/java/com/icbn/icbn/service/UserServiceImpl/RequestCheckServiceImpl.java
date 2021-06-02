package com.icbn.icbn.service.UserServiceImpl;

import java.util.List;

import com.icbn.icbn.dao.RequestCheckDao;
import com.icbn.icbn.domain.RequestCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icbn.icbn.service.RequestCheckService;

@Service
public class RequestCheckServiceImpl implements RequestCheckService {

    @Autowired
    private RequestCheckDao requestCheckDao;

    public RequestCheck createAppointment(RequestCheck appointment) {
       return requestCheckDao.save(appointment);
    }

    public List<RequestCheck> findAll() {
        return requestCheckDao.findAll();
    }

    public RequestCheck findRequestCheck(Long id) {
        return requestCheckDao.findOne(id);
    }

    public void confirmRequestCheck(Long id) {
        RequestCheck appointment = findRequestCheck(id);
        appointment.setConfirmed(true);
        requestCheckDao.save(appointment);
    }
}
