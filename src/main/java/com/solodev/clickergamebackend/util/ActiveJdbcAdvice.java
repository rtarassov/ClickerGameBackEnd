package com.solodev.clickergamebackend.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.javalite.activejdbc.Base;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * Filter to open a database connection for an incoming request.
 * Uses transactions so when something fails, the database does a rollback.
 * Closes the connection when the request is handled.
 */
@Component
public class ActiveJdbcAdvice implements Filter {

    private final DataSource dataSource;

    public ActiveJdbcAdvice(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void init(FilterConfig config) {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {
        try {
            Base.open(dataSource);
            Base.openTransaction();

            chain.doFilter(req, resp);

            Base.commitTransaction();
        } catch (IOException | ServletException e) {
            Base.rollbackTransaction();
            e.printStackTrace();

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database unavailable");
        } finally {
            Base.close();
        }
    }

    @Override
    public void destroy() {
    }
}
