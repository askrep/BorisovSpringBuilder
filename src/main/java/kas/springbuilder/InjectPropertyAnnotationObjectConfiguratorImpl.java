package kas.springbuilder;

import kas.springbuilder.interfaces.InjectProperty;
import kas.springbuilder.interfaces.ObjectConfigurator;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfiguratorImpl() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        for (Field declaredField : implClass.getDeclaredFields()) {
            InjectProperty annotation = declaredField.getAnnotation(InjectProperty.class);
            if (annotation != null) {
                String value = annotation.value().isEmpty() ? propertiesMap.get(declaredField.getName()) : propertiesMap.get(annotation.value());
                declaredField.setAccessible(true);
                declaredField.set(t, value);
            }
        }
    }
}
