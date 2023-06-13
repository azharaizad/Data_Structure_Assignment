package Q1Q2;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class TreeGUI extends JFrame {
    private JTree tree;

    public TreeGUI(DefaultMutableTreeNode rootNode) {
        super("General Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        tree = new JTree(rootNode);
        JScrollPane scrollPane = new JScrollPane(tree);

        getContentPane().add(scrollPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}