package modelo;

public class Time {
  private final int hora;
  private final int minutos;
  private final int segundos;
  public final Time MIDDAY = new Time(12, 0, 0);
  public final Time MIDNIGHT = new Time(0, 0, 0);

  Time(int hora, int minutos, int segundos) {
    this.hora = hora;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  Time(int hora, int minutos) {
    this.hora = hora;
    this.minutos = minutos;
    this.segundos = 0;
  }

  Time(int hora) {
    this.hora = hora;
    this.minutos = 0;
    this.segundos = 0;
  }

  public Time plus(Time tempo) {
    return new Time(tempo.hora, tempo.minutos, tempo.segundos);
  }

  public Time plusHours(Time tempo) {
    return new Time(tempo.hora, this.minutos, this.segundos);
  }

  public Time plusMinutes(Time tempo) {
    return new Time(this.hora, tempo.minutos, this.segundos);
  }

  public Time plusSeconds(Time tempo) {
    return new Time(this.hora, this.minutos, tempo.segundos);
  }

  public Time tick() {
    return new Time(this.hora, this.segundos, this.segundos - 1);
  }

  public Time minus(Time tempo) {
    return new Time(this.hora - tempo.hora, this.minutos - tempo.segundos, this.segundos - tempo.segundos);
  }

  public Time minusHours(int hours) {
    return new Time(this.hora - hours, this.minutos, this.segundos);
  }

  public Time minusMinutes(int minutes) {
    return new Time(this.hora, this.minutos - minutes, this.segundos);
  }

  public Time minusSeconds(int seconds) {
    return new Time(this.hora, this.minutos, this.segundos - seconds);
  }

  public String toShoString() {
    if (hora == 0)
      return (this.minutos + "m" + this.segundos + "s");
    else if (this.minutos == 0)
      return (hora + "h" + this.segundos + "s");
    else if (this.segundos == 0)
      return (hora + "h" + this.minutos + "m");
    else
      return (this.hora + "h" + this.minutos + "m" + this.segundos + "s");
  }

  public Time shift() {
    if (this.hora < 12)
      return new Time(13, this.minutos, this.segundos);
    if (this.hora < 18)
      return new Time(18, this.minutos, this.segundos);

    return new Time(0, this.minutos, this.segundos);
  }

  public boolean midDay() {
    if (this.hora == 12)
      return true;
    return false;
  }

  public boolean midNight() {
    if (this.hora == 0)
      return true;
    return false;
  }

  public String toLongString() {
    if (hora == 0)
      return (this.minutos + "minutos e " + this.segundos + " segundos");
    else if (this.minutos == 0)
      return (this.hora + " horas e " + this.segundos + " segundos");
    else if (segundos == 0)
      return (this.hora + " horas e " + this.minutos + " minutos");
    else
      return (this.hora + " horas " + this.minutos + " minutos e " + this.segundos + " segundos");
  }

  public Time fromSeconds(int segundos) {
    int horas = segundos / 3600;
    int minutos = (segundos / 60) - horas * 60;
    int segundo = segundos % 60;
    return new Time(horas, minutos, segundo);
  }

  public Time fromDouble(double segundos) {
    String tempo = "" + segundos + "";
    tempo = tempo.replace(".", "");
    int segundo = Integer.parseInt(tempo);
    int horas = segundo / 3600;
    int minutos = (segundo / 60) - horas * 60;
    int seconds = segundo % 60;
    return new Time(horas, minutos, seconds);
  }

  public Time fromString(String tempo) {
    String time[] = tempo.split(":");
    int hora = Integer.parseInt(time[0]);
    int minuto = Integer.parseInt(time[1]);
    int segundo = Integer.parseInt(time[2]);
    return new Time(hora, minuto, segundo);
  }

  public Double toDouble() {
    double hora = this.hora;
    double minuto = this.minutos;
    double segundo = this.segundos;
    return (hora + minuto + segundo);
  }

  // public int toInt() {
    
  // }

  @Override
  public String toString() {
    return (this.hora + ":" + this.minutos + ":" + this.segundos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;

    if (obj instanceof Time) {
      Time tempo = (Time) obj;
      if (this.hora == tempo.hora)
        return true;
      if (this.minutos == tempo.minutos)
        return true;
      if (this.segundos == tempo.segundos)
        return true;
    }

    return false;
  }
}
