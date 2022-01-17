package injection;

import annotations.AutoInjectable;
import annotations.Configuration;
import exceptions.InjectionException;
import repository.Repository;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration(packages = {"sortings.impl", "validation.validators"})
public class Injector {

    /** Object pool */
    private List<Object> objectPool;

    /** Default constructor for an object of the Injector class
     * Here, classes are searched in the specified packages and a pool of objects of these classes is formed
     */
    public Injector() {

        objectPool = new ArrayList<>();
        if (this.getClass().isAnnotationPresent(Configuration.class)) {
            Configuration configuration = this.getClass().getAnnotation(Configuration.class);

            for (String p: configuration.packages()) {
                p = p.replace(".", "/");

                try (DataInputStream dataInputStream = new DataInputStream((InputStream) Objects.requireNonNull(
                        this.getClass().getClassLoader().getResource(p)).getContent())) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.endsWith(".class")) {
                            String className = p.replace("/", ".") + "."
                                    + line.substring(0, line.length() - 6);
                            objectPool.add(Class.forName(className).getConstructor().newInstance());
                        }
                    }
                } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException
                        | ClassNotFoundException | IllegalAccessException e) {
                    System.out.println("Class not found");
                }
            }
        }
    }

    /**
     * Main dependency injection method
     * @param o object
     * @param <T> object class
     * @return instance of initial object with injected dependencies
     * @throws InjectionException
     * @throws IllegalAccessException
     */
    public <T> T inject(final T o) throws IllegalAccessException, InjectionException {
        List<Object> classForInjection = new ArrayList<>();

        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                field.setAccessible(true);
                if (field.getType().getName().contains("java.util.List")) {
                    ParameterizedType fieldListType = (ParameterizedType) field.getGenericType();
                    Class<?> fieldGenericType = (Class<?>) fieldListType.getActualTypeArguments()[0];

                    for (Object object : objectPool) {
                        if (object != null && fieldGenericType.isAssignableFrom(object.getClass())) {
                            classForInjection.add(object);
                        }

                        field.set(o, classForInjection);
                    }
                } else {
                    for (Object object : objectPool) {
                        if (object != null && field.getType().isAssignableFrom(object.getClass())) {
                            classForInjection.add(object);
                        }

                        if (classForInjection.size() == 1) {
                            field.set(o, classForInjection.get(0));
                        } else {
                            throw new InjectionException("The number of classes for injection is not equal to 1");
                        }
                    }
                }
            }
        }

        return o;
    }

}
