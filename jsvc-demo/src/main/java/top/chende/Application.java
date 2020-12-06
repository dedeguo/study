package top.chende;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.support.DaemonLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class Application implements Daemon {
    private ConfigurableApplicationContext ctx;
    private String[] args;

    @Override
    public void init(DaemonContext context) throws Exception {
        args = context.getArguments();
    }

    @Override
    public void start() throws Exception {
        ctx = SpringApplication.run(Application.class, args);
    }

    @Override
    public void stop() throws Exception {
        ctx.stop();
    }

    @Override
    public void destroy() {
        ctx.close();
    }

    // Main - mostly for development.
    public static void main(String[] args) throws Exception {
        System.err.println("WARNING - running as current user");
        DaemonLoader.Context ctx = new DaemonLoader.Context();
        Application app = new Application();
        ctx.setArguments(args);
        app.init(ctx);
        app.start();
    }
}
