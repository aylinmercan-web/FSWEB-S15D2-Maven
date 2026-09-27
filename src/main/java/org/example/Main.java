package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Java", "Write collections", "ann", Status.ASSIGNED, Priority.HIGH);
        Task t2 = new Task("Java", "Write tests", "bob", Status.IN_PROGRESS, Priority.MED);
        Task t3 = new Task("Spring", "Setup security", "carol", Status.ASSIGNED, Priority.LOW);
        Task t4 = new Task("Java", "Write collections", "bob", Status.ASSIGNED, Priority.HIGH); // t1 ile aynı task
        Task t5 = new Task("React", "Build login page", null, Status.IN_QUEUE, Priority.MED);

        Set<Task> ann = new HashSet<>(Set.of(t1));
        Set<Task> bob = new HashSet<>(Set.of(t2, t4));
        Set<Task> carol = new HashSet<>(Set.of(t3));
        Set<Task> unassigned = new HashSet<>(Set.of(t5));

        TaskData data = new TaskData(ann, bob, carol, unassigned);

        System.out.println("Tüm çalışanların taskları: " + data.getTasks("all"));
        System.out.println("Ann'in taskları: " + data.getTasks("ann"));
        System.out.println("Bob'un taskları: " + data.getTasks("bob"));
        System.out.println("Carol'ın taskları: " + data.getTasks("carol"));
        System.out.println("Atanmamış tasklar: " + data.getDifferences(unassigned, data.getTasks("all")));

        Set<Task> multi = new HashSet<>();
        multi.addAll(data.getIntersection(ann, bob));
        multi.addAll(data.getIntersection(ann, carol));
        multi.addAll(data.getIntersection(bob, carol));
        System.out.println("Birden fazla kişiye atanmış tasklar: " + multi);

        Set<String> words = StringSet.findUniqueWords();
        System.out.println("Unique kelime sayısı: " + words.size());
        System.out.println(words);
    }
}
