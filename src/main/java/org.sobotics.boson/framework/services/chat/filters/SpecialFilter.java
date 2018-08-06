package org.sobotics.boson.framework.services.chat.filters;

import java.util.List;

public abstract class SpecialFilter<T> extends Filter<T> {
    public abstract List<String> getMessages();
}
