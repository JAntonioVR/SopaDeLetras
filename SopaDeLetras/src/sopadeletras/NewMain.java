/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import sopadeletras.SopaDeLetras;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author JuanAntonio
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        pista="Cuando algo está muy bien, se suele decir que es la ...";
        position=new Pair(0,1);
        orientation=Orientacion.VERTICAL;
        p=new Palabra(name, position,orientation,pista,definition);
        palabras.add(p);
        
        
        
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(sopa[i][j]+"  ");
            }
            System.out.println("\n");
        }
        
        for(int i=0; i<palabras.size();i++){
            System.out.println(palabras.get(i).toString());
            
        }
        
        SopaDeLetras s=new SopaDeLetras(sopa,palabras);
        
        s.encontrarPalabra("uva");
        s.encontrarPalabra("sandia");
        s.encontrarPalabra("limon");
        s.encontrarPalabra("pera");
        s.encontrarPalabra("manzana");
        s.encontrarPalabra("naranja");
        s.encontrarPalabra("fresa");
        s.encontrarPalabra("melon");
        
        
        if(!s.encontrarPalabra("rabano"))
               System.out.println("No esta");
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(sopa[i][j]+"  ");
            }
            System.out.println("\n");
        }
        
        System.out.println("TO STRING");
        
        System.out.println(s.toString());
        
        if(s.estaResuelta()){
            System.out.println("ESTÁ RESUELTA");
        }
        
    }
    
}
