package libraryUI;

import javax.swing.*;

import java.awt.*;

public class Swing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }

    private static JFrame frame;
    private static JTable table;
    private static LibraryTableModel model;

    public Swing() {
        frame = new JFrame("Library Management Master");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel tableName = new JLabel("Books in stock");
        flow.add(tableName);
        JPanel booksPanel = new JPanel(new BorderLayout());
        booksPanel.add(flow, BorderLayout.NORTH);

        // Create table
        model = new LibraryTableModel();
        table = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane(table);
        booksPanel.add(jScrollPane, BorderLayout.CENTER);

        Listeners listener = new Listeners(frame, table, model);
        // Create buttons
        JPanel southBorder = new JPanel(new BorderLayout());
        JButton getInfoButton = new JButton("Get Author Information");
        southBorder.add(getInfoButton, BorderLayout.EAST);

        JPanel grid = new JPanel(new GridLayout(1, 3, 5, 0));
        JButton addBookButton = new JButton("Add");
        JButton editBookButton = new JButton("Edit");
        JButton deleteBookButton = new JButton("Delete");

        getInfoButton.addActionListener(listener.new GetAuthorInfoListener());

        addBookButton.addActionListener(listener.new AddBookListener());

        editBookButton.addActionListener(listener.new EditBookListener());

        deleteBookButton.addActionListener(listener.new DeleteBookListener());

        grid.add(addBookButton);
        grid.add(editBookButton);
        grid.add(deleteBookButton);

        southBorder.add(grid, BorderLayout.WEST);
        booksPanel.add(southBorder, BorderLayout.SOUTH);
        tabbedPane.addTab("Books", booksPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

}
