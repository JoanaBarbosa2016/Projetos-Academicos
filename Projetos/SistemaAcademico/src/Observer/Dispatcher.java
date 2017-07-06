/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Joana
 */
public class Dispatcher {
private static Dispatcher instance;
private Set<Listener> listeners;

private Dispatcher() {
this.listeners= new HashSet<Listener>();
}

public static Dispatcher getInstance() {
if (instance == null) {
instance = new Dispatcher();
}
return instance;
}

public void addListener(Listener listener) {
this.listeners.add(listener);
}

public void removeListener(Listener listener) {
this.listeners.remove(listener);
}

public void dispatchEvent(Event event) {
Iterator<Listener> iterator = listeners.iterator();
while (iterator.hasNext()) {
Listener listener= (Listener) iterator.next();
listener.receivedEvent(event);
} 
}
}
