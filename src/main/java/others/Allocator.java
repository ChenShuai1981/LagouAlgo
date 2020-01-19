package others;

import java.util.ArrayList;
import java.util.List;

// 单例分配类
public class Allocator {
    static class AllocatorSingle{
        public static Allocator install = new Allocator();
    }

    private Allocator(){}

    private List<Account> locks = new ArrayList<>();

    public synchronized void apply(Account src, Account target){
        while (locks.contains(src)||locks.contains(target)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        locks.add(src);
        locks.add(target);
    }
    public synchronized void release(Account src, Account target){
        locks.remove(src);
        locks.remove(target);
        this.notifyAll();
    }
    public static Allocator getInstance(){
        return AllocatorSingle.install;
    }
}
