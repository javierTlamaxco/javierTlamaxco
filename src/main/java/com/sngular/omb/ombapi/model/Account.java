package com.sngular.omb.ombapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@Data
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private String name;
    private String routingNumber;
    private String accountNumber;
    private String openDate;
    private Double currentBalance;
}
