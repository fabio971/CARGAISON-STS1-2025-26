package app.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import app.view.panels.AccueilPanel;
import app.view.panels.CreerDossierPanel;
import app.view.panels.EtudiantsPanel;

public class FenetrePrincipale extends JFrame {

	public static final String CARD_ACCUEIL = "ACCUEIL";
    public static final String CARD_ETUDIANTS = "ETUDIANTS";
    public static final String CARD_CREER_DOSSIER = "CREER_DOSSIER";

    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel panelCentral = new JPanel(cardLayout);

    private final AccueilPanel accueilPanel = new AccueilPanel();
    private final EtudiantsPanel etudiantsPanel = new EtudiantsPanel();
    private final CreerDossierPanel creerdossierPanel = new CreerDossierPanel();

    public FenetrePrincipale() {
        setTitle("CARG-GEST : GESTIONNAIRE CARGAISON");
        setSize(850, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelCentral.add(accueilPanel, CARD_ACCUEIL);
        panelCentral.add(etudiantsPanel, CARD_ETUDIANTS);
        panelCentral.add(creerdossierPanel, CARD_CREER_DOSSIER);

        setLayout(new BorderLayout());
        add(panelCentral, BorderLayout.CENTER);

        setJMenuBar(creerMenu());

        showCard(CARD_ACCUEIL);
        setVisible(true);
    }

    private JMenuBar creerMenu() {
        JMenuBar bar = new JMenuBar();
          
        JMenu menuFichier = new JMenu("FICHIER");
        JMenuItem mFichierOpQuitter = new JMenuItem("Quitter");
        mFichierOpQuitter.addActionListener(e -> System.exit(0));
        menuFichier.add(mFichierOpQuitter);

        JMenu menuClient = new JMenu("CLIENT");
        JMenuItem mClientOpCreerDossier = new JMenuItem("Créer dossier");
        mClientOpCreerDossier.addActionListener(e -> this.showCard(this.CARD_CREER_DOSSIER));
        JMenuItem mClientOpModifier = new JMenuItem("Modifier");
        JMenuItem mClientOpLister = new JMenuItem("Lister");
        menuClient.add(mClientOpCreerDossier); 
        menuClient.add(mClientOpModifier);
        menuClient.add(mClientOpLister); 
        
        JMenu menuGestion = new JMenu("GESTION");
        JMenuItem mClientOpReceptionMarchandise = new JMenuItem("Réception marchandise");
        JMenuItem mClientOpSuivi = new JMenuItem("Suivi");
        JMenuItem mClientOpCreerCargaison = new JMenuItem("Créer cargaison");
        JMenuItem mClientOpListerCargaison = new JMenuItem("Lister cargaison");
        menuGestion.add(mClientOpReceptionMarchandise); 
        menuGestion.add(mClientOpSuivi);
        menuGestion.add(mClientOpCreerCargaison);
        menuGestion.add(mClientOpListerCargaison);
        
        /*JMenu menuNav = new JMenu("Navigation");
        JMenuItem accueil = new JMenuItem("Accueil");
        accueil.addActionListener(e -> showCard(CARD_ACCUEIL));
        
        accueil.addActionListener(new java.awt.event.ActionListener() {
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        showView(VIEW_ACCUEIL, true);
		    }
		});
        JMenuItem etudiants = new JMenuItem("Étudiants");
        etudiants.addActionListener(e -> showCard(CARD_ETUDIANTS));
        menuNav.add(accueil);
        menuNav.add(etudiants);*/

        bar.add(menuFichier);
        bar.add(menuClient);
        bar.add(menuGestion);
        
        return bar;
    }

    public static void showCard(String name) {
        cardLayout.show(panelCentral, name);
    }

    public EtudiantsPanel getEtudiantsPanel() { return etudiantsPanel; }
    public CreerDossierPanel getCreerDossierPanel() { return creerdossierPanel; }
	
}
