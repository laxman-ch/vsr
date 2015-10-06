package com.vsr.model;

import javax.persistence.*;

/**
 * Created by lakshmanch on 5/10/15.
 */
@Entity
@Table(name="station")
public class Station {
    private int id;
    private String shortCode;
    private String stationName;
    private String district;
    private String state;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "short_code", nullable = false, insertable = true, updatable = true, length = 6)
    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Basic
    @Column(name = "station_name", nullable = false, insertable = true, updatable = true, length = 32)
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Basic
    @Column(name = "district", nullable = false, insertable = true, updatable = true, length = 32)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "state", nullable = false, insertable = true, updatable = true, length = 32)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (id != station.id) return false;
        if (shortCode != null ? !shortCode.equals(station.shortCode) : station.shortCode != null) return false;
        if (stationName != null ? !stationName.equals(station.stationName) : station.stationName != null) return false;
        if (district != null ? !district.equals(station.district) : station.district != null) return false;
        if (state != null ? !state.equals(station.state) : station.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortCode != null ? shortCode.hashCode() : 0);
        result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
