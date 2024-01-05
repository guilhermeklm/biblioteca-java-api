package com.karam.librarymanagement.application.dto;

public class CreateAuthorInputDTO extends InputDTO {

    private String name;
    private String country;

    public CreateAuthorInputDTO(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
