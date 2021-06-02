package com.icbn.icbn.service;

import java.util.List;

import com.icbn.icbn.domain.RequestCheck;

public interface RequestCheckService {
    
	RequestCheck createAppointment(RequestCheck appointment);

    List<RequestCheck> findAll();

    RequestCheck findRequestCheck(Long id);

    void confirmRequestCheck(Long id);
}
