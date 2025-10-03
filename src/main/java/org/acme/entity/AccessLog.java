package org.acme.entity;

import java.util.Date;
import java.util.UUID;

import javax.annotation.processing.Generated;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class AccessLog extends PanacheEntity {

    public String requestValue;

    public String responseValue;

    public Date timestamp;
}