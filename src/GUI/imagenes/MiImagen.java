package GUI.imagenes;

import java.awt.*;

public class MiImagen extends Canvas {
    int x,y;
    public MiImagen(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public void paint(Graphics g){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\david\\OneDrive\\Documentos\\4 semestre\\paradigmas\\AntojitosElPortonAzul\\src\\media\\perfil.png");
        g.drawImage(image,x,y,this);

    }
}

