package Data_Structure_Assignment;

import java.util.*;
import java.lang.*;

class General  implements Comparable<General>  {

    private String name;
    private String armyType;
    private int strength;
    private int leadership;
    private int intelligence;
    private int politic;
    private int hitPoint;
    private General left;
    private General right;

    // Constructor
    public General(String name, String armyType, int strength, int leadership, int intelligence, int politic, int hitPoint) {
        this.name = name;
        this.armyType = armyType;
        this.strength = strength;
        this.leadership = leadership;
        this.intelligence = intelligence;
        this.politic = politic;
        this.hitPoint = hitPoint;
        this.left = null;
        this.right = null;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getArmyType() {
        return armyType;
    }

    public int getStrength() {
        return strength;
    }

    public int getLeadership() {
        return leadership;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getPolitics() {
        return politic;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public General getLeft() {
        return left;
    }

    public General getRight() {
        return right;
    }

    // Setters
    public void setLeft(General left) {
        this.left = left;
    }

    public void setRight(General right) {
        this.right = right;
    }

    public int getAbilitySum() {
        return politic + leadership + strength + intelligence;
    }

    @Override
    public int compareTo(General other) {
        return Integer.compare(this.leadership, other.leadership);
    }


}

class TreeNode {
    private General general;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(General general) {
        this.general = general;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public General getGeneral() {
        return general;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void displayTree() {
        displayNode(this, "");
    }

    private void displayNode(TreeNode node, String indent) {
        General gen = node.getGeneral();
        System.out.println(indent + gen.getName() + " (" + gen.getArmyType() + ")");
        for (TreeNode child : node.getChildren()) {
            displayNode(child, indent + "  ");
        }
    }

    // Binary search to find a general with specific ability

}


