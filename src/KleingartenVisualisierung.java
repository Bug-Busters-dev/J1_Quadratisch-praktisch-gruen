import javax.swing.*;
import java.awt.*;

public class KleingartenVisualisierung extends JPanel {

    private int grundstueckX;  // Grundstücksbreite
    private int grundstueckY;  // Grundstückshöhe
    private float kleingartenLängeX;  // Breite eines Kleingartens
    private float kleingartenLängeY;  // Höhe eines Kleingartens
    private int anzahlKleingaerten;   // Anzahl der berechneten Kleingärten
    private int differenzInteressenten;  // Differenz zwischen Kleingärten und Interessenten

    // Mindestgröße für die Kleingärten, um sie sichtbar zu machen
    private static final int MIN_KLEINGARTEN_GRÖSSE = 10;

    // Konstruktor, in dem die Daten übergeben werden
    public KleingartenVisualisierung(int grundstueckX, int grundstueckY, float kleingartenLängeX, float kleingartenLängeY, int anzahlInteressenten) {
        this.grundstueckX = grundstueckX;
        this.grundstueckY = grundstueckY;
        this.kleingartenLängeX = kleingartenLängeX;
        this.kleingartenLängeY = kleingartenLängeY;
        this.anzahlKleingaerten = (int) ((grundstueckX / kleingartenLängeX) * (grundstueckY / kleingartenLängeY));
        this.differenzInteressenten = anzahlKleingaerten - anzahlInteressenten;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrundfarbe: Dunkelgrau (für Dark Mode)
        setBackground(new Color(30, 30, 30));

        // Umwandlung von Graphics in Graphics2D für erweiterte Funktionen
        Graphics2D g2d = (Graphics2D) g;

        // Scrollbare Panel-Größe abhängig von Grundstücksgröße
        int panelWidth = Math.max(grundstueckX + 100, getWidth());  // Grundstueck + Puffer
        int panelHeight = Math.max(grundstueckY + 100, getHeight());
        setPreferredSize(new Dimension(panelWidth, panelHeight));

        // Berechnen des Skalierungsfaktors, um sicherzustellen, dass auch große Grundstücke sichtbar sind
        int padding = 50;  // Abstand vom Rand
        int availableWidth = getWidth() - 2 * padding;
        int availableHeight = getHeight() - 2 * padding - 200;  // Raum für Texte unten
        double scaleFactor = Math.min((double) availableWidth / grundstueckX, (double) availableHeight / grundstueckY);

        // Mindestskalierung für die Kleingärten, damit sie immer sichtbar sind
        if (scaleFactor * kleingartenLängeX < MIN_KLEINGARTEN_GRÖSSE || scaleFactor * kleingartenLängeY < MIN_KLEINGARTEN_GRÖSSE) {
            scaleFactor = Math.max((double) MIN_KLEINGARTEN_GRÖSSE / kleingartenLängeX, (double) MIN_KLEINGARTEN_GRÖSSE / kleingartenLängeY);
        }

        // Grundstück zeichnen (inklusive Rändern)
        g2d.setColor(new Color(70, 70, 70));  // Dunkleres Grau für das Grundstück
        int startX = padding;
        int startY = padding;
        int scaledWidth = (int) (grundstueckX * scaleFactor);
        int scaledHeight = (int) (grundstueckY * scaleFactor);
        g2d.fillRect(startX, startY, scaledWidth, scaledHeight);  // Maßstab anpassen

        // Rahmen um das Grundstück zeichnen
        g2d.setColor(Color.WHITE);  // Heller Rahmen
        g2d.setStroke(new BasicStroke(3));  // Dickere Linie für den Rahmen
        g2d.drawRect(startX, startY, scaledWidth, scaledHeight);  // Grundstücksrahmen zeichnen

        // Kleingarten-Raster in Pink zeichnen
        g2d.setColor(new Color(255, 105, 180));  // Helles Pink für das Raster
        for (int i = 0; i < grundstueckX / kleingartenLängeX; i++) {
            for (int j = 0; j < grundstueckY / kleingartenLängeY; j++) {
                int rectX = startX + (int) (i * kleingartenLängeX * scaleFactor);
                int rectY = startY + (int) (j * kleingartenLängeY * scaleFactor);
                int rectWidth = (int) (kleingartenLängeX * scaleFactor);
                int rectHeight = (int) (kleingartenLängeY * scaleFactor);

                // Mindestgröße für die Kleingärten sicherstellen
                rectWidth = Math.max(rectWidth, MIN_KLEINGARTEN_GRÖSSE);
                rectHeight = Math.max(rectHeight, MIN_KLEINGARTEN_GRÖSSE);

                g2d.drawRect(rectX, rectY, rectWidth, rectHeight);  // Kleingarten-Rechtecke zeichnen
            }
        }

        // Informationen in heller Schrift anzeigen
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        int textStartY = startY + scaledHeight + 30;  // Startpunkt für den Text unter dem Grundstück
        g2d.drawString("Grundstück: " + grundstueckX + " x " + grundstueckY, startX, textStartY);
        g2d.drawString("Kleingarten: " + kleingartenLängeX + " x " + kleingartenLängeY, startX, textStartY + 20);
        g2d.drawString("Anzahl Kleingärten: " + anzahlKleingaerten, startX, textStartY + 40);
        g2d.drawString("Differenz Interessenten: " + differenzInteressenten, startX, textStartY + 60);
    }
}
