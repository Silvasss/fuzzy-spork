/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package chatservidor;

/**
 *
 * @author Felip
 */

//
// BASE
// https://carlosdanieldrury.wordpress.com/2013/08/26/chat-feito-com-rmi-utilizando-java-threads-para-leitura-de-mensagens-no-servidor/
//


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class ServidorChat {

    public static void main(String[] args) {
        try {     
            java.rmi.registry.LocateRegistry.createRegistry(1099);

            System.out.println("RMI registry pronto.");
        } catch (RemoteException e) {
            System.out.println("Exception starting RMI registry:" + e);
        }

        try{			
            IservidorImpl s = new IservidorImpl();

            Naming.rebind("servidor", s); 
        }catch (MalformedURLException | RemoteException e){
                System.err.println("Erro aqui: "+ e.getMessage() );	

                System.exit(0);
        }       
    }    
}
