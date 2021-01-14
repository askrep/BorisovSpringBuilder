package kas.springbuilder;

import kas.springbuilder.interfaces.Config;
import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifcToImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifcToImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.ifcToImplClass = ifcToImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifcToImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(ifc);
            if (subTypesOf.size() != 1) {
                throw new RuntimeException(ifc + "has 0 or more then one impl, please update your config");

            }
            return subTypesOf.iterator().next();
        });
     }
}
