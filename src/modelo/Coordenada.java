package modelo;

public class Coordenada {
  public final Double latitude;
  public final Double longitude;

  public Coordenada(double latitude, double longitude) {
    if (latitude < -90.0 || latitude > 90.0)
      throw new IllegalArgumentException("Latitude precisa ser maior que -90 e menor que 90 graus");
    if (longitude < -180.0 || longitude > 180)
      throw new IllegalArgumentException("Longitude precisa ser maior que -180 e menor que 180 graus");

    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Coordenada norte(double x) {
    if (this.latitude <= 90)
      return new Coordenada(this.latitude + x, this.longitude);
    throw new IllegalArgumentException("Latitude precisa ser menor que 90 graus");
  }

  public Coordenada sul(double x) {
    if (this.latitude >= -90)
      return new Coordenada(this.latitude - x, longitude);

    throw new IllegalArgumentException("Latitude precisa ser maior que -90 graus");
  }

  public Coordenada oeste(double y) {
    if (this.longitude >= -180)
      return new Coordenada(this.latitude - y, longitude);

    throw new IllegalArgumentException("Longitude precisa ser maior que -180 graus");
  }

  public Coordenada lest(double y) {
    if (this.longitude <= 180)
      return new Coordenada(this.latitude + y, longitude);

    throw new IllegalArgumentException("Longitude precisa ser menor que 180 graus");
  }

  // consultas
  public boolean noEquador() {
    boolean is = this.latitude == 0.0 && this.longitude == 0.0;
    return is;
  }

  public boolean noMeridiano() {
    boolean is = this.longitude == 0;
    return is;
  }

  public boolean noNorte() {
    boolean is = this.longitude > 0.0;
    return is;
  }

  public boolean noSul() {
    boolean is = this.longitude < 0.0;
    return is;
  }

  public String toString() {
    return this.latitude + "°, " + this.longitude + "°";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;

    if (obj instanceof Coordenada) {
      Coordenada xy = (Coordenada) obj;
      if (Math.floor(this.latitude) == Math.floor(xy.latitude)
          && Math.floor(this.longitude) == Math.floor(this.longitude))
        return true;
    }

    return false;
  }
}
