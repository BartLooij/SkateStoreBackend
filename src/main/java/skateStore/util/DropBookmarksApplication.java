package skateStore.util;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.skife.jdbi.v2.DBI;
import skateStore.DAO.ProductDAO;
import skateStore.DAO.UserDAO;
import skateStore.service.LoginService;
import skateStore.service.ProductService;
import skateStore.service.RegisterService;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "Skate store backend";
    }

    @Override
    public void initialize(final Bootstrap<DropBookmarksConfiguration> bootstrap) {
        // voegt liquibase toe aan dropwizard.
        bootstrap.addBundle(new MigrationsBundle<DropBookmarksConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DropBookmarksConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }



    @Override
    public void run(DropBookmarksConfiguration dropBookmarksConfiguration, Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        registerInjections(dropBookmarksConfiguration, environment);
        environment.jersey().packages("org.example.resource");
    }

    private void registerInjections(DropBookmarksConfiguration config, Environment env) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");

        env.jersey().register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(jdbi.onDemand(UserDAO.class)).to(UserDAO.class);
                bind(jdbi.onDemand(ProductDAO.class)).to(ProductDAO.class);
                bind(LoginService.class).to(LoginService.class);
                bind(RegisterService.class).to(RegisterService.class);
                bind(ProductService.class).to(ProductService.class);

            }
        });
    }

}
