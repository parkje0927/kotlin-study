package com.study.basic.domain;

import org.jetbrains.annotations.NotNull;

public record JavaPerson(String name) {

    @Override
//    @Nullable
    @NotNull
    public String name() {
        return name;
    }
}
