package com.vsr.boot;

import com.vsr.model.Department;
import com.vsr.model.Faremap;
import com.vsr.model.Invoice;
import com.vsr.model.Station;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by lakshmanch on 14/10/15.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.exposeIdsFor(Station.class, Department.class, Faremap.class, Invoice.class);
    }
}
