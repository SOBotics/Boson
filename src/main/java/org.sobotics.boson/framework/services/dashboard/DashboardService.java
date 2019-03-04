package org.sobotics.boson.framework.services.dashboard;

import io.swagger.client.ApiException;

public interface DashboardService <T> {
    public String createReport(T content) throws ApiException;
}
