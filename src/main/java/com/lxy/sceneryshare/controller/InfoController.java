package com.lxy.sceneryshare.controller;

import com.lxy.sceneryshare.domain.Info;
import com.lxy.sceneryshare.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService service;

    /**
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/getLatestWeekNew", method = RequestMethod.GET)
    public Object getLatestWeekNew(HttpServletRequest request) {
        List<Info> latestWeekNew = service.getLatestWeekNew();
        return latestWeekNew;
    }
}
