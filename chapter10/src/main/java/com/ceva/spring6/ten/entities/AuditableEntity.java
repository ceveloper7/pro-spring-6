package com.ceva.spring6.ten.entities;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Optional;

@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<U> implements Serializable {
    @Serial
    private static final long serialVersionUID = 8L;

    @CreatedDate
    @Column(name = "created_date")
    protected LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    protected LocalDateTime lastModifiedDate;

    public Optional<String> getCreatedBy() {
        return Optional.of(createdBy);
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.of(createdDate);
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<String> getLastModifiedBy() {
        return Optional.of(lastModifiedBy);
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.of(lastModifiedDate);
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
