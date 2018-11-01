package com.report.controller;

import com.report.dto.ReportDTO;
import com.report.service.DownloadService;
import com.report.service.ExporterService;
import com.report.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/report1")
public class Report1 {
    @Autowired
    private DownloadService downloadService;

//    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
//    public StreamingResponseBody getSteamingFile(HttpServletResponse response, @RequestParam("cbbCa") String cbbCan, @RequestParam("dtNgay") String dtNgay) {
//        try {
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=\"report.xlsx\"");
//            InputStream inputStream = new FileInputStream(new File("C:\\report.xlsx"));
//            return outputStream -> {
//                int nRead;
//                byte[] data = new byte[1024];
//                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
//                    outputStream.write(data, 0, nRead);
//                }
//            };
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }

    @RequestMapping(value = "viewReport", method = RequestMethod.POST)
    public void report(HttpServletResponse response, @RequestParam("cbbCa") String cbbCa, @RequestParam("dtNgay") String dtNgay) {
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
            dtNgay = Common.convertToString(Common.addDay(ngay, 1), "dd/MM/yyyy");
            endDate = dtNgay + " 07:30:00.000";
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("p_startDate", startDate);
        params.put("p_endDate", endDate);

        downloadService.download(ExporterService.EXTENSION_TYPE_PDF, ExporterService.TEMPLATE_1, params, response);
    }
}
