package com.pelican.core.domain.user;

import lombok.ToString;

/**
 * Created by Nightingale on 09.09.2014.
 */
@ToString
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
