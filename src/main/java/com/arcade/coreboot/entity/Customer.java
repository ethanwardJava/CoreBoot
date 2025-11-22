package com.arcade.coreboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq" , allocationSize = 1 , sequenceName = "customer_sequence")
    private Long id;
    private String name;
    private String email;
}
