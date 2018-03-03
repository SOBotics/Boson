package org.sobotics.boson.framework.services.chat.filters;

public class EmptyFilter<T> implements Filter<T> {
    @Override
    public boolean filter(T data) {
        return true;
    }
}
