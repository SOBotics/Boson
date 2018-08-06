package org.sobotics.boson.framework.services.chat.filters;

public class EmptyFilter<T> extends Filter<T> {
    @Override
    public boolean filter(T data) {
        return true;
    }
}
