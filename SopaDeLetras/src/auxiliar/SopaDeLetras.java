

package auxiliar;

import java.util.ArrayList;
import javafx.geometry.Orientation;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class SopaDeLetras {
    private char [][] matrix;
    private ArrayList<Palabra> wordsNotFound;
    private int monedas;
    
    public SopaDeLetras(char [][] m, ArrayList<Palabra> wf){
        this.matrix = m;
        this.wordsNotFound = wf;
        this.monedas=5;
    }
    
    public boolean encontrarPalabra(String p){
        
        Palabra encontrada = null;
        boolean esta=false;
        
        for(int i=0; i<wordsNotFound.size() && esta==false ; i++){
            if(wordsNotFound.get(i).getName().equals(p)){
                encontrada=wordsNotFound.get(i);
                esta=true;
            }
        }
        
        if(esta){
            int fila, columna;
            Orientacion o = encontrada.getOrientation();
            String n=encontrada.getName();
            fila=encontrada.getFila();
            columna=encontrada.getColumna();
            
            int i,j;
            if(o==Orientacion.HORIZONTAL){
                i=fila;
                for(j=columna; j<n.length()+columna; j++)
                    matrix[i][j]=Character.toUpperCase(matrix[i][j]);
            }
            if(o==Orientacion.VERTICAL){
                j=columna;
                for(i=fila; i<n.length()+fila; i++)
                    matrix[i][j]=Character.toUpperCase(matrix[i][j]);
            }
            
            wordsNotFound.remove(encontrada);
            
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public String dameUnaPista(){
        if(wordsNotFound.isEmpty()==false && monedas>=1){
            monedas-=1;
            return wordsNotFound.get(0).getCheat();
        }
        else return null;
    }
    
    public String dameUnaDefinicion(){
        if(wordsNotFound.isEmpty()==false && monedas>=2){
            monedas-=2;
            return wordsNotFound.get(0).getDefinition();
        }
        else return null;
    }
    
    public boolean estaResuelta(){
        return wordsNotFound.isEmpty();
    }
    
    public int cuantasQuedan(){
        return wordsNotFound.size();
    }
    
    public int getMonedas(){
        return monedas;
    }
    
    public char [][] getMatrix(){
        return matrix;
    }
    
    @Override
    public String toString(){
        String cad="";
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                cad+=matrix[i][j]+"  ";
            }
            cad+="\n";
        }
        return cad;
    } 
}
