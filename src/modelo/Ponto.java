package modelo;

public class Ponto {
  private boolean entrou = false;
  public final String nome;
  String entrada;
  String saida;
  public final String ponto = getPonto();

  Ponto(String nome) {
    this.nome = nome;
  }

  public void bater(String tempo) {
    if (checkTempo(tempo)) {
      if (this.entrou == false) {
        this.entrou = !this.entrou;
        this.entrada = tempo;
      } else {
        this.saida = tempo;
      }
    }
  }

  String getPonto() {
    if(this.entrou) 
      return nome+" entrou às "
  }

  Boolean checkTempo(String tempo) {
    String time[] = tempo.split(":");
    int hora = Integer.parseInt(time[0]);
    int minutos = Integer.parseInt(time[1]);
    int segundos = Integer.parseInt(time[2]);
    if (hora < 0 || hora > 24)
      return false;
    if (minutos < 0 || segundos < 0)
      return false;

    return true;
  }

  @Override
  // public String toString() {
  //   if (entrou) {
  //     String times[] = entrada.split(":");
  //     if(times.length == 3)
  //     return times[0] + "h" + times[1] + "m" + times[2] + "s";
  //     if (times.length == 3)
  //     return times[0] + "h" + times[1] + "m" + times[2] + "s";
  //   } else {
  //     String times[] = entrada.split(":");
  //     String times2[] = saida.split(":");
  //     return times[0] + "h" + times[1] + "m" + times[2] + "s"+" e saiu às ";
  //   }
  // }
}
