package modelo;

public class TimeSpan {
  public final int dias;
  public final int horas;
  public final int minutos;
  public final int segundos;

  public TimeSpan(int dias, int horas, int minutos, int segundos) {
    if (dias < 0 || horas < 0 || minutos < 0 || segundos < 0)
      throw new IllegalArgumentException("dias, horas, minutos e segundos precisam ser maiores ou iguais a 0");

    this.dias = dias;
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  public TimeSpan(int horas, int minutos, int segundos) {
    if (horas < 0 || minutos < 0 || segundos < 0)
      throw new IllegalArgumentException("dias, horas, minutos e segundos precisam ser maiores ou iguais a 0");

    this.dias = 0;
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  public int getDays() {
    return this.dias;
  }

  public int getHours() {
    return this.horas;
  }

  public int getMinutes() {
    return this.minutos;
  }

  public int getSeconds() {
    return this.segundos;
  }

  boolean greaterThan(TimeSpan tempo) {
    if (getDays() > tempo.dias)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas && getMinutes() > tempo.minutos)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas && getMinutes() > tempo.minutos
        && getSeconds() > tempo.segundos)
      return true;
    else
      return false;
  }

  boolean lessThan(TimeSpan tempo) {
    if (getDays() > tempo.dias)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas && getMinutes() > tempo.minutos)
      return true;
    else if (getDays() > tempo.dias && getHours() > tempo.horas && getMinutes() > tempo.minutos
        && getSeconds() > tempo.segundos)
      return true;
    else
      return false;
  }

  public String toString(String language) {
    if (language == "pt")
      return this.dias + " dia," + this.horas + " horas," + this.minutos + " minutos e " + this.segundos + " segundos";
    else if (language == "en")
      return this.dias + " days," + this.horas + " hours," + this.minutos + " minutes and " + this.segundos
          + " seconds";
    else {
      throw new IllegalArgumentException("Define a language!!!!! (pt or en)");
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;

    if (obj instanceof TimeSpan) {
      TimeSpan tmp = (TimeSpan) obj;
      if (this.dias == tmp.dias && this.horas == tmp.horas && this.minutos == tmp.minutos
          && this.segundos == tmp.segundos)
        return true;
    }
    return false;
  }
}
