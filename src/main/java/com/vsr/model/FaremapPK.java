package com.vsr.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lakshmanch on 5/10/15.
 */
public class FaremapPK implements Serializable {
    private int fromStationId;
    private int toStationId;

    @Column(name = "from_station_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(int fromStationId) {
        this.fromStationId = fromStationId;
    }

    @Column(name = "to_station_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getToStationId() {
        return toStationId;
    }

    public void setToStationId(int toStationId) {
        this.toStationId = toStationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaremapPK faremapPK = (FaremapPK) o;

        if (fromStationId != faremapPK.fromStationId) return false;
        if (toStationId != faremapPK.toStationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromStationId;
        result = 31 * result + toStationId;
        return result;
    }
}
