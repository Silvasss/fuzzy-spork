/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatservidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

/**
 *
 * @author Felip
 */

public class ChatClienteBackup {

    static Ichat chat;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            //Obter referÃªncia para o servidor.
            chat = (Ichat) Naming.lookup("//localhost/servidor");

            String nome;

            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite seu nome: ");

            nome = scanner.nextLine();

            //Cria a Thread para CallBack, que possibilita
            //que o servidor entre em contato com o cliente                    
            Thread thread = new Thread(new Runnable() {
                    
                // Tamanho da mensagem
                int count = chat.lerMensagem().size();

                @Override
                public void run() {    
                    
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
                    }
                }
            });
            
            thread.start();
            
            while (true) {                       
                System.out.println(chat.enviaMensagemParaServidor("\r\nMensagem de " + nome + ": " + scanner.nextLine())); 
                
            }

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.err.println("Erro: " + e.getMessage());

            System.exit(0);
        }
    }
}
