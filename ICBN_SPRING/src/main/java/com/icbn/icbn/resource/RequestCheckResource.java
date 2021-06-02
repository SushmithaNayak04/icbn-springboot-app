package com.icbn.icbn.resource;

import java.util.List;

import com.icbn.icbn.domain.RequestCheck;
import com.icbn.icbn.service.RequestCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/request")
@PreAuthorize("hasRole('ADMIN')")
public class RequestCheckResource {

    @Autowired
    private RequestCheckService requestCheckService;

    @RequestMapping("/all")
    public List<RequestCheck> findAppointmentList() {
        List<RequestCheck> RequestList = requestCheckService.findAll();

        return RequestList;
    }

    @RequestMapping("/{id}/confirm")
    public void confirmRequest(@PathVariable("id") Long id) {
        requestCheckService.confirmRequestCheck(id);
    }
}
