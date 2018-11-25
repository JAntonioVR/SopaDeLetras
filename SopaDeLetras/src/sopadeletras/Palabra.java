

package sopadeletras;

import javafx.util.Pair;



/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class Palabra {
    private String name;
    private Pair<Integer, Integer> position;
    private Orientacion orientation;
    private String cheat;
    private String definition;
    
    boolean encontrada;
    
    Palabra(String n, Pair<Integer, Integer> p, Orientacion o, String pi, String def){
        this.name=n;
        this.position=p;
        this.orientation=o;
        this.cheat=pi;
        this.definition=def;
        
        encontrada=false;
    }
    
    String getName(){
        return name;
    }
    
    Pair<Integer,Integer> getPosition(){
        return position;
    }
    
    int getFila(){
        return position.getKey();
    }
    
    int getColumna(){
        return position.getValue();
    }
    
    Orientacion getOrientation(){
        return orientation;
    }
    
    String getDefinition(){
        return definition;
    }
    
    String getCheat(){
        return cheat;
    }
    
    void encontrada(){
        encontrada=true;
    }
    
    @Override
    public String toString(){
        String cad="Nombre: "+name;
        cad+="\nDefinicion: "+definition;
        cad+="\nPista: "+cheat;
        cad+="\nPosicion: ("+position.getKey().toString()+","+position.getValue().toString()+")";
        cad+="\nOrientacion: ";
        if(orientation==Orientacion.HORIZONTAL)
            cad+="HORIZONTAL\n\n";
        else
            cad+="VERTICAL\n\n";
        
        return cad;
    }
    
}
