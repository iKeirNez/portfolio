package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "profile_links")
public class ProfileLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String icon;

    @Column(nullable = false)
    @NotBlank
    private String url;

    public ProfileLink() {
    }

    public ProfileLink(String name, String icon, String url) {
        this.name = name;
        this.icon = icon;
        this.url = url;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
