package com.example.demo;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisRestController {

    @Autowired
    HttpSession session;

    @Autowired
    ItemService itemService;

    @RequestMapping(path = "/redis", method = RequestMethod.GET)
    public Item redis() {
        System.out.println("1:" + Calendar.getInstance().getTime());
        Item item = itemService.getItem("test");
        System.out.println("2:" + Calendar.getInstance().getTime());

        int cnt = 1;
        if (session.getAttribute("cnt") == null) {
            session.setAttribute("cnt", cnt);
        } else {
            cnt = (Integer)session.getAttribute("cnt");
            cnt++;
            session.setAttribute("cnt", cnt);
        }
        System.out.println("cnt:" + cnt);

        return item;
    }

}
