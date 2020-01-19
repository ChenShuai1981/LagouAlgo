package others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Account {
    private Integer balance;

    public void transactionToTarget(Integer money, Account target) {
        Allocator.getInstance().apply(this, target);
        this.setBalance(this.getBalance() - money);
        target.setBalance(target.getBalance() + money);
        Allocator.getInstance().release(this, target);
    }
}
