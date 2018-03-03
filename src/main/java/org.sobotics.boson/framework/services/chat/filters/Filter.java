package org.sobotics.boson.framework.services.chat.filters;

public interface Filter<T> {
    boolean filter(T data);
}
