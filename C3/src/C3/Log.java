package C3;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Log extends JPanel implements Serializable {

    private JTextArea logArea;

    private String fontStyle = "Monospaced";
    private String fontColour = "black";
    private int fontSize = 12;
    private String bgColour = "white";

    // Wymagane flagi konfiguracyjne
    private boolean blokowanieDrukowania = false;
    private boolean darkMode = true;
    private boolean forbiddenFont = true;
    private boolean drukujWynikDzialania = true;
    private boolean drukujKomunikaty = true;
    private boolean trybNadpisywania = false;
    private boolean zapisLogu = false;

    public Log() {
        setLayout(new BorderLayout());

        logArea = new JTextArea();
        logArea.setEditable(false);
        updateFont();
        updateBgColour();

        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ========== Funkcje główne ==========
    public void loguj(String text) {
        if (blokowanieDrukowania) return;
        if (!drukujKomunikaty) return;
        if (forbiddenFont && fontStyle.equalsIgnoreCase("Comic Sans MS")) return;

        if (trybNadpisywania) {
            logArea.setText(text + "\n");
        } else {
            logArea.append(text + "\n");
        }

        if (zapisLogu) {
            // Tutaj możesz dopisać logikę zapisu do pliku
        }
    }

    public void logujWynik(String wynik) {
        if (blokowanieDrukowania) return;
        if (!drukujWynikDzialania) return;

        loguj("Wynik: " + wynik);
    }

    // ========== Settery i Gettery dla flag ==========
    public boolean isBlokowanieDrukowania() {
        return blokowanieDrukowania;
    }

    public void setBlokowanieDrukowania(boolean blokowanieDrukowania) {
        this.blokowanieDrukowania = blokowanieDrukowania;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        if (darkMode) {
            logArea.setBackground(Color.DARK_GRAY);
            logArea.setForeground(Color.WHITE);
        } else {
            updateBgColour();
            logArea.setForeground(Color.BLACK);
        }
    }

    public boolean isForbiddenFont() {
        return forbiddenFont;
    }

    public void setForbiddenFont(boolean forbiddenFont) {
        this.forbiddenFont = forbiddenFont;
    }

    public boolean isDrukujWynikDzialania() {
        return drukujWynikDzialania;
    }

    public void setDrukujWynikDzialania(boolean drukujWynikDzialania) {
        this.drukujWynikDzialania = drukujWynikDzialania;
    }

    public boolean isDrukujKomunikaty() {
        return drukujKomunikaty;
    }

    public void setDrukujKomunikaty(boolean drukujKomunikaty) {
        this.drukujKomunikaty = drukujKomunikaty;
    }

    public boolean isTrybNadpisywania() {
        return trybNadpisywania;
    }

    public void setTrybNadpisywania(boolean trybNadpisywania) {
        this.trybNadpisywania = trybNadpisywania;
    }

    public boolean isZapisLogu() {
        return zapisLogu;
    }

    public void setZapisLogu(boolean zapisLogu) {
        this.zapisLogu = zapisLogu;
    }

    // ========== Konfiguracja wyglądu ==========
    public void setFontSize(int size) {
        this.fontSize = size;
        updateFont();
    }

    public void setFontColour(String colour) {
        this.fontColour = colour;
        logArea.setForeground(Color.decode(colour));
    }

    public void setFontStyle(String style) {
        this.fontStyle = style;
        updateFont();
    }

    public void setBgColour(String colour) {
        this.bgColour = colour;
        updateBgColour();
    }

    private void updateFont() {
        logArea.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
    }

    private void updateBgColour() {
        try {
            logArea.setBackground(Color.decode(bgColour));
        } catch (Exception e) {
            logArea.setBackground(Color.WHITE); // domyślny fallback
        }
    }

    // ========== Dodatkowe ==========
    public String getLogText() {
        return logArea.getText();
    }

    public void setLogText(String text) {
        logArea.setText(text);
    }

    public void appendLog(String text) {
        loguj(text);
    }
}
