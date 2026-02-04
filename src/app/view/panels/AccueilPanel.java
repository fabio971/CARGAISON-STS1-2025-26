package app.view.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AccueilPanel extends JPanel {

	public AccueilPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titre = new JLabel("Accueil CARG-GEST", SwingConstants.CENTER);
        titre.setFont(titre.getFont().deriveFont(Font.BOLD, 24f));

        JTextArea txt = new JTextArea(
                "Gestion des clients\n" +
                "- Créer / Modifier / Lister\n\n" +
                "Gestion métier\n" +
                "- Réception / Suivi / Créer cargaison / Lister cargaison\n\n\n" +
                "Copyright Fabian CISNEROS BRIDON"
        );
        txt.setEditable(false);
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);

        add(titre, BorderLayout.NORTH);
        add(new JScrollPane(txt), BorderLayout.CENTER);
    }
	
}
