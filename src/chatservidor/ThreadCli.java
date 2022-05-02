 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatservidor;

import java.rmi.RemoteException;

/**
 *
 * @author Felip
 */
public class ThreadCli extends Thread{    
    Ichat chat;    
    
    public ThreadCli(Ichat chat) throws RemoteException {
       this.chat = chat;
    }
    
    public void run() {
        while (true) {
            
        }
    }
}
