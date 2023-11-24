package com.example.encurterlinkapi.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "encurters")
public class EncurterModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID encurter_id;
    @Column(nullable = false, length = 300)
    private String url;
    @Column(nullable = false, length = 300)
    private Integer encurterCode;
    public UUID getEncurter_id() {
        return encurter_id;
    }

    public void setEncurter_id(UUID encurter_id) {
        this.encurter_id = encurter_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getEncurterCode() {
        return encurterCode;
    }

    public void setEncurterCode(Integer encurterCode) {
        this.encurterCode = encurterCode;
    }
}
