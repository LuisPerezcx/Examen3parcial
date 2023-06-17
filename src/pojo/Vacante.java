package pojo;

public class Vacante {
    int numero;
    String nombre,fecha,sueldo,descripcion,experiencia;

    public Vacante(String nombre, int numero, String fecha, String sueldo, String descripcion, String experiencia) {
        this.nombre = nombre;
        this.numero = numero;
        this.fecha = fecha;
        this.sueldo = sueldo;
        this.descripcion = descripcion;
        this.experiencia = experiencia;


    }

    public String getFecha() {
        return fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", fecha='" + fecha + '\'' +
                ", sueldo='" + sueldo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}
