/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatservidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Felip
 */

public class IservidorImpl extends UnicastRemoteObject implements Ichat{
    
    ArrayList<String> mensagens;

    int nMens;
    
    public IservidorImpl() throws RemoteException {
        super();
        
        this.mensagens = new ArrayList<>();        
    }
    
    
    @Override
    public String enviaMensagemParaServidor(String mensagem) throws RemoteException {
        mensagens.add(mensagem);       
        
       return "";
    }
    
    @Override
    public ArrayList<String> lerMensagem() throws RemoteException {
        return mensagens;
    }
    
}
