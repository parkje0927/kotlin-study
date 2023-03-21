package com.study.basic.domain;

import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public record PersonJava(String name) {

    @Override
//    @Nullable
    @NotNull
    public String name() {
        return name;
    }
}
