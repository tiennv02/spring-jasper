package com.report.dto;

public class ReportDTO {

    private String startDateStr;
    private String endDateStr;
    private String ca;
    private String can;
    private Long giaTriLN;
    private Long giaTriNN;
    private Long giaTriLech;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public Long getGiaTriLN() {
        return giaTriLN;
    }

    public void setGiaTriLN(Long giaTriLN) {
        this.giaTriLN = giaTriLN;
    }

    public Long getGiaTriNN() {
        return giaTriNN;
    }

    public void setGiaTriNN(Long giaTriNN) {
        this.giaTriNN = giaTriNN;
    }

    public Long getGiaTriLech() {
        return giaTriLech;
    }

    public void setGiaTriLech(Long giaTriLech) {
        this.giaTriLech = giaTriLech;
    }
}
