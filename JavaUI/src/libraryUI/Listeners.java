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
                String error = "";
                try {
                    Double.parseDouble(priceText.getText());
                } catch (NumberFormatException ex) {
                    error += ("Wrong price (should be double): " + priceText.getText() + '\n');
                }
                try {
                    Double.parseDouble(countText.getText());
                } catch (NumberFormatException ex) {
                    error += ("Wrong book's count (should be double): " + countText.getText());
                }
                if (!(error.equals("")))
                    JOptionPane.showMessageDialog(dialog, "Wrong field types: \n" + error);
                else {
                    Book addingBook = new Book(nameText.getText(), new Author(nameAuthorText.getText(),
                            emailText.getText(), getChoosedGender()), Double.parseDouble(priceText.getText()),
                            Integer.parseInt(countText.getText()));
                    model.addBook(addingBook);
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
                int row = table.getSelectedRow();
                String error = "";
                try {
                    Double.parseDouble(priceText.getText());
                } catch (NumberFormatException ex) {
                    error += ("Wrong price (should be double): " + priceText.getText() + '\n');
                }
                try {
                    Double.parseDouble(countText.getText());
                } catch (NumberFormatException ex) {
                    error += ("Wrong book's count (should be double): " + countText.getText());
                }
                if (!(error.equals("")))
                    JOptionPane.showMessageDialog(dialog, "Wrong field types: \n" + error);
                else {
                    Book newBook = new Book(nameText.getText(), new Author(nameAuthorText.getText(),
                            emailText.getText(), getChoosedGender()), Double.parseDouble(priceText.getText()),
                            Integer.parseInt(countText.getText()));
                    model.editBook(row, newBook);
                    dialog.setVisible(false);
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
                dialog.setSize(350, 190);
                dialog.setLocationRelativeTo(frame);
                dialog.setLayout(new BorderLayout());

                JPanel panel = new JPanel();
                GridBagLayout gbl = new GridBagLayout();
                GridBagConstraints c = new GridBagConstraints();
                panel.setLayout(gbl);
                c.anchor = GridBagConstraints.NORTHWEST;
                c.gridheight = 1;
                c.gridwidth = GridBagConstraints.REMAINDER;
                c.gridx = GridBagConstraints.RELATIVE;
                c.gridy = GridBagConstraints.RELATIVE;
                c.insets = new Insets(6, 6, 6, 6);
                JLabel lblSlct = new JLabel("You have selected:  " + table.getValueAt(table.getSelectedRow(), 0));
                JLabel lblInstck = new JLabel("In stock:  " + table.getValueAt(table.getSelectedRow(), 3) + " book(s)");
                JLabel lblQuestion = new JLabel("How many books you want to delete: ");
                JSpinner spinnerAmount = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
                spinnerAmount.getEditor().setPreferredSize(new Dimension(30, 15));
                ((JSpinner.DefaultEditor) spinnerAmount.getEditor()).getTextField().setBackground(Color.WHITE);
                gbl.setConstraints(lblSlct, c);
                gbl.setConstraints(lblInstck, c);
                gbl.setConstraints(lblQuestion, c);
                gbl.setConstraints(spinnerAmount, c);

                panel.add(lblSlct);
                panel.add(lblInstck);
                panel.add(lblQuestion);
                panel.add(spinnerAmount);
                JButton deleteBtn = new JButton("Delete");
                deleteBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = table.getSelectedRow();
                        String bookName = (String) table.getValueAt(row, 0);
                        int deleteAmount = Integer.parseInt(((JSpinner.DefaultEditor) spinnerAmount.getEditor()).getTextField().getText());
                        int currentAmount = (int) table.getValueAt(row, 3);
                        if (deleteAmount <= currentAmount) {
                            model.deleteBook(row, deleteAmount);
                            currentAmount -= deleteAmount;
                            if (currentAmount == 0) {
                                JOptionPane.showMessageDialog(dialog, bookName + " is out of stock now");
                            } else {
                                JOptionPane.showMessageDialog(dialog, "Now in stock: " +
                                        currentAmount + " book(s)");
                            }
                            dialog.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(dialog, "Invalid amount\nShould not be more than " +
                                    table.getValueAt(row, 3));
                        }
                    }
                });
                gbl.setConstraints(deleteBtn, c);
                panel.add(deleteBtn);
                dialog.add(panel, BorderLayout.WEST);
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
