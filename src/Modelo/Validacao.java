
package Modelo;

public class Validacao {
    
     private String mensagem;
     private String anoDes;
     private int  ano;

    public Validacao(String anoDes) {
        this.anoDes = anoDes;
        ValidarAno();
    }

    private void ValidarAno()
    {
      this.mensagem = "";
      try
      {
          if(this.anoDes.equals(""))
                this.ano = 0;
          else
            this.ano = Integer.parseInt(this.anoDes);
            
      }
      catch (Exception e)
      {
            this.mensagem += "ID inválido";
      }
      
      
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAnoDes() {
        return anoDes;
    }

    public void setAnoDes(String anoDes) {
        this.anoDes = anoDes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

   
    
    
}
