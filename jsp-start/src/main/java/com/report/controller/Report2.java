package com.report.controller;

import com.report.service.DownloadService;
import com.report.service.ExporterService;
import com.report.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/report2")
public class Report2 {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
    public void report(HttpServletResponse response, @RequestParam("dtNgay") String dtNgay, @RequestParam("cbbCa") String cbbCa) {
        String startDate = "";
        String endDate = "";
        String path = "\\";//debug
//        String path = "/";//run file jar
        System.out.println("path = \\ khi debug");
        System.out.println("path = / khi run file jar");
        Date ngay = Common.convertToDate(dtNgay, "dd/MM/yyyy");
        dtNgay = Common.convertToString(ngay, "yyyy-MM-dd");
        if (cbbCa.equals("1")) {
            startDate = dtNgay + " 07:30:00.000";
            endDate = dtNgay + " 15:30:00.000";
        } else if (cbbCa.equals("2")) {
            startDate = dtNgay + " 15:30:00.000";
            endDate = dtNgay + " 23:30:00.000";
        } else {
            startDate = dtNgay + " 23:30:00.000";
            dtNgay = Common.convertToString(Common.addDay(ngay, 1), "yyyy-MM-dd");
            endDate = dtNgay + " 07:30:00.000";
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("p_ca", cbbCa);
        params.put("p_Date", dtNgay);
        params.put("p_startDate", startDate);
        params.put("p_endDate", endDate);

        downloadService.download(ExporterService.EXTENSION_TYPE_PDF, ExporterService.TEMPLATE_2, params, response);
    }
}
