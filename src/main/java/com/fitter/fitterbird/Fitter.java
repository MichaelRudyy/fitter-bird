package com.fitter.fitterbird;

import java.util.Date;
import java.util.Objects;

public class Fitter {
    private final Long id;
    private final String message;
    private final Date date;
    private Double latitude;
    private Double longitude;

    public Fitter (String message, Date date, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Fitter(String message, Date date) {
        this(message,date,null,null);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fitter fitter = (Fitter) o;
        return Objects.equals(id, fitter.id) &&
                Objects.equals(message, fitter.message) &&
                Objects.equals(date, fitter.date) &&
                Objects.equals(latitude, fitter.latitude) &&
                Objects.equals(longitude, fitter.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, message, date, latitude, longitude);
    }
}
