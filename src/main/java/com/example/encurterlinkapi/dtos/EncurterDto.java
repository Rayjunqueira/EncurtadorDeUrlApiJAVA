package com.example.encurterlinkapi.dtos;

import jakarta.validation.constraints.NotNull;

public class EncurterDto {
    @NotNull
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
