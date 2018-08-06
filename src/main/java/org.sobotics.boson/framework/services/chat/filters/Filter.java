package org.sobotics.boson.framework.services.chat.filters;

import java.util.ArrayList;
import java.util.List;

public abstract class Filter<T> {
    public abstract boolean filter(T data);

    public List<Boolean> filterAll(List<T> dataList){
        List<Boolean> returnData = new ArrayList<>();

        for(T data: dataList){
            returnData.add(filter(data));
        }
        return returnData;

    }

}
