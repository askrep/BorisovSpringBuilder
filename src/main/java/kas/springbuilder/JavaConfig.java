package kas.springbuilder;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;

    public JavaConfig(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(ifc);
        if (subTypesOf.size() != 1) {
            throw new RuntimeException(ifc + "has 0 or more then one impl");

        }
        return subTypesOf.iterator().next();
    }
}
