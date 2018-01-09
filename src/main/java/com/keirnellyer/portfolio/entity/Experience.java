package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(nullable = false)
    @NotBlank
    private String organisation;

    @Column(nullable = false)
    @NotBlank
    private String position;

    @Column(nullable = false)
    private Instant from;

    @Column
    private Instant to;

    @Column
    @NotBlank
    private String description;

    public Experience() {
    }

    public Experience(String organisation, String position, Instant from, Instant to, String description) {
        this.organisation = organisation;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
