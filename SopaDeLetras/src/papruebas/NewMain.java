/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papruebas;

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
        for(int j=0; j<8; j++){
            for(int i=0; i<8; i++){
                System.out.print(sopa[i][j]+"  ");
            }
            System.out.println("\n");
        }
        
        
        
    }
    
}
