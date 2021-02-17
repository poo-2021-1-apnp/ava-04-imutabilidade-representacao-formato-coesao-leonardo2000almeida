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
    this(hora, 0, 0);
  }

  public Time plus(Time tempo) {
    return new Time(tempo.hora, tempo.minutos, tempo.segundos);
  }

  public Time plusHours(int hours) {
    return new Time(hours, this.minutos, this.segundos);
  }

  public Time plusMinutes(int minutes) {
    return new Time(this.hora, minutes, this.segundos);
  }

  public Time plusSeconds(int seconds) {
    return new Time(this.hora, this.minutos, seconds);
  }

  public Time tick() {
    if (this.segundos - 1 >= 0)
      return new Time(this.hora, this.minutos, this.segundos - 1);

    throw new IllegalStateException("Impossível diminuir mais !");
  }

  public Time minus(Time tempo) {
    if (this.hora - tempo.hora >= 0 && this.minutos - tempo.minutos >= 0 && this.segundos - tempo.minutos >= 0)
      return new Time(this.hora - tempo.hora, this.minutos - tempo.segundos, this.segundos - tempo.segundos);

    throw new IllegalStateException("Impossível executar essa função!");

  }

  public Time minusHours(int hours) {
    if (this.hora - hours >= 0)
      return new Time(this.hora - hours, this.minutos, this.segundos);

    throw new IllegalStateException(
        "Impossível executar essa função!: " + hours + " - " + this.hora + " precisa ser igual ou maior que zero");

  }

  public Time minusMinutes(int minutes) {
    if (this.hora - minutes >= 0)
      return new Time(this.hora, this.minutos - minutes, this.segundos);

    throw new IllegalStateException(
        "Impossível executar essa função!: " + minutes + " - " + this.hora + " precisa ser igual ou maior que zero");
  }

  public Time minusSeconds(int seconds) {
    if (this.hora - seconds >= 0)
      return new Time(this.hora, this.minutos, this.segundos - seconds);

    throw new IllegalStateException(
        "Impossível executar essa função!: " + seconds + " - " + this.hora + " precisa ser igual ou maior que zero");

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
    if (this.hora == 12 && this.minutos == 0 && this.segundos == 0)
      return true;
    return false;
  }

  public boolean midNight() {
    if (this.hora == 0 && this.minutos == 0 && this.segundos == 0)
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
    double hora = this.hora * 60;
    double minuto = this.minutos;
    double segundo = this.segundos / 60;
    return (hora + minuto + segundo) / 60;
  }

  public int toInt() {
    int hora = (this.hora * 60) * 60;
    int minutos = (this.minutos * 60) / 60;
    int segundos = (this.segundos * 60) / 60;
    return hora + minutos + segundos;
  }



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
      if (this.hora == tempo.hora && this.minutos == tempo.minutos && this.segundos == tempo.segundos)
        return true;
    }

    return false;
  }
}
