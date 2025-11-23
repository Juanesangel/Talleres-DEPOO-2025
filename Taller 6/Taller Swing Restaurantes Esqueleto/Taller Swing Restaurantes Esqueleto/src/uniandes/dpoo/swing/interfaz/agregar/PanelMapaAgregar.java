package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapaAgregar extends JPanel implements MouseListener
{
    private JLabel labMapa;
    private int x;
    private int y;

    public PanelMapaAgregar( )
    {
        // cargar la imagen desde el classpath (coloca mapa.png en src/imagenes)
    	ImageIcon icon = new ImageIcon("C:\\Users\\juane\\OneDrive\\Desktop\\Universidad\\DEPO\\Talleres DEPOO 2025\\Taller 6\\Taller Swing Restaurantes Esqueleto\\Taller Swing Restaurantes Esqueleto\\imagenes\\mapa.png");

        this.labMapa = new JLabel(icon);
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        labMapa.addMouseListener(this);

        // Usamos layout por defecto (FlowLayout) y agregamos el label.
        add(labMapa);

        this.x = -1;
        this.y = -1;
    }

    public int[] getCoordenadas( )
    {
        return new int[]{ x, y };
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Si hay un punto seleccionado, dibuja el círculo con offset del label (si el label existe)
        if (x >= 0 && y >= 0)
        {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);

            // labMapa puede no estar en 0,0 dentro del panel; agregamos su offset
            int offsetX = labMapa.getX();
            int offsetY = labMapa.getY();

            g2d.fillOval(offsetX + x - 3, offsetY + y - 3, 7, 7);
        }
    }

    public int getXSeleccionado() {
        return x;
    }

    public int getYSeleccionado() {
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // e.getX() y e.getY() vienen relativos al componente que recibió el evento.
        // Como agregaste el MouseListener a labMapa, están en coordenadas del label — perfecto.
        this.x = e.getX();
        this.y = e.getY();
        repaint();
    }

    // otros métodos vacíos
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
