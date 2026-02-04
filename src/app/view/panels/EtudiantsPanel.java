package app.view.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class EtudiantsPanel extends JPanel {

	private final DefaultTableModel tableModel;
    private final JTable table;

    private final JTextField tfNom = new JTextField(14);
    private final JTextField tfPrenom = new JTextField(14);

    private final JButton btnAjouter = new JButton("Ajouter");
    private final JButton btnModifier = new JButton("Modifier sélection");
    private final JButton btnSupprimer = new JButton("Supprimer sélection");
    private final JButton btnRafraichir = new JButton("Rafraîchir");

    public EtudiantsPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titre = new JLabel("Gestion des étudiants (MVC)", SwingConstants.CENTER);
        titre.setFont(titre.getFont().deriveFont(Font.BOLD, 20f));
        add(titre, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "NOM", "PRÉNOM"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(tableModel);
        table.setRowHeight(26);

        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

        JPanel bas = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));
        form.add(new JLabel("Nom :"));
        form.add(tfNom);
        form.add(new JLabel("Prénom :"));
        form.add(tfPrenom);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.add(btnAjouter);
        actions.add(btnModifier);
        actions.add(btnSupprimer);
        actions.add(btnRafraichir);

        bas.add(form, BorderLayout.CENTER);
        bas.add(actions, BorderLayout.SOUTH);

        add(bas, BorderLayout.SOUTH);
    }

    // API pour le contrôleur
    public void setTableData(Object[][] rows) {
        tableModel.setRowCount(0);
        for (Object[] r : rows) tableModel.addRow(r);
    }

    public String getNomSaisi() { return tfNom.getText().trim(); }
    public String getPrenomSaisi() { return tfPrenom.getText().trim(); }

    public void clearForm() {
        tfNom.setText("");
        tfPrenom.setText("");
    }

    public Integer getSelectedId() {
        int row = table.getSelectedRow();
        if (row < 0) return null;
        Object v = tableModel.getValueAt(row, 0);
        return Integer.parseInt(v.toString());
    }

    public void showInfo(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public JButton getBtnAjouter() { return btnAjouter; }
    public JButton getBtnModifier() { return btnModifier; }
    public JButton getBtnSupprimer() { return btnSupprimer; }
    public JButton getBtnRafraichir() { return btnRafraichir; }
	
}
