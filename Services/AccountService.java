package Services;

import CrudOperations.AccountCrudOperations;
import Models.Account;

import java.util.List;

public class AccountService {

    private final AccountCrudOperations crudOperations;
    public AccountService(AccountCrudOperations crudOperations) {
        this.crudOperations = crudOperations;
    }
    public List<Account> findAll(){
        return this.crudOperations.findAll();
    }
}
