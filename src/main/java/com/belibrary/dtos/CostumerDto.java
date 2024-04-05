package com.belibrary.dtos;

import java.sql.Date;

public record CostumerDto(String name, String cpf, Date birthday) {

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthday() {
        return birthday;
    }
}
