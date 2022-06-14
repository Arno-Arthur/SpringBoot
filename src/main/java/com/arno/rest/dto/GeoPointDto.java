package com.arno.rest.dto;

import com.arno.domain.GeoPoint;

public class GeoPointDto {

    public GeoPointDto(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static GeoPointDto toDto(GeoPoint geoPoint) {
        return new GeoPointDto(geoPoint.getLatitude(), geoPoint.getLongitude());
    }
}
