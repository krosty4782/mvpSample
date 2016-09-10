package com.example.challenge.dagger;

import java.util.HashMap;
import java.util.Map;

public final class ComponentsManager {

    private static final String KEY_APP = "app";
    private static final String KEY_COMMON = "commmon";
    private static final String KEY_ACTIVITY = "activity";
    private final Map<String, ? super BaseComponent> baseComponents;

    // Singleton pattern
    private ComponentsManager() {
        baseComponents = new HashMap<>();
    }

    public static ComponentsManager get() {
        return LazyHolder.INSTANCE;
    }

    public <C extends BaseComponent> void removeBaseComponent(String componentKey) {
        baseComponents.remove(componentKey);
    }

    public <C extends BaseComponent> C getBaseComponent(String componentKey) {
        return (C) baseComponents.get(componentKey);
    }

    public <C extends BaseComponent> void putBaseComponent(String componentKey, C component) {
        baseComponents.put(componentKey, component);
    }

    public void removeBaseComponents() {
        baseComponents.clear();
    }

    public AppComponent getAppComponent() {
        return getBaseComponent(KEY_APP);
    }

    public void setAppComponent(BaseComponent component) {
        baseComponents.put(KEY_APP, component);
    }

    private static class LazyHolder {

        private static final ComponentsManager INSTANCE = new ComponentsManager();
    }
}
