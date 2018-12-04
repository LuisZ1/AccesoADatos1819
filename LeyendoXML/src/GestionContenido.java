import org.xml.sax.helpers.*;
import org.xml.sax.*;

import java.util.ArrayList;

public class GestionContenido extends DefaultHandler {

    public String cadenaLeida = "";
    private ArrayList<String> titulos = new ArrayList<String>();
    private ArrayList<String> autores = new ArrayList<String>();
    private ArrayList<String> formatos = new ArrayList<String>();
    private ArrayList<String> localizaciones = new ArrayList<String>();

    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() { System.out.println("Comienzo del documento XML"); }

    @Override
    public void endDocument() { System.out.println("Fin del documento XML"); }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att) {
        System.out.println("\t< " + nombre + ">");
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) {
        System.out.println("\t</ " + nombre + ">");

        switch (nombre){
            case "titulo":
                titulos.add(cadenaLeida);
                System.out.println("añadido titulo");
                break;
            case "autor":
                autores.add(cadenaLeida);
                System.out.println("añadido autor");
                break;
            case "formato":
                formatos.add(cadenaLeida);
                System.out.println("añadido formato");
                break;
            case "localizacion":
                localizaciones.add(cadenaLeida);
                System.out.println("añadido loc");
                break;
        }
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud)
            throws SAXException {
        String cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]", ""); // Quitamos tabuladores y saltos de linea
       // System.out.println("\t\t" + cad);
        cadenaLeida = cad;

    }

    public ArrayList<String> getTitulos() {
        return titulos;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public ArrayList<String> getFormatos() {
        return formatos;
    }

    public ArrayList<String> getLocalizaciones() {
        return localizaciones;
    }
}
// FIN GestionContenido
