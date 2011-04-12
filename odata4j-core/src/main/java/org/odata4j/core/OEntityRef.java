package org.odata4j.core;

public interface OEntityRef<T> {

    T execute();

    OEntityRef<T> nav(String navProperty, OEntityKey key);
    OEntityRef<T> nav(String navProperty);
}
