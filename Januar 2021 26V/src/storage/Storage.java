package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Fag> alleFag = new ArrayList<>();
    private static final ArrayList<Studerende> alleStuderende = new ArrayList<>();

    public static ArrayList<Fag> getAlleFag() {
        return new ArrayList<>(alleFag);
    }

    public static ArrayList<Studerende> getAlleStuderende() {
        return new ArrayList<>(alleStuderende);
    }

    public static void gemFag(Fag fag) {
        alleFag.add(fag);
    }

    public static void gemStuderende(Studerende studerende) {
        alleStuderende.add(studerende);
    }
}

