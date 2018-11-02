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
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/report3")
public class Report3 {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
    public void report(HttpServletResponse response, @RequestParam("cbbCan") String cbbCan, @RequestParam("dtNgay") String dtNgay, @RequestParam("cbbCa") String cbbCa) {
        String startDate = "";
        String endDate = "";
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
        params.put("p_startDate", startDate);
        params.put("p_endDate", endDate);
        params.put("p_can", "Can So " + cbbCan);

        params.put("p_tenCanTV", "CÂN SỐ "+ cbbCan);
        params.put("p_title", "BÁO CÁO SỐ LIỆU CÂN SỐ " + cbbCan + " CA " + cbbCa + " NGÀY " + Common.convertToString(ngay, "dd.MM.yyyy"));

        downloadService.download(ExporterService.EXTENSION_TYPE_PDF, ExporterService.TEMPLATE_3, params, response);
    }
}
