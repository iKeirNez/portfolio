package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String establishment;

    @Column
    @NotBlank
    private String website;

    @Column(nullable = false)
    @NotBlank
    private String subject;

    @Column(nullable = false)
    private LocalDate from;

    @Column
    private LocalDate to;

    @Column
    @Lob
    @NotBlank
    private String description;

    public Education() {
    }

    public Education(String establishment, String website, String subject, LocalDate from, LocalDate to, String description) {
        this.establishment = establishment;
        this.website = website;
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
