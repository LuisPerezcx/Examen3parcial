package pojo;

public class Postulaciones {
    Postulante postulante;
    Vacante vacante;
    int indexPostulante;
    int indexVacnte;

    public Postulaciones(Postulante postulante, Vacante vacante, int indexPostulante, int indexVacnte) {
        this.postulante = postulante;
        this.vacante = vacante;
        this.indexPostulante = indexPostulante;
        this.indexVacnte = indexVacnte;
    }
    public int getIndexPostulante() {
        return indexPostulante;
    }
    public int getIndexVacante() {
        return indexVacnte;
    }

    @Override
    public String toString() {
        return "Postulaciones{" +
                "postulante=" + postulante +
                ", vacante=" + vacante +
                ", indexPostulante=" + indexPostulante +
                ", indexVacnte=" + indexVacnte +
                '}';
    }
}
