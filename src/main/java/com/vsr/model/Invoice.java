package com.vsr.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lakshmanch on 5/10/15.
 */
@Entity
@Table(name="invoice")
public class Invoice {
    private long id;
    private String waybillNumber;
    private int deptId;
    private Timestamp date;
    private int fromStationId;
    private int toStationId;
    private String dcNumber;
    private String fromAddress;
    private String toAddress;
    private float goodsValue;
    private int packageCount;
    private String description;
    private float weight;
    private float freight;
    private float valueSurcharge;
    private float doordelCharges;
    private float articleCharges;
    private float statCharges;
    private float handlingCharges;
    private float otherCharges;
    private float total;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "waybill_number", nullable = false, insertable = true, updatable = true, length = 16)
    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    @Basic
    @Column(name = "dept_id", nullable = false, insertable = true, updatable = true)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "from_station_id", nullable = false, insertable = true, updatable = true)
    public int getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(int fromStationId) {
        this.fromStationId = fromStationId;
    }

    @Basic
    @Column(name = "to_station_id", nullable = false, insertable = true, updatable = true)
    public int getToStationId() {
        return toStationId;
    }

    public void setToStationId(int toStationId) {
        this.toStationId = toStationId;
    }

    @Basic
    @Column(name = "dc_number", nullable = false, insertable = true, updatable = true, length = 32)
    public String getDcNumber() {
        return dcNumber;
    }

    public void setDcNumber(String dcNumber) {
        this.dcNumber = dcNumber;
    }

    @Basic
    @Column(name = "from_address", nullable = true, insertable = true, updatable = true, length = 256)
    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @Basic
    @Column(name = "to_address", nullable = true, insertable = true, updatable = true, length = 256)
    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    @Basic
    @Column(name = "goods_value", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(float goodsValue) {
        this.goodsValue = goodsValue;
    }

    @Basic
    @Column(name = "package_count", nullable = false, insertable = true, updatable = true)
    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 256)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "weight", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "freight", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "value_surcharge", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getValueSurcharge() {
        return valueSurcharge;
    }

    public void setValueSurcharge(float valueSurcharge) {
        this.valueSurcharge = valueSurcharge;
    }

    @Basic
    @Column(name = "doordel_charges", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getDoordelCharges() {
        return doordelCharges;
    }

    public void setDoordelCharges(float doordelCharges) {
        this.doordelCharges = doordelCharges;
    }

    @Basic
    @Column(name = "article_charges", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getArticleCharges() {
        return articleCharges;
    }

    public void setArticleCharges(float articleCharges) {
        this.articleCharges = articleCharges;
    }

    @Basic
    @Column(name = "stat_charges", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getStatCharges() {
        return statCharges;
    }

    public void setStatCharges(float statCharges) {
        this.statCharges = statCharges;
    }

    @Basic
    @Column(name = "handling_charges", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getHandlingCharges() {
        return handlingCharges;
    }

    public void setHandlingCharges(float handlingCharges) {
        this.handlingCharges = handlingCharges;
    }

    @Basic
    @Column(name = "other_charges", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(float otherCharges) {
        this.otherCharges = otherCharges;
    }

    @Basic
    @Column(name = "total", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (deptId != invoice.deptId) return false;
        if (fromStationId != invoice.fromStationId) return false;
        if (toStationId != invoice.toStationId) return false;
        if (Float.compare(invoice.goodsValue, goodsValue) != 0) return false;
        if (packageCount != invoice.packageCount) return false;
        if (Float.compare(invoice.weight, weight) != 0) return false;
        if (Float.compare(invoice.freight, freight) != 0) return false;
        if (Float.compare(invoice.valueSurcharge, valueSurcharge) != 0) return false;
        if (Float.compare(invoice.doordelCharges, doordelCharges) != 0) return false;
        if (Float.compare(invoice.articleCharges, articleCharges) != 0) return false;
        if (Float.compare(invoice.statCharges, statCharges) != 0) return false;
        if (Float.compare(invoice.handlingCharges, handlingCharges) != 0) return false;
        if (Float.compare(invoice.otherCharges, otherCharges) != 0) return false;
        if (Float.compare(invoice.total, total) != 0) return false;
        if (waybillNumber != null ? !waybillNumber.equals(invoice.waybillNumber) : invoice.waybillNumber != null)
            return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        if (dcNumber != null ? !dcNumber.equals(invoice.dcNumber) : invoice.dcNumber != null) return false;
        if (fromAddress != null ? !fromAddress.equals(invoice.fromAddress) : invoice.fromAddress != null) return false;
        if (toAddress != null ? !toAddress.equals(invoice.toAddress) : invoice.toAddress != null) return false;
        if (description != null ? !description.equals(invoice.description) : invoice.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (waybillNumber != null ? waybillNumber.hashCode() : 0);
        result = 31 * result + deptId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + fromStationId;
        result = 31 * result + toStationId;
        result = 31 * result + (dcNumber != null ? dcNumber.hashCode() : 0);
        result = 31 * result + (fromAddress != null ? fromAddress.hashCode() : 0);
        result = 31 * result + (toAddress != null ? toAddress.hashCode() : 0);
        result = 31 * result + (goodsValue != +0.0f ? Float.floatToIntBits(goodsValue) : 0);
        result = 31 * result + packageCount;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (freight != +0.0f ? Float.floatToIntBits(freight) : 0);
        result = 31 * result + (valueSurcharge != +0.0f ? Float.floatToIntBits(valueSurcharge) : 0);
        result = 31 * result + (doordelCharges != +0.0f ? Float.floatToIntBits(doordelCharges) : 0);
        result = 31 * result + (articleCharges != +0.0f ? Float.floatToIntBits(articleCharges) : 0);
        result = 31 * result + (statCharges != +0.0f ? Float.floatToIntBits(statCharges) : 0);
        result = 31 * result + (handlingCharges != +0.0f ? Float.floatToIntBits(handlingCharges) : 0);
        result = 31 * result + (otherCharges != +0.0f ? Float.floatToIntBits(otherCharges) : 0);
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        return result;
    }
}
