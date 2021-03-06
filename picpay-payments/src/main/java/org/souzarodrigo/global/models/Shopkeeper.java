package org.souzarodrigo.global.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.global.shared.bank.BankData;
import org.souzarodrigo.global.shared.users.User;
import org.souzarodrigo.core.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "shopkeepers")
public class Shopkeeper extends User {

    private BankData bankData;
    private Double bankBalance;
    private Integer numberTransactions;

    public Shopkeeper() {

        setBankBalance(0.0);
        setNumberTransactions(0);
        setRole(Roles.SHOPKEEPER);
    }

    public BankData getBankData() {
        return bankData;
    }

    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public Integer getNumberTransactions() {
        return numberTransactions;
    }

    public void setNumberTransactions(Integer numberTransactions) {
        this.numberTransactions = numberTransactions;
    }
}
