package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    private Image mapaImage;
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
    	ImageIcon icon = new ImageIcon("C:\\Users\\juane\\OneDrive\\Desktop\\Universidad\\DEPO\\Talleres DEPOO 2025\\Taller 6\\Taller Swing Restaurantes Esqueleto\\Taller Swing Restaurantes Esqueleto\\imagenes\\mapa.png");

        mapaImage = icon.getImage();
        // fija tamaño preferido según la imagen (opcional)
        if (mapaImage != null)
        {
            setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar la imagen de fondo (mapa) en 0,0
        if (mapaImage != null)
        {
            g2d.drawImage(mapaImage, 0, 0, this);
        }

        // Dibujar los restaurantes encima
        if (restaurantes != null)
        {
            for (Restaurante r : restaurantes)
            {
                int x = r.getX();
                int y = r.getY();

                // Punto rojo
                g2d.setColor(Color.RED);
                g2d.fillOval(x - 3, y - 3, 8, 8);

                // Nombre (con fondo blanco para legibilidad opcional)
                g2d.setColor(Color.BLACK);
                g2d.drawString(r.getNombre(), x + 6, y);
            }
        }
    }

    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        // crea nueva lista de referencia para evitar modificar la lista original
        this.restaurantes = nuevosRestaurantes == null ? null : List.copyOf(nuevosRestaurantes);
        repaint();
    }
}
