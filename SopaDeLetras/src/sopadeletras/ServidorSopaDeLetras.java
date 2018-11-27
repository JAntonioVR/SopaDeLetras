


package sopadeletras;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author JuanAntonio
 */
public class ServidorSopaDeLetras {
    
    public static void main(String[] args) {
       // Puerto de escucha
		int port=8989;
                
                SopaDeLetras sopaDeLetras=init();

		ServerSocket socketServidor;
                try {
                    // Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"
                    socketServidor=new ServerSocket(port);   
                    
                    do{
                        // Aceptamos una nueva conexión con accept()
                        Socket socketServicio=null;
                            try {
                                socketServicio=socketServidor.accept(); 
                            } catch (IOException e) {
                                System.err.println("Error: no se pudo aceptar la conexión solicitada ");
                            }
                            
                        ProcesadorSopaDeLetras procesador=new ProcesadorSopaDeLetras(socketServicio);
				procesador.procesa(sopaDeLetras);
                    }while(true);
                }catch (IOException e) {
			System.err.println("Error al escuchar en el puerto "+port);
		}
    }
    
    
    
    private static SopaDeLetras init(){
        char [][] sopa ={
            {'z','s','u','v','a','s','i','r'},
            {'m','a','n','z','a','n','a','n'},
            {'t','n','b','u','e','l','c','e'},
            {'p','d','n','o','m','i','l','u'},
            {'e','i','r','l','i','m','o','n'},
            {'r','a','m','e','l','o','n','b'},
            {'a','n','a','r','a','n','j','a'},
            {'c','u','t','f','r','e','s','a'}
        };
        
        ArrayList<Palabra> palabras= new ArrayList();
        Palabra p;
        //UVA:
        
        String name="uva";
        String definition="Baya o grano más o menos redondo y jugoso, fruto de la vid, que forma racimos.";
        String pista="El zumo de esta fruta se usa para elaborar mosto.";
        Pair<Integer, Integer> position=new Pair(0,2);
        Orientacion orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //MANZANA
        name="manzana";
        definition="Fruto del manzano, de forma globosa algo hundida por los extremos del eje, de epicarpio delgado, liso y de color verde claro, amarillo pálido o encarnado, mesocarpio con sabor acídulo o ligeramente azucarado, y semillas pequeñas, de color de caoba, encerradas en un endocarpio coriáceo.";
        pista="También se pueden encontrar en las ciudades";
        position=new Pair(0,1);
        orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //LIMÓN
        name="limon";
        definition="Fruto del limonero, de forma ovoide, con unos diez centímetros en el eje mayor y unos seis en el menor, pezón saliente en la base, corteza lisa, arrugada o surcada según las variedades, y frecuentemente de color amarillo, pulpa amarillenta dividida en gajos, comestible, jugosa y de sabor ácido.";
        pista="Usada para intensificar el sabor de las bebidas.";
        position=new Pair(4,3);
        orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //MELÓN
        name="melon";
        definition="Planta herbácea anual, de la familia de las cucurbitáceas, con tallos tendidos, ramosos, ásperos, con zarcillos, y de tres a cuatro metros de longitud, hojas pecioladas, partidas en cinco lóbulos obtusos, flores solitarias de corola amarilla, y fruto elipsoidal de 20 a 30 cm de largo, con cáscara blanca, amarilla, verde o manchada de estos colores, carne olorosa, abundante, dulce, blanda, aguanosa, que deja en el interior un hueco donde hay muchas pepitas de corteza amarilla y almendra blanca. Es originaria de Oriente y muy estimada.";
        pista="Dícese de alguien muy torpe o necio.";
        position=new Pair(5,2);
        orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //NARANJA
        name="naranja";
        definition="Fruto del naranjo, de forma globosa, de seis a ocho centímetros de diámetro, corteza rugosa, de color entre rojo y amarillo, como el de la pulpa, que está dividida en gajos, y es comestible, jugosa y de sabor agridulce.";
        pista="También es el nombre de un color";
        position=new Pair(6,1);
        orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //FRESA
        name="fresa";
        definition="Planta de la familia de las rosáceas, con tallos rastreros, nudosos y con estolones, hojas pecioladas, vellosas, blanquecinas por el envés, divididas en tres segmentos aovados y con dientes gruesos en el margen; flores pedunculadas, blancas o amarillentas, solitarias o en corimbos poco nutridos, y fruto casi redondo, algo apuntado, de un centímetro de largo, rojo, suculento y fragante.";
        pista="Muy recurrente mezclarlas con nata";
        position=new Pair(7,3);
        orientation=Orientacion.HORIZONTAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //PERA
        name="pera";
        definition="Fruto del peral.";
        pista="Cuando algo está muy bien, se suele decir que es la ...";
        position=new Pair(3,0);
        orientation=Orientacion.VERTICAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        //SANDÍA
        name="sandia";
        definition="Planta herbácea anual, de la familia de las cucurbitáceas, con tallo velloso, flexible, rastrero, de tres a cuatro metros de largo, hojas partidas en segmentos redondeados y de color verde oscuro, flores amarillas, fruto casi esférico, tan grande que a veces pesa 20 kg, de corteza verde uniforme o jaspeada y pulpa encarnada, granujienta, aguanosa y dulce, entre la que se encuentran, formando líneas concéntricas, muchas pepitas negras y aplastadas. Es planta muy cultivada en España.";
        pista="Se suele tomar muy fría en verano";
        position=new Pair(0,1);
        orientation=Orientacion.VERTICAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        SopaDeLetras sopaDeLetras = new SopaDeLetras(sopa,palabras);
        return sopaDeLetras;
        
    }
    
}
