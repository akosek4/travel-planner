package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Represents a log of alarm system events.
public class EventLog implements Iterable<Event> {
    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: Creates an event log no events
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: returns the singular event log instance or creates one if null
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    //MODIFIES: this
    // EFFECTS: Adds an event to the event log.
    public void logEvent(Event e) {
        events.add(e);
    }

    //MODIFIES: this
    //EFFECTS: Clears the event log and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
