package Data_Structure_Assignment;

public class vertex<T extends Comparable<T>, N extends Comparable <N>>{
    T vertexinfo;
    int indeg;
    int outdeg;
    int size;
    vertex<T,N> nextvertex;
    edge<T,N> firstedge;

    public vertex(){
        vertexinfo = null;
        indeg = 0;
        outdeg = 0;
        nextvertex = null;
        firstedge = null;
    }

    public vertex(T vertexinfo, vertex<T,N> next){
        this.vertexinfo = vertexinfo;
        indeg = 0;
        outdeg = 0;
        nextvertex = next;
        firstedge = null;
    }

}
class edge<T extends Comparable<T>,N extends Comparable<N>>{
    vertex<T,N> toVertex;
    N weight;
    edge<T,N> nextedge;

    public edge(){
        toVertex = null;
        weight = null;
        nextedge = null;
    }

    public edge(vertex<T,N> destination, N w, edge<T,N> a){
        toVertex = destination;
        weight = w;
        nextedge = a;
    }
}