package com.sngular.omb.ombapi.model;

import com.sngular.omb.ombapi.util.AccountType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private String name;
    private AccountType accountType;
    private String dateBirth;
    private Double initialBalance;
    private String routingNumber;
    private String accountNumber;
    private String openDate;
    private Double currentBalance;

    public Account(String name, String routingNumber, String accountNumber, String openDate, double currentBalance) {
    }

    public Account() {

    }
}
