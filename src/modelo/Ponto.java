package modelo;

import java.lang.Integer;

public class Ponto {
  private boolean entrou = false;
  private final String nome;
  String entrada[];
  String saida[];
  int count = 0;
  public String ponto = getPonto();

  Ponto(String nome) {
    this.nome = nome;
  }

  public void bater(String tempo) {
    String tmp[] = getTime(tempo);
    if (checkTempo(tmp)) {
      if (this.entrou == false) {
        this.entrou = !this.entrou;
        count++;
        if (tmp.length == 0) {
          this.entrada[0] = tmp[0];
        } else if (tmp.length == 1) {
          this.entrada[0] = tmp[0];
          this.entrada[1] = tmp[1];
        } else {
          this.entrada[0] = tmp[0];
          this.entrada[1] = tmp[1];
          this.entrada[2] = tmp[2];
        }
      } else {
        count++;
        if (tmp.length == 0) {
          this.saida[0] = tmp[0];
        } else if (tmp.length == 1) {
          this.saida[0] = tmp[0];
          this.saida[1] = tmp[1];
        } else {
          this.saida[0] = tmp[0];
          this.saida[1] = tmp[1];
          this.saida[2] = tmp[2];
        }
      }
    }
  }

  Boolean checkTempo(String[] tempo) {
    if (tempo.length == 0) {
      if (Integer.parseInt(tempo[0]) < 0 || Integer.parseInt(tempo[0]) > 24)
        return false;
      else
        return true;
    } else if (tempo.length == 1) {
      if (Integer.parseInt(tempo[0]) < 0 || Integer.parseInt(tempo[0]) > 24)
        return false;
      else if (Integer.parseInt(tempo[1]) < 0)
        return false;
      else
        return true;
    } else {
      if (Integer.parseInt((tempo[0])) < 0 || Integer.parseInt((tempo[0])) > 24)
        return false;
      else if (Integer.parseInt(tempo[1]) < 0 || Integer.parseInt(tempo[2]) < 0)
        return false;
      else
        return true;
    }
  }

  String[] getTime(String tempo) {
    if (tempo.length() == 7) {
      String time[] = tempo.split(":");
      time[0] = time[0].replace("h", "");
      time[1] = time[1].replace("m", "");
      time[2] = time[2].replace("s", "");
      return time;
    } else if (tempo.length() == 6) {
      String time[] = tempo.split(":");
      time[0] = time[0].replace("h", "");
      time[1] = time[1].replace("m", "");
      return time;
    } else {
      String hora = tempo.replace("h", "");
      String ponto[] = { hora };
      return ponto;
    }
  }

  String getPonto() {
    if (count == 0)
      return nome + " Não bateu ponto";
    else
      return toString();
  }

  @Override
  public String toString() {
    if (entrou) {
      if (entrada.length == 0) {
        return nome + "entrou às 0" + entrada[0] + "h";
      } else if (entrada.length == 1) {
        return nome + "entrou às " + entrada[0] + "h" + entrada[1] + "m";
      } else {
        return nome + "entrou às " + entrada[0] + "h" + entrada[1] + "m" + entrada[2] + "s";
      }
    } else {
      if (saida.length == 0) {
        return nome + "entrou às 0" + saida[0] + "h";
      } else if (saida.length == 1) {
        return nome + "entrou às " + saida[0] + "h" + saida[1] + "m";
      } else {
        return nome + "entrou às " + saida[0] + "h" + saida[1] + "m" + saida[2] + "s";
      }
    }
  }
}