package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
    	setLayout(new GridLayout(3, 1));
        // Configura la etiqueta para el nombre
        // TODO completar el constructor
    	labNombre = new JLabel("Nombre: ---");

        // Configura la etiqueta para la calificación
        // TODO completar el constructor
        labCalificacion = new JLabel();
        labCalificacion.setIcon(buscarIconoCalificacion(1));

        // Configura el checkbox para indicar si ya se visitaó o no el restaurante
        // TODO completar el constructor
        chkVisitado = new JCheckBox("Visitado");
        chkVisitado.setEnabled(false);
        // Organiza los elementos en la venta
        // TODO completar el constructor
        add(labNombre);
        add(labCalificacion);
        add(chkVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     * @param nombre
     * @param calificacion
     * @param visitado
     */
    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
     // TODO completar actualizarRestaurante
        labNombre.setText("Nombre: " + nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setSelected(visitado);

    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante( Restaurante r )
    {
        this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que muestra la calificación
     * @param calificacion La calificación del restaurante, que debe ser un numero entre 1 y 5.
     * @return Una imagen a la que corresponde la calificación
     */
    private ImageIcon buscarIconoCalificacion(int calificacion)
    {
        String ruta = "C:\\Users\\juane\\OneDrive\\Desktop\\Universidad\\DEPO\\Talleres DEPOO 2025\\Taller 6\\Taller Swing Restaurantes Esqueleto\\Taller Swing Restaurantes Esqueleto\\imagenes" + calificacion + ".png";
        java.net.URL url = getClass().getResource(ruta);
        
        if (url == null)
        {
            System.err.println("No se encontró la imagen: " + ruta);
            return null;
        }
        
        return new ImageIcon(url);
    }
}
