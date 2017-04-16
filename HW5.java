/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author ralph
 */
public class HW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> theData = new List<String>();
        theData.AddItem("One").AddItem("Two").AddItem("Three").AddItem("Four").AddItem("Five");
        theData.BubbleSort();
        for( String dt : theData){
            System.out.println(dt);
        
        }
        
        List<Integer> intLIst = new List<>();
        intLIst.AddItem(9).AddItem(8).AddItem(7).AddItem(6).AddItem(5);
        System.out.println("---------------------------");
        intLIst.BubbleSort();
        for( Integer vt : intLIst){
            System.out.println(vt);
        
        }
        
        
        
        
    }
    
}
