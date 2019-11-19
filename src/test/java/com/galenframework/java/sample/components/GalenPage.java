package com.galenframework.java.sample.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.galenframework.java.sample.components.PropertyLoader.loadProperty;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class GalenPage extends ElementsContainer {
    private static final String WAITING_APPEAR_TIMEOUT_IN_MILLISECONDS = "8000";
    private Map<String, Object> namedElements;

    public GalenPage() {
        super();
    }

    public List<SelenideElement> getPrimaryElements() {
        if (primaryElements == null) {
            primaryElements = readWithWrappedElements();
        }
        return new ArrayList<>(primaryElements);
    }

    protected void isAppeared() {
        String timeout = loadProperty("waitingAppearTimeout", WAITING_APPEAR_TIMEOUT_IN_MILLISECONDS);
        getPrimaryElements().parallelStream().forEach(elem ->
                elem.waitUntil(Condition.appear, Integer.valueOf(timeout)));
        eachForm(GalenPage::isAppeared);
    }

    private void eachForm(Consumer<GalenPage> func) {
        Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Optional.class) == null)
                .forEach(f -> {
                    if (GalenPage.class.isAssignableFrom(f.getType())) {
                        GalenPage galenPage = GalenScenario.getInstance().getPage((Class<? extends GalenPage>) f.getType()).initialize();
                        func.accept(galenPage);
                    }
                });
    }

    private static SelenideElement castToSelenideElement(Object object) {
        if (object instanceof SelenideElement) {
            return (SelenideElement) object;
        }
        return null;
    }

    private List<SelenideElement> primaryElements;

    @Override
    public void setSelf(SelenideElement self) {
        super.setSelf(self);
        initialize();
    }

    public GalenPage initialize() {
        namedElements = readNamedElements();
        primaryElements = readWithWrappedElements();
        return this;
    }

    private Map<String, Object> readNamedElements() {
        checkNamedAnnotations();
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .peek((Field f) -> {
                    if (!SelenideElement.class.isAssignableFrom(f.getType())
                            && !GalenPage.class.isAssignableFrom(f.getType())) {
                        if (List.class.isAssignableFrom(f.getType())) {
                            ParameterizedType listType = (ParameterizedType) f.getGenericType();
                            Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
                            if (SelenideElement.class.isAssignableFrom(listClass) || GalenPage.class.isAssignableFrom(listClass)) {
                                return;
                            }
                        }
                        throw new IllegalStateException(
                                format("Поле с аннотацией @Name должно иметь тип SelenideElement или List<SelenideElement>.\n" +
                                        "Если поле описывает блок, оно должно принадлежать классу, унаследованному от GalenPage.\n" +
                                        "Найдено поле с типом %s", f.getType()));
                    }
                })
                .collect(toMap(f -> f.getDeclaredAnnotation(Name.class).value(), this::extractFieldValueViaReflection));
    }

    private void checkNamedAnnotations() {
        List<String> list = Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .map(f -> f.getDeclaredAnnotation(Name.class).value())
                .collect(toList());
        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalStateException("Найдено несколько аннотаций @Name с одинаковым значением в классе " + this.getClass().getName());
        }
    }

    private List<SelenideElement> readWithWrappedElements() {
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Optional.class) == null)
                .map(this::extractFieldValueViaReflection)
                .flatMap(v -> v instanceof List ? ((List<?>) v).stream() : Stream.of(v))
                .map(GalenPage::castToSelenideElement)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private Object extractFieldValueViaReflection(Field field) {
        return Reflection.extractFieldValue(field, this);
    }


}
