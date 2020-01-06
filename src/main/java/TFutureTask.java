import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TFutureTask extends FutureTask {
    public TFutureTask(Callable callable) {
        super(callable);
    }
}
