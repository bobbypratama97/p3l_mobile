package com.example.grandatmahotelsv2.model;

import java.util.Date;

public class Season {
    Integer IdSeason;
    Integer IdPrice;
    String SeasonName;
    String StartDate;
    String EndDate;
    String Detail;

    public Season(int idSeason, int idPrice, String SeasonName, String startDate, String endDate, String detail) {
        this.IdSeason = idSeason;
        this.IdPrice = idPrice;
        this.SeasonName = SeasonName;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Detail = detail;
    }




    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public Integer getIdSeason() {
        return IdSeason;
    }



    public void setIdSeason(Integer idSeason) {
        IdSeason = idSeason;
    }

    public Integer getIdPrice() {
        return IdPrice;
    }

    public void setIdPrice(Integer idPrice) {
        IdPrice = idPrice;
    }

    public String getSeasonName() {
        return SeasonName;
    }

    public void setSeasonName(String seasonName) {
        SeasonName = seasonName;
    }



    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
