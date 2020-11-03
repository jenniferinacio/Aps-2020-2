
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    
  public static void selectionSort(List<DesmatamentoAmaz> array) 
  {
     int[] ret = new int[array.size()];
     for (int i=0; i < ret.length; i++)
     {
        ret[i] = array.get(i).getAno().intValue();
     }
      
      
    for (int fixo = 0; fixo < array.size() - 1; fixo++) 
    {
        int menor = fixo;

        for (int i = menor + 1; i < array.size(); i++) 
        {
           if (ret[i] < ret[menor]) 
           {
              menor = i;
           }
        }
        if (menor != fixo) 
        {
          int t = ret[fixo];
          ret[fixo] = ret[menor];
          ret[menor] = t;
          Estatico.listaResultado.add(array.get(menor));
        }
        
    }  
       
   }

}
