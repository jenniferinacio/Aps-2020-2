package Modelo;

import DAL.DesmatamentoAmazDAO;
import java.util.ArrayList;
import java.util.List;


public class Controle {
    
    private String mensagem;
    DAL.DesmatamentoAmazDAO desmatamentoDAO = new DAL.DesmatamentoAmazDAO();
    public List<DesmatamentoAmaz> pesquisarDesmatamentoAno(String ano)
    {
        
         this.mensagem = "";
        
        List<String> listaDados = new ArrayList<>();
        listaDados.add("0");
        listaDados.add(ano);
        listaDados.add("");
        listaDados.add("");
        
        Validacao validacao = new Validacao(ano);
        List<DesmatamentoAmaz> desmatamentoAmaz = new ArrayList<>();
        List<Integer> ordenacao = new ArrayList<>();
        if (validacao.getMensagem().equals(""))
        {
            DesmatamentoAmaz desma = new DesmatamentoAmaz();
            desma.setAno(validacao.getAno());
            desmatamentoAmaz = desmatamentoDAO.pesquisarDesmatamentoAno(desma);
            
           
            this.mensagem = desmatamentoDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
        return desmatamentoAmaz;
    }
    
    public List<DesmatamentoAmaz> pesquisarTudo()
    {
       
            List<DesmatamentoAmaz> desmaA = new ArrayList<>();
            DesmatamentoAmaz desma = new DesmatamentoAmaz();
            List<Integer> resultado = new ArrayList<>();

            desmaA = desmatamentoDAO.pesquisarTudo(desma);
             
               
                long tempoInicial = System.currentTimeMillis();

                  SelectionSort.selectionSort(desmaA);

                long tempoFinal = System.currentTimeMillis();
                
                Estatico.tempoLevado = tempoFinal - tempoInicial;
               
                
            this.mensagem = desmatamentoDAO.getMensagem();
           
            
            
              return Estatico.listaResultado;  
     
    
    }
    public int[] pesquisarPorDesmatamento()
    {
        List<DesmatamentoAmaz> desmaA = new ArrayList<>();
        DesmatamentoAmaz desma = new DesmatamentoAmaz();
        List<Integer> resultado = new ArrayList<>();

        desmaA = desmatamentoDAO.pesquisarTudo(desma);
        
        int[] ret = new int[desmaA.size()];
        for (int i=0; i < ret.length; i++)
        {
           ret[i] = desmaA.get(i).getAreaDesmatada().intValue();
        }
        
        long tempoInicial = System.currentTimeMillis();

          QuickSort.quickSort(ret,0, ret.length - 1);

        Estatico.listaRe=ret;
        long tempoFinal = System.currentTimeMillis();
                
        Estatico.tempoLevado = tempoFinal - tempoInicial;
               
                
        this.mensagem = desmatamentoDAO.getMensagem();
        return Estatico.listaRe;  
    
    }
    public int[] pesquisarMaiorPorDesmatamento()
    {
         List<DesmatamentoAmaz> desmaA = new ArrayList<>();
        DesmatamentoAmaz desma = new DesmatamentoAmaz();
        List<Integer> resultado = new ArrayList<>();

        desmaA = desmatamentoDAO.pesquisarTudo(desma);
        int[] ret = new int[desmaA.size()];
        for (int i=0; i < ret.length; i++)
        {
           ret[i] = desmaA.get(i).getAreaDesmatada().intValue();
        }
        
        long tempoInicial = System.currentTimeMillis();

        BubbleSort.bubbleSort(ret);
        Estatico.listaRe = ret; 
     
        long tempoFinal = System.currentTimeMillis();
                
        Estatico.tempoLevado = tempoFinal - tempoInicial;
               
         
        this.mensagem = desmatamentoDAO.getMensagem();
        return Estatico.listaRe;   
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public DesmatamentoAmazDAO getDesmatamentoDAO() {
        return desmatamentoDAO;
    }

    public void setDesmatamentoDAO(DesmatamentoAmazDAO desmatamentoDAO) {
        this.desmatamentoDAO = desmatamentoDAO;
    }
    
}
