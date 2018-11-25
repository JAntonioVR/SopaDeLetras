/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 *
 * @author JuanAntonio
 */
public class ClienteSopaDeLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opcion;
        
        String cadenaEnviada;
	String acabada;
        String definicion;
        String pista;
        String palabra;
        String cuantasQuedan;
        String monedas;
        
        
        // Nombre del host donde se ejecuta el servidor:
        String host="localhost";
        // Puerto en el que espera el servidor:
	int port=8989;
		
	// Socket para la conexión TCP
	Socket socketServicio=null;
        
        
        System.out.println("Bienvenid@ a la sopa de letras");
        System.out.println("Elija una opcion:");
        System.out.println("\t1:Empezar partida");
        System.out.println("\t0:Salir");
        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextLine();
        if(opcion.equals("1")){
            
            /*Opciones:
                A elegir por el usuario:
            0: Salir
            1: Pista
            2: Definicion
            3: Palabras restantes
            4: Introducir palabra
                Privadas del sistema:
            5: Monedas que quedan
            6: Sopa acabada o no
            */
            
            
            try {
                
                //Antes de empezar a jugar la sopa obviamente no está acabada
                acabada="0";
                
                while(acabada.equals("0")){
                    
                    // Creamos un socket que se conecte a "host" y "port":
                socketServicio=new Socket(host, port);		
                        
                //Declaramos los asistentes de envío y recepción de cadenas
		PrintWriter outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
		BufferedReader inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));
		
                    
                    //Comprobamos las monedas que nos quedan usando el servidor
                    cadenaEnviada="5";
                    outPrinter.println(cadenaEnviada);
                    monedas=inReader.readLine();
                    System.out.println(monedas);
                    
                    
                    System.out.println("¿Qué desea?");
                    System.out.println("\t1: Dame una pista (1 monedas)");
                    System.out.println("\t2: Dame una definición (2 monedas)");
                    System.out.println("\t3: ¿Cuántas palabras quedan?");
                    System.out.println("\t4: Introducir palabra");
                    System.out.println("\n\t0: Salir");
                    
                    //Leemos una de las opciones
                    teclado = new Scanner(System.in);
                    cadenaEnviada = teclado.nextLine();
                    
                    if(cadenaEnviada.equals("0")) break;
                    
                    //Dependiendo del valor introducido se hará una u otra cosa
                    
                    switch (cadenaEnviada){
                    case "1":
                      //PISTA
                        outPrinter.println(cadenaEnviada);
                        pista=inReader.readLine();                   
                        System.out.println("PISTA: "+pista);
                    case "2":
                      //DEFINICIÓN
                        outPrinter.println(cadenaEnviada);
                        definicion=inReader.readLine();
                        
                        System.out.println("DEFINICIÓN: "+definicion);
                    case "3":
                      //PALABRAS RESTANTES
                        outPrinter.println(cadenaEnviada);
                        cuantasQuedan=inReader.readLine();
                        
                        System.out.println(cuantasQuedan); 
                    case "4":
                      //INTRODUCIR PALABRA
                      //En este caso se envía una palabra al servidor
                        System.out.println("¿Qué palabra desea introducir?");
                        teclado = new Scanner(System.in);
                        cadenaEnviada = teclado.nextLine();
                        
                        outPrinter.println(cadenaEnviada);
                        palabra=inReader.readLine();
                        System.out.println(palabra);
                    }   
                    
                    
                    
                    //Se pregunta al servidor si la sopa está acabada
                    cadenaEnviada="6";
                    outPrinter.println(cadenaEnviada);
                    acabada=inReader.readLine();
                    
                    //Cerramos el socket
                    socketServicio.close();
                }
                
                

            } catch (UnknownHostException e) {
		System.err.println("Error: Nombre de host no encontrado.");
            } catch (IOException e) {
		System.err.println("Error de entrada/salida al abrir el socket.");
            }
        }    
    }
}
