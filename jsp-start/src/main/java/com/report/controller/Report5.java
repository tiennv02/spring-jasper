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
@RequestMapping("/report5")
public class Report5 {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
    public void report(HttpServletResponse response, @RequestParam("cbbCan") String cbbCan, @RequestParam("dtNgay") String dtNgay) {
        String startDate1 = "";
        String endDate1 = "";
        String startDate2 = "";
        String endDate2 = "";
        String startDate3 = "";
        String endDate3 = "";
        Date ngay = Common.convertToDate(dtNgay, "dd/MM/yyyy");
        dtNgay = Common.convertToString(ngay, "yyyy-MM-dd");

        startDate1 = dtNgay + " 07:30:00.000";
        endDate1 = dtNgay + " 15:29:59.999";

        startDate2 = dtNgay + " 15:30:00.000";
        endDate2 = dtNgay + " 23:29:59.999";

        startDate3 = dtNgay + " 23:30:00.000";
        dtNgay = Common.convertToString(Common.addDay(ngay, 1), "yyyy-MM-dd");
        endDate3 = dtNgay + " 07:29:59.999";

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("p_startDate1", startDate1);
        params.put("p_endDate1", endDate1);
        params.put("p_startDate2", startDate2);
        params.put("p_endDate2", endDate2);
        params.put("p_startDate3", startDate3);
        params.put("p_endDate3", endDate3);

        params.put("p_can", "Can So " + cbbCan);

        params.put("p_tenCanTV", "CÂN SỐ " + cbbCan);

        downloadService.download(ExporterService.EXTENSION_TYPE_PDF, ExporterService.TEMPLATE_5, params, response);
    }
}
