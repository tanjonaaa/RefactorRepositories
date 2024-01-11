import CrudOperations.AccountCrudOperations;
import Services.AccountService;

public class Main {
    public static void main(String[] args) {

        AccountCrudOperations crudOperations = new AccountCrudOperations();
        AccountService service = new AccountService(crudOperations);

        System.out.println(service.findAll());
    }
}
