import javax.swing.*;
import java.awt.*;

public class KleingartenVisualisierung extends JPanel {

    private int grundstueckX;  // Grundstücksbreite
    private int grundstueckY;  // Grundstückshöhe
    private float kleingartenLängeX;  // Breite eines Kleingartens
    private float kleingartenLängeY;  // Höhe eines Kleingartens
    private int anzahlInteressenten;  // Anzahl der Interessenten
    private int anzahlKleingaerten;   // Anzahl der berechneten Kleingärten
    private int differenzInteressenten;  // Differenz zwischen Kleingärten und Interessenten

    // Konstruktor, in dem die Daten übergeben werden
    public KleingartenVisualisierung(int grundstueckX, int grundstueckY, float kleingartenLängeX, float kleingartenLängeY, int anzahlInteressenten) {
        this.grundstueckX = grundstueckX;
        this.grundstueckY = grundstueckY;
        this.kleingartenLängeX = kleingartenLängeX;
        this.kleingartenLängeY = kleingartenLängeY;
        this.anzahlInteressenten = anzahlInteressenten;
        this.anzahlKleingaerten = (int) ((grundstueckX / kleingartenLängeX) * (grundstueckY / kleingartenLängeY));
        this.differenzInteressenten = anzahlKleingaerten - anzahlInteressenten;

        JFrame frame = new JFrame();
        frame.setTitle("Visualisierung der Kleingärten - Dark Mode mit Rändern");
        frame.setSize(1000, 800);  // Größeres Fenster für bessere Darstellung
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrundfarbe: Dunkelgrau (für Dark Mode)
        setBackground(new Color(30, 30, 30));

        // Umwandlung von Graphics in Graphics2D für erweiterte Funktionen
        Graphics2D g2d = (Graphics2D) g;

        // Skalierungsfaktor an Fenstergröße anpassen, sodass alles sichtbar bleibt
        int padding = 50;  // Abstand vom Rand
        int availableWidth = getWidth() - 2 * padding;
        int availableHeight = getHeight() - 2 * padding - 200;  // Raum für Texte unten
        int scaleFactor = Math.min(availableWidth / grundstueckX, availableHeight / grundstueckY);

        // Grundstück zeichnen (inklusive Rändern)
        g2d.setColor(new Color(70, 70, 70));  // Dunkleres Grau für das Grundstück
        int startX = padding;
        int startY = padding;
        int scaledWidth = grundstueckX * scaleFactor;
        int scaledHeight = grundstueckY * scaleFactor;
        g2d.fillRect(startX, startY, scaledWidth, scaledHeight);  // Maßstab anpassen

        // Rahmen um das Grundstück zeichnen
        g2d.setColor(Color.WHITE);  // Heller Rahmen
        g2d.setStroke(new BasicStroke(3));  // Dickere Linie für den Rahmen
        g2d.drawRect(startX, startY, scaledWidth, scaledHeight);  // Grundstücksrahmen zeichnen

        // Kleingarten-Raster in Pink zeichnen
        g2d.setColor(new Color(255, 105, 180));  // Helles Pink für das Raster
        for (int i = 0; i < grundstueckX / kleingartenLängeX; i++) {
            for (int j = 0; j < grundstueckY / kleingartenLängeY; j++) {
                g2d.drawRect(startX + (int) (i * kleingartenLängeX * scaleFactor),
                             startY + (int) (j * kleingartenLängeY * scaleFactor),
                             (int) (kleingartenLängeX * scaleFactor),
                             (int) (kleingartenLängeY * scaleFactor));  // Kleingarten-Rechtecke zeichnen
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
