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
@RequestMapping("/report6")
public class Report6 {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
    public void report(HttpServletResponse response, @RequestParam("cbbCan") String cbbCan, @RequestParam("dtNgay") String dtNgay) {
        String startDate = "";
        String endDate = "";
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (dtNgay != null && !dtNgay.trim().equals("")) {
            Date ngay = Common.convertToDate(dtNgay, "dd/MM/yyyy");
            dtNgay = Common.convertToString(ngay, "yyyy-MM-dd");

            startDate = dtNgay + " 07:30:00.000";
            dtNgay = Common.convertToString(Common.addDay(ngay, 1), "yyyy-MM-dd");
            endDate = dtNgay + " 07:30:00.000";

            params.put("p_startDate", startDate);
            params.put("p_endDate", endDate);
        }else{
            params.put("p_date", "ALL");
            params.put("p_startDate", Common.convertToString(new Date(), "yyyy-MM-dd")+" 00:00:00.000");
            params.put("p_endDate", Common.convertToString(new Date(), "yyyy-MM-dd")+" 00:00:00.000");
        }

        params.put("p_can", "Can So " + cbbCan);

        params.put("p_tenCanTV", "CÂN SỐ " + cbbCan);

        downloadService.download(ExporterService.EXTENSION_TYPE_PDF, ExporterService.TEMPLATE_6, params, response);
    }
}
