package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String organisation;

    @Column
    @NotBlank
    private String website;

    @Column(nullable = false)
    @NotBlank
    private String position;

    @Column(nullable = false)
    private LocalDate from;

    @Column
    private LocalDate to;

    @Column
    @Lob
    @NotBlank
    private String description;

    public Job() {
    }

    public Job(String organisation, String website, String position, LocalDate from, LocalDate to, String description) {
        this.organisation = organisation;
        this.website = website;
        this.position = position;
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

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
