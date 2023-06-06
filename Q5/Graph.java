package Data_Structure_Assignment.Q5;

import java.util.ArrayList;

public class Graph <T extends Comparable<T>,N extends Comparable<N>>{

    Vertex<Location,Integer> head;
    int size;
    public Graph(){
        head=null;
        size=0;
    }

    public boolean hasvertex(Location vertex){
        if(head==null){return false;}
        Vertex<Location,Integer> temp=head;
        while(temp!=null){
            if(temp.vertexname.equals(vertex)){return true;}
            temp=temp.nextvertex;
        }
        return false;
    }

    public boolean  addvertex(Location vertex){
        if(hasvertex(vertex)==false){
            Vertex<Location,Integer> temp=head;
            Vertex<Location,Integer> newvertex=new Vertex<>(vertex,null);
            if(head==null) {head=newvertex;}
            else{
                Vertex<Location,Integer> prev=head;
                while(temp!=null){
                    prev=temp;
                    temp=temp.nextvertex;
                }
                prev.nextvertex=newvertex;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean hasedge(Location fromvertex, Location towardvertex) {
        if (head == null) {return false;}
        if (!hasvertex(fromvertex) || !hasvertex(towardvertex)) {return false;}
        Vertex<Location,Integer> temp=head;
        while (temp!=null){
            if(temp.vertexname.compareTo(fromvertex)==0){
                Edge<Location,Integer> currentedge=temp.edges;
                while (currentedge!=null){
                    if(currentedge.tovertex.vertexname.compareTo(towardvertex)==0){return true;}
                    currentedge=currentedge.nextedges;
                }
            }
            temp=temp.nextvertex;
        }
        return false;
    }

    public boolean addedge(Location fromvertex, Location tovertex, Integer weight){
        if (head == null) {return false;}
        if (!hasvertex(fromvertex) || !hasvertex(tovertex)) {return false;}
        Vertex<Location,Integer> from=head;
        while(from!=null){
            if(from.vertexname.compareTo(fromvertex)==0){
                Vertex<Location,Integer> to=head;
                while(to!=null){
                    if (to.vertexname.compareTo(tovertex)==0){
                        Edge<Location,Integer> currentedge=from.edges;
                        Edge<Location,Integer> newEdges=new Edge<>(to,weight,currentedge);
                        from.edges=newEdges;
                        return true;
                    }
                    to=to.nextvertex;
                }
            }
            from=from.nextvertex;
        }
        return false;
    }

    public Integer weightedge(Location fromvertex, Location tovertex) {
        if (head == null) {return null;}
        if (!hasvertex(fromvertex) || !hasvertex(tovertex)) {return null;}
        Vertex<Location,Integer> temp=head;
        while (temp!=null){
            if(temp.vertexname.compareTo(fromvertex)==0){
                Edge<Location,Integer> currentedge=temp.edges;
                while (currentedge!=null){
                    if(currentedge.tovertex.vertexname.compareTo(tovertex)==0){return currentedge.weight;}
                    currentedge=currentedge.nextedges;
                }
            }
            temp=temp.nextvertex;
        }
        return null;
    }

    public void printgraph(){
        Vertex<Location,Integer> temp=head;
        while(temp!=null){
            System.out.print("vertex "+temp.vertexname.getLocationname()+" -->");
            Edge<Location,Integer> currentedge=temp.edges;
            while(currentedge!=null){
                System.out.print(" "+currentedge.tovertex.vertexname.getLocationname()+" -->");
                currentedge=currentedge.nextedges;
            }
            System.out.println();
            temp=temp.nextvertex;
        }
    }
}

class Vertex<T extends Comparable<T>,N extends Comparable<N>>{
    T vertexname;
    Vertex<T,N> nextvertex;
    Edge<T,N> edges;

    public Vertex(){
        vertexname=null;
        nextvertex=null;
        edges=null;
    }
    public Vertex(T vertexname,Vertex<T,N> nextvertex){
        this.vertexname=vertexname;
        this.nextvertex=nextvertex;
        edges=null;
    }

}

class Edge <T extends Comparable<T>,N extends Comparable<N>>{
    Vertex<T,N> tovertex;
    N weight;
    Edge<T,N> nextedges;

    public Edge(){
        tovertex=null;
        weight=null;
        nextedges=null;
    }

    public Edge(Vertex<T,N> tovertex,N weight,Edge<T,N> nextedges){
        this.tovertex=tovertex;
        this.weight=weight;
        this.nextedges=nextedges;
    }
}
