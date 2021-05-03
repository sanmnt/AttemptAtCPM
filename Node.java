//   This is the Node Class Used Above
package ProgrammingAssignment4;

import java.util.ArrayList;

public class Node
{
    private boolean removed = false;
    private boolean isFirst = false;
    private String name;
    private int time=0;
    private int ES=0;
    private int LS=0;
    private int EF=0;
    private int LF=0;
    private ArrayList<Node> parent;
    private ArrayList<Node> child = new ArrayList<>();
    public int tempES;
    public int tempLF;

    public Node(String name, ArrayList<Node> parent, int time)
    {
        this.time= time;
        this.parent = parent;
        this.isFirst = parent.isEmpty();
        this.name = name;
        if (isFirst) {
            ES = 0;
            EF=time;
        }

    }
    public Node()
    {
        time = 0;
        ES = 0;
        EF = 0;
        LS = 0;
        EF = 0;
        isFirst = false;
        name = null;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getES() {
        return ES;
    }

    public void setES(int ES) {
        this.ES = ES;
    }

    public int getLS() {
        return LS;
    }

    public void setLS(int LS) {
        this.LS = LS;
    }

    public int getEF() {
        return EF;
    }

    public void setEF(int EF) {
        this.EF = EF;
    }

    public int getLF() {
        return LF;
    }

    public void setLF(int LF) {
        this.LF = LF;
    }

    public ArrayList<Node> getParent() {
        return parent;
    }

    public void setParent(ArrayList<Node> parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChild() {
        return child;
    }

    public void addChild(Node input){
        child.add(input);
    }
    public void addParent(Node input){
        parent.add(input);
    }

    public void setChild(ArrayList<Node> child) {
        this.child = child;
    }

    public void removeParent(Node removeNode){
        parent.remove(removeNode);
    }
    public void removeChild(Node removeNode){
        child.remove(removeNode);
    }
}

