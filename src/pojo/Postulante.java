package pojo;

public class Postulante {
    String nomre,estudios,edad,correo,telefono;

    public Postulante(String nomre, String estudios, String edad, String correo, String telefono) {
        this.nomre = nomre;
        this.estudios = estudios;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNomre() {
        return nomre;
    }

    public String getEstudios() {
        return estudios;
    }

    @Override
    public String toString() {
        return "Postulante{" +
                "nomre='" + nomre + '\'' +
                ", estudios='" + estudios + '\'' +
                ", edad='" + edad + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
