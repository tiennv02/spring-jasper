package com.report.service;

import com.report.dto.ReportDTO;
import com.report.util.ConnectionUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

@Service
public class DownloadService {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private ExporterService exporter;
	
	public void download(String type, String template, HashMap<String, Object> params, HttpServletResponse response) {
		 
		try {
			// 2.  Retrieve template
			InputStream reportStream = this.getClass().getResourceAsStream(template);
			 
			// 3. Convert template to JasperDesign
			JasperDesign jd = JRXmlLoader.load(reportStream);
//			jd.setProperty("net.sf.jasperreports.default.pdf.font.name", "SansSerif");
//			jd.setProperty("net.sf.jasperreports.default.pdf.encoding", "UTF-8");
//			jd.setProperty("net.sf.jasperreports.default.pdf.embedded", "false");
			// 4. Compile design to JasperReport
			JasperReport jr = JasperCompileManager.compileReport(jd);
			Connection conn = ConnectionUtils.getConnection();
			// 5. Create the JasperPrint object
			// Make sure to pass the JasperReport, report parameters, and data source
			JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
			 
			// 6. Create an output byte stream where data will be written
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 
			// 7. Export report
			exporter.export(type, jp, response, baos);
			 
			// 8. Write to reponse stream
			write(response, baos);
		
		} catch (JRException jre) {
			logger.error("Unable to process download");
			throw new RuntimeException(jre);
		}
	}
	
	/**
	* Writes the report to the output stream
	*/
	private void write(HttpServletResponse response,
			ByteArrayOutputStream baos) {
		 
		try {
			logger.debug(baos.size());
			
			// Retrieve output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to output stream
			baos.writeTo(outputStream);
			// Flush the stream
			outputStream.flush();
			
		} catch (Exception e) {
			logger.error("Unable to write report to the output stream");
			throw new RuntimeException(e);
		}
	}
}
