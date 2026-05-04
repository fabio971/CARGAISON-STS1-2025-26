package app.view.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.model.classes.metier.Client;
import app.view.FenetrePrincipale;

public class CreerDossierPanel extends JPanel {
	
	private final JLabel lblIdentifiant = new JLabel("Identifiant : ");
	private final JLabel lblNom = new JLabel("Nom : ");
    private final JLabel lblPrenom = new JLabel("Prénom : ");
    private final JLabel lblAdresse = new JLabel("Adresse : ");
    private final JLabel lblTel = new JLabel("Téléphone : ");
    private final JLabel lblMail = new JLabel("E-mail : ");
	
	private final JTextField jtfIdentifiant = new JTextField(22);
	private final JTextField jtfNom = new JTextField(14);
    private final JTextField jtfPrenom = new JTextField(14);
    private final JTextField jtfAdresse = new JTextField(50);
    private final JTextField jtfTel = new JTextField(15);
    private final JTextField jtfMail = new JTextField(100);

    private final JButton btnCreer = new JButton("Créer");
    private final JButton btnReset = new JButton("Raffraichir");
    private final JButton btnAccueil = new JButton("Fermer");
	
	public CreerDossierPanel() {
		// Ça permet de centrer tout le bloc content dans le panel.
		setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel principal contenant tout le contenu
        JPanel content = new JPanel();
        /*
         * Ça empile verticalement :
			- titre
			- formulaire
			- boutons
         */
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel titre = new JLabel("Créer un dossier client", SwingConstants.CENTER);
        titre.setFont(titre.getFont().deriveFont(Font.BOLD, 20f));
        titre.setAlignmentX(CENTER_ALIGNMENT);

        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.add(this.lblIdentifiant);
        form.add(this.jtfIdentifiant);
        form.add(this.lblNom);
        form.add(this.jtfNom);
        form.add(this.lblPrenom);
        form.add(this.jtfPrenom);
        form.add(this.lblAdresse);
        form.add(this.jtfAdresse);
        form.add(this.lblTel);
        form.add(this.jtfTel);
        form.add(this.lblMail);
        form.add(this.jtfMail);
        

        // Limiter la largeur du formulaire
        /*
         * form.setMaximumSize(...)
         * Ça évite que le formulaire s’étire trop en largeur.
         */
        form.setMaximumSize(new Dimension(900, form.getPreferredSize().height));
        form.setAlignmentX(CENTER_ALIGNMENT);

        /*
         * ECOUTEURS BOUTONS
         */
        this.btnCreer.addActionListener(new java.awt.event.ActionListener() {
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        /*
		         * Recuperer le contenu de tous les items (JTextField)
		         * et on va créer un objet Client
		         */
		    	Client client = new Client();
		    	client.setIdentifiant(jtfIdentifiant.getText());
		    	client.setNom(jtfNom.getText());
		    	client.setPrenom(jtfPrenom.getText());
		    	client.setAdresse(jtfAdresse.getText());
		    	client.setTelephone(jtfTel.getText());
		    	client.setEmail(jtfMail.getText());
		    	System.out.println(client);
		    }
		});
        
        this.btnReset.addActionListener(new java.awt.event.ActionListener() {
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        jtfIdentifiant.setText("");
		        jtfNom.setText("");
		        jtfPrenom.setText("");
		        jtfAdresse.setText("");
		        jtfTel.setText("");
		        jtfMail.setText("");
		    }
		});
        
        this.btnAccueil.addActionListener(new java.awt.event.ActionListener() {
		    @Override
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		        FenetrePrincipale.showCard(FenetrePrincipale.CARD_ACCUEIL);
		    }
		});
        
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.add(btnCreer);
        actions.add(btnReset);
        actions.add(btnAccueil);
        actions.setAlignmentX(CENTER_ALIGNMENT);
        

        // Assemblage vertical avec espaces réduits
        /*
         * Box.createVerticalStrut(...)
         * Ça te permet de contrôler précisément l’espace :
         * 20 px entre titre et formulaire
         * 15 px entre formulaire et boutons
         */
        content.add(titre);
        content.add(Box.createVerticalStrut(20));
        content.add(form);
        content.add(Box.createVerticalStrut(15));
        content.add(actions);

        add(content);
    }

}
