

package sopadeletras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class ProcesadorSopaDeLetras {
    // Referencia a un socket para enviar/recibir las peticiones/respuestas
	private Socket socketServicio;
	// stream de lectura (por aquí se recibe lo que envía el cliente)
	private InputStream inputStream;
	// stream de escritura (por aquí se envía los datos al cliente)
	private OutputStream outputStream;
        

        
        public ProcesadorSopaDeLetras(Socket socketServicio) {
		this.socketServicio=socketServicio;
	}
        
        void procesa(SopaDeLetras sopa){
            // Cadena recibida a través del Socket
		String cadRecibida;
                
            // Cadena que se enviará
		String cadEnviada;
            try{
                // Obtiene los flujos de escritura/lectura
		inputStream=socketServicio.getInputStream();
		outputStream=socketServicio.getOutputStream();
			
                // Lee el número en cuestión
		BufferedReader inReader = new BufferedReader(new InputStreamReader(inputStream));
                cadRecibida = inReader.readLine();
                
                switch (cadRecibida){
                    case "1":
                      //PISTA 
                        cadEnviada=sopa.dameUnaPista();  
                        break;
                    case "2":
                      //DEFINICIÓN
                        cadEnviada="loquesea";
                        break;
                    case "3":
                      //PALABRAS RESTANTES
                        cadEnviada="loquesea";  
                        break;
                    case "5":
                      //MONEDAS RESTANTES
                        cadEnviada="Quedan "+sopa.getMonedas()+" monedas.";
                        break;
                    case "6":
                      //ACABADA O NO
                        if(sopa.estaResuelta())
                            cadEnviada="1";
                        else
                            cadEnviada="0";
                        break;
                    default:
                      //PALABRA
                        if(sopa.encontrarPalabra(cadRecibida)){
                            cadEnviada="Se ha encontrado la palabra "+cadRecibida;
                        }
                        else{
                            cadEnviada="No se ha encontrado la palabra "+cadRecibida; 
                        }
                }
                
                PrintWriter writer = new PrintWriter(outputStream, true);
                System.out.println(sopa.toString());
                writer.println(cadEnviada);
                
                
            } catch (IOException e) {
			System.err.println("Error al obtener los flujso de entrada/salida.");
		}
        }
        
       
}
