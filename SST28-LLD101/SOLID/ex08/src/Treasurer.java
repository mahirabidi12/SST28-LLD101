/**
 * Role interface: finance operations only.
 */
public interface Treasurer {

    void addIncome(double amt, String note);

    void addExpense(double amt, String note);
}
