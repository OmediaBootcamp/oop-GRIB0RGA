package dev.omedia.section_11.exercise_42;

import java.util.List;

public interface ISaveable {

    List<String> write();

    void read(List<String> list);
}

