/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatservidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Felip
 */

// ARQUIVO COM ERRO, EXECUTAR BACKUP!!

public class ChatCliente {

    static Ichat chat;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here

        try {
            //Obter referÃªncia para o servidor.
            chat = (Ichat) Naming.lookup("//localhost/servidor");
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());

            System.exit(0);
        }        
        
        try {            
            new ThreadCli(chat).start();
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());

            System.exit(0);
        }        
        
        String nome;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");

        nome = scanner.nextLine();
        
        try {            
            
            // Tamanho da mensagem
            int count = chat.lerMensagem().size();
            
            while (true) {
                try {
                    if (chat.lerMensagem().size() >= count) {

                        if (!chat.lerMensagem().isEmpty()) {                                    
                            System.out.println(chat.lerMensagem().get(chat.lerMensagem().size() - 1));

                            System.out.print("Digite uma mensagem: ");
                        } else {
                            System.out.print("Digite uma mensagem: ");
                        }

                    count++;
                    }
                } catch (RemoteException e) {
                    System.err.println("Erro**: " + e.getMessage() );	

                    System.exit(0);
                }     
                
                System.out.println(chat.enviaMensagemParaServidor("\r\nMensagem de " + nome + ": " + scanner.nextLine())); 

            }                   
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());

            System.exit(0);
        } 
                       
    }
}
