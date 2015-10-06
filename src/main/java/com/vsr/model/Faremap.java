package com.vsr.model;

import javax.persistence.*;

/**
 * Created by lakshmanch on 5/10/15.
 */
@Entity
@IdClass(FaremapPK.class)
@Table(name="faremap")
public class Faremap {
    private int fromStationId;
    private int toStationId;
    private float fare;

    @Id
    @Column(name = "from_station_id", nullable = false, insertable = true, updatable = true)
    public int getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(int fromStationId) {
        this.fromStationId = fromStationId;
    }

    @Id
    @Column(name = "to_station_id", nullable = false, insertable = true, updatable = true)
    public int getToStationId() {
        return toStationId;
    }

    public void setToStationId(int toStationId) {
        this.toStationId = toStationId;
    }

    @Basic
    @Column(name = "fare", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faremap faremap = (Faremap) o;

        if (fromStationId != faremap.fromStationId) return false;
        if (toStationId != faremap.toStationId) return false;
        if (Float.compare(faremap.fare, fare) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromStationId;
        result = 31 * result + toStationId;
        result = 31 * result + (fare != +0.0f ? Float.floatToIntBits(fare) : 0);
        return result;
    }
}
