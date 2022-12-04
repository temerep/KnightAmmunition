package org.example.entity;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum VisionLevel {
    FULL_FACE, HALF_FACE, UNKNOWN;

    VisionLevel byString(String s) {
        if(s == null) return UNKNOWN;
        Optional<VisionLevel> any = Stream.of(values())
                .filter(x -> x.toString().equals(s))
                .findAny();
        if (any.isEmpty()) {
            return UNKNOWN;
        } else return any.get();
    }
}
