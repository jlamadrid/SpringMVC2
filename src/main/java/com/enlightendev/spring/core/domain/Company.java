package com.enlightendev.spring.core.domain;

import javax.persistence.Entity;

/**
 * Plain @Entity annotated class
 */
@Entity
public class Company extends AbstractEntity {

    /**
     * These basic string properties need no additional annotations; persistence provider will automatically map them
     * into table columns. If there were demand to customize the names of the columns to which the properties would be
     * persisted, you could use the @Column annotation.
     */
    private String name;
    private String ticker;
    private String exchange;


    protected Company(){}

    public Company(String name, String ticker, String exchange){
        this.name = name;
        this.ticker = ticker;
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
