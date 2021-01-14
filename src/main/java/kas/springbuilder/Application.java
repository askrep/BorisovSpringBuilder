package kas.springbuilder;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifcToImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifcToImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        //TODO init all singletons which are not lazy
        context.setFactory(objectFactory);

        return context;
    }
}
