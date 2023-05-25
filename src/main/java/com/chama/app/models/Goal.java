package com.chama.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int targetAmount = 0;
    private String duration;
    private int amountSaved = 0;

    public Goal(String name, String frequency, int amount) {
        this.name = name;
        this.duration = frequency;
        this.targetAmount = amount;
    }
}
