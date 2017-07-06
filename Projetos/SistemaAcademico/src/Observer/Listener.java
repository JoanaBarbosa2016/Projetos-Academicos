/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.awt.Event;

/**
 *
 * @author Joana
 */
public interface Listener {
    public void receivedEvent(Event event);

    public void receivedEvent(Observer.Event event);
  
    
}
