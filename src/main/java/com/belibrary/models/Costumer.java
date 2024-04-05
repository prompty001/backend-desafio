package com.belibrary.models;

import com.belibrary.dtos.CostumerDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "costumer")
@Table(name = "costumer")
@Getter
@Setter
@NoArgsConstructor

public class Costumer {

    public Costumer(CostumerDto costumerData) {
        this.name = costumerData.name();
        this.cpf = costumerData.cpf();
        this.birthday = costumerData.birthday();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(unique = true)
    private UUID costumerCode;
    private String name;
    @Column(unique = true)
    private String cpf;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // Verifica se o campo UUID é igual a null antes de os dados persistirem
    // Se sim, atribui um UUID com a função randomUUID()
    @PrePersist
    private void ensureUuid() {
        if (this.costumerCode == null) {
            this.costumerCode = UUID.randomUUID();
        }
    }
}
