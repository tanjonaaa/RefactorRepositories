package Models;

import Annotations.Column;
import Annotations.Id;
import Annotations.Model;

@Model(table = "account")
public class Account {
    @Column(name = "id_account")
    @Id
    private String id;
    @Column(name = "type_account")
    private String type;
    @Column(name = "balance")
    private Double balance;
    public Account(String id, String type, Double balance) {
        this.id = id;
        this.type = type;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
