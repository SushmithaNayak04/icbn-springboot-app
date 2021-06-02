package com.icbn.icbn.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.icbn.icbn.domain.RequestCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icbn.icbn.domain.User;
import com.icbn.icbn.service.RequestCheckService;
import com.icbn.icbn.service.UserService;

@Controller
@RequestMapping("/request")
public class RequestCheckController {

    @Autowired
    private RequestCheckService requestCheckService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.GET )
    public String createRequestCheck(Model model) {
        RequestCheck requestCheck = new RequestCheck();
        model.addAttribute("appointment", requestCheck);
        model.addAttribute("dateString", "");

        return "request";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createRequestCheckPost(@ModelAttribute("requestCheck") RequestCheck requestCheck, @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format1.parse( date );
        requestCheck.setDate(d1);

        User user = userService.findByUsername(principal.getName());
        requestCheck.setUser(user);

        requestCheckService.createAppointment(requestCheck);

        return "redirect:/userFront";
    }


}
