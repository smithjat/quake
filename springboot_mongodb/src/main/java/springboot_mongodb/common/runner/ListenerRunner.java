package springboot_mongodb.common.runner;

import springboot_mongodb.common.*;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class ListenerRunner extends SpringJUnit4ClassRunner {

    public ListenerRunner(Class<?> cls) throws InitializationError {
        super(cls);
    }

    @Override
    public void run(RunNotifier notifier){
        notifier.removeListener(GlobalVar.listenerUtils);
        notifier.addListener(GlobalVar.listenerUtils);
        notifier.fireTestRunStarted(getDescription());
        super.run(notifier);
    }
}