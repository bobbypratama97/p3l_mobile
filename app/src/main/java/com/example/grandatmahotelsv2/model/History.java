package com.example.grandatmahotelsv2.model;

public class History {
    Integer IdBooking;
    String ReservationDate;
    String ReservationStatus;
    String CheckInDate;
    String CheckOutDate;

    public History(Integer idBooking, String reservationDate, String reservationStatus, String checkInDate, String checkOutDate) {


        IdBooking = idBooking;
        ReservationDate = reservationDate;
        ReservationStatus = reservationStatus;
        CheckInDate = checkInDate;
        CheckOutDate = checkOutDate;
    }

    public Integer getIdBooking() {
        return IdBooking;
    }

    public void setIdBooking(Integer idBooking) {
        IdBooking = idBooking;
    }

    public String getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(String reservationDate) {
        ReservationDate = reservationDate;
    }

    public String getReservationStatus() {
        return ReservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        ReservationStatus = reservationStatus;
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String checkInDate) {
        CheckInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        CheckOutDate = checkOutDate;
    }
}
