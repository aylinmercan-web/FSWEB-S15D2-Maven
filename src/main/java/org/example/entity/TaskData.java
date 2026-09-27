package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks,
                    Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee) {
        if (assignee == null) {
            return new HashSet<>();
        }
        switch (assignee.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    // Verilen tüm setlerin birleşimi
    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> result = new LinkedHashSet<>();
        for (Set<Task> set : sets) {
            if (set != null) {
                result.addAll(set);
            }
        }
        return result;
    }

    // İki setin kesişimi
    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> result = new LinkedHashSet<>(first);
        result.retainAll(second);
        return result;
    }

    // İlk setten ikinci setteki elemanları çıkarır
    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> result = new LinkedHashSet<>(first);
        result.removeAll(second);
        return result;
    }
}
