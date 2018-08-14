package org.sobotics.boson.framework.services.chat.filters;

import java.util.Map;

public abstract class SpecialFilter<T> extends Filter<T> {
    public abstract Map<Long, String> getMessages();
}
