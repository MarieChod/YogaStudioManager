package cz.majasana;

import java.util.ArrayList;

public class Lesson {

    private String name;
    private String time;
    private int capacity;
    private ArrayList<String> participants;

    public Lesson(String name, String time, int capacity) {
        this.name = name;
        this.time = time;
        this.capacity = capacity;
        this.participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSpots() {
        return capacity - participants.size();
    }

    public boolean hasAvailableSpace() {
        return participants.size() < capacity;
    }

    public boolean addReservation(String name) {
        if (!hasAvailableSpace()) {
            return false;
        }

        participants.add(name);
        return true;
    }

    public ArrayList<String> getParticipants() {
        return new ArrayList<>(participants);
    }

    @Override
    public String toString() {
        return name + " (" + time + ") - available spots: "
                + getAvailableSpots() + "/" + capacity;
    }
}