package com.vsr.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by lakshmanch on 5/10/15.
 */
@Entity
@Table(name="faremap")
//TODO , uniqueConstraints = {@UniqueConstraint(name = "uk_from_to", columnNames = {"from_stn_id","to_stn_id"})})
@Data
@EqualsAndHashCode(of = {"id"})
public class Faremap {

    @Id
    @GeneratedValue
    @Column(name = "fare_id", nullable = false, insertable = false, updatable = false)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "from_stn_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_fares_fromstn"))
    @JoinColumn(name = "from_stn_id", insertable = true, updatable = true, nullable = false)
    private Station fromStation;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "to_stn_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_fares_tostn"))
    @JoinColumn(name = "to_stn_id", insertable = true, updatable = true, nullable = false)
    private Station toStation;

    @Basic
    @Column(name = "fare", nullable = false, insertable = true, updatable = true, precision = 0)
    private float fare;
}
