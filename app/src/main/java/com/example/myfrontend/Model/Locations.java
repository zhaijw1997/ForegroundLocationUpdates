package com.example.myfrontend.Model;

import com.google.android.gms.maps.model.LatLng;

public class Locations {
    private String locationName;
    private LatLng locationLatLng;
    private Double locationAwareRadius;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LatLng getLocationLatLng() {
        return locationLatLng;
    }

    public void setLocationLatLng(LatLng locationLatLng) {
        this.locationLatLng = locationLatLng;
    }

    public Double getLocationAwareRadius() {
        return locationAwareRadius;
    }

    public void setLocationAwareRadius(Double locationAwareRadius) {
        this.locationAwareRadius = locationAwareRadius;
    }
}
