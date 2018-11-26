package libraryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners {

    private JFrame frame;
    private JDialog dialog;
    private JTextField nameText;
    private JTextField priceText;
    private JTextField countText;
    private JTextField nameAuthorText;
    private JTextField emailText;
    private JButton acceptButton;
    private JTable table;
    private LibraryTableModel model;
    private JRadioButton genderRBtnMale;
    private JRadioButton genderRBtnFemale;

    public Listeners(JFrame frame, JTable table, LibraryTableModel model) {
        this.frame = frame;
        this.table = table;
        this.model = model;
    }

    private class AddAcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameText.getText().isEmpty() ||
                    priceText.getText().isEmpty() ||
                    countText.getText().isEmpty() ||
                    nameAuthorText.getText().isEmpty() ||
                    emailText.getText().isEmpty() ||
                    (genderRBtnFemale.isSelected() == false && genderRBtnMale.isSelected() == false)) {
                JOptionPane.showMessageDialog(dialog, "Some fields are empty");
            } else {
                try {
                    Book addingBook = new Book(nameText.getText(), new Author(nameAuthorText.getText(),
                            emailText.getText(), getChoosedGender()), Double.parseDouble(priceText.getText()),
                            Integer.parseInt(countText.getText()));
                    model.addBook(addingBook);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Wrong field type");
                }
            }
        }
    }

    private class EditAcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameText.getText().isEmpty() ||
                    priceText.getText().isEmpty() ||
                    countText.getText().isEmpty() ||
                    nameAuthorText.getText().isEmpty() ||
                    emailText.getText().isEmpty() ||
                    (genderRBtnFemale.isSelected() == false && genderRBtnMale.isSelected() == false)) {
                JOptionPane.showMessageDialog(dialog, "Some fields are empty");

            } else {
                try {
                    int row = table.getSelectedRow();
                    Book newBook = new Book(nameText.getText(), new Author(nameAuthorText.getText(),
                            emailText.getText(), getChoosedGender()), Double.parseDouble(priceText.getText()),
                            Integer.parseInt(countText.getText()));
                    model.editBook(row, newBook);
                    dialog.setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Wrong field type");
                }
            }
        }
    }

    public class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog = new JDialog(frame, "Add a book", true);
            makeBookDialog(dialog);
        }
    }

    public class EditBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            if (row != -1) {
                dialog = new JDialog(frame, "Edit book", true);
                makeBookDialog(dialog);
            }
        }
    }

    public class DeleteBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.getSelectedRow() != -1) {
                JDialog dialog = new JDialog(frame, "Delete", true);
                dialog.setResizable(false);
                dialog.setSize(360, 100);
                dialog.setLocationRelativeTo(frame);

                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel lblQuestion = new JLabel("How many books you want to delete: ");
                panel.add(lblQuestion);
                JTextField deleteAmount = new JTextField(10);
                panel.add(deleteAmount);
                JButton deleteBtn = new JButton("Delete");
                deleteBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (Integer.parseInt(deleteAmount.getText()) <= (Integer) table.getValueAt(table.getSelectedRow(), 3)) {
                                model.deleteBook(table.getSelectedRow(), Integer.parseInt(deleteAmount.getText()));
                                dialog.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(dialog, "Invalid amount");
                            }
                        }
                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(dialog, "Wrong field type");
                        }
                    }
                });
                panel.add(deleteBtn);
                dialog.add(panel);
                panel.setVisible(true);
                dialog.setVisible(true);
            }
        }
    }

    public class GetAuthorInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.getSelectedRow() != -1) {
                int row = table.getSelectedRow();
                JDialog dialog = new JDialog(frame, "Info", true);
                dialog.setSize(200, 120);
                dialog.setLocationRelativeTo(frame);
                dialog.setResizable(false);

                JLabel lblName = new JLabel("Name: " + model.getAuthorInfo(row).getName());
                JLabel lblEmail = new JLabel("E-mail: " + model.getAuthorInfo(row).getEmail());
                JLabel lblGender = new JLabel("Gender: " + model.getAuthorInfo(row).getGender() +
                        ((model.getAuthorInfo(row).getGender() == 'F') ? "emale" : "ale"));

                JPanel panel = new JPanel(new GridLayout(3, 1, 0, 5));
                panel.add(lblName);
                panel.add(lblEmail);
                panel.add(lblGender);
                panel.setVisible(true);
                dialog.add(panel);
                dialog.setVisible(true);
            }
        }
    }

    private void makeBookDialog(JDialog dialog) {
        JPanel dPanel = new JPanel(new BorderLayout());
        dialog.setSize(500, 200);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);

        // Creating left panel
        JPanel addBookPanel = new JPanel();
        addBookPanel.setSize(120, 100);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        addBookPanel.setLayout(gbl);

        JLabel lblBookInfo = new JLabel("Book info");
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.REMAINDER;

        gbl.setConstraints(lblBookInfo, c);
        addBookPanel.add(lblBookInfo);

        JLabel lblBookName = new JLabel("Name of Book: ");
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 10, 0, 10);
        gbl.setConstraints(lblBookName, c);
        addBookPanel.add(lblBookName);

        nameText = new JTextField(10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(nameText, c);
        addBookPanel.add(nameText);

        JLabel lblPrice = new JLabel("Price: ");
        c.gridwidth = 1;
        gbl.setConstraints(lblPrice, c);
        addBookPanel.add(lblPrice);
        priceText = new JTextField(10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(priceText, c);
        addBookPanel.add(priceText);

        JLabel lblCount = new JLabel("Count: ");
        c.gridwidth = 1;
        gbl.setConstraints(lblCount, c);
        addBookPanel.add(lblCount);

        countText = new JTextField(10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(countText, c);
        addBookPanel.add(countText);

        dPanel.add(addBookPanel, BorderLayout.WEST);
        addBookPanel.setVisible(true);

        // Creating right panel
        JPanel addAuthorPanel = new JPanel();
        addAuthorPanel.setSize(120, 100);
        addAuthorPanel.setLayout(gbl);

        JLabel lblAuthorInfo = new JLabel("Author info");
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gbl.setConstraints(lblAuthorInfo, c);
        addAuthorPanel.add(lblAuthorInfo);

        JLabel lblAuthorName = new JLabel("Author name: ");
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 10, 0, 10);
        gbl.setConstraints(lblAuthorName, c);
        addAuthorPanel.add(lblAuthorName);

        nameAuthorText = new JTextField(10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(nameAuthorText, c);
        addAuthorPanel.add(nameAuthorText);

        JLabel lblEmail = new JLabel("E-mail: ");
        c.gridwidth = 1;
        gbl.setConstraints(lblEmail, c);
        addAuthorPanel.add(lblEmail);
        emailText = new JTextField(10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(emailText, c);
        addAuthorPanel.add(emailText);

        JLabel lblGender = new JLabel("Gender: ");
        c.gridwidth = 1;
        gbl.setConstraints(lblGender, c);
        addAuthorPanel.add(lblGender);

        ButtonGroup genderRBtnGroup = new ButtonGroup();
        genderRBtnMale = new JRadioButton("Male");
        c.insets = new Insets(7, 7, 0, 10);
        genderRBtnGroup.add(genderRBtnMale);
        gbl.setConstraints(genderRBtnMale, c);
        addAuthorPanel.add(genderRBtnMale);

        genderRBtnFemale = new JRadioButton("Female");
        c.gridwidth = GridBagConstraints.REMAINDER;
        genderRBtnGroup.add(genderRBtnFemale);
        gbl.setConstraints(genderRBtnFemale, c);
        addAuthorPanel.add(genderRBtnFemale);


        dPanel.add(addAuthorPanel, BorderLayout.EAST);
        addAuthorPanel.setVisible(true);
        acceptButton = new JButton("OK");
        dPanel.add(acceptButton, BorderLayout.SOUTH);

        ActionListener listener;
        if (dialog.getTitle().equals("Add a book")) listener = new AddAcceptListener();
        else {
            editFilledFields(table.getSelectedRow());
            listener = new EditAcceptListener();
        }
        acceptButton.addActionListener(listener);
        dialog.add(dPanel);
        dialog.setVisible(true);
    }

    private char getChoosedGender() {
        char gender = 0;
        if (genderRBtnFemale.isSelected()) gender = genderRBtnFemale.getText().charAt(0);
        if (genderRBtnMale.isSelected()) gender = genderRBtnMale.getText().charAt(0);
        return gender;
    }

    private void editFilledFields(int row) {
        nameText.setText((String) table.getValueAt(row, 0));
        priceText.setText(table.getValueAt(row, 2).toString());
        countText.setText(table.getValueAt(row, 3).toString());
        nameAuthorText.setText(model.getAuthorInfo(row).getName());
        emailText.setText(model.getAuthorInfo(row).getEmail());
        if (model.getAuthorInfo(row).getGender() == 'F') genderRBtnFemale.setSelected(true);
        else genderRBtnMale.setSelected(true);
    }
}

