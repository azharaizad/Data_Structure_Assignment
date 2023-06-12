package Data_Structure_Assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Asus
 */
public class foodHarvesting {
    public static void main(String[] args) {
        foodHarvesting graph = new foodHarvesting(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 6);
        graph.addEdge(1, 10);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);
        graph.addEdge(8, 10);
        graph.addEdge(9, 10);
        
        System.out.print("Enter node without food: ");
        Scanner sc = new Scanner(System.in);
        int nodeWOFood = sc.nextInt();

        List<Integer> path = graph.findPath(nodeWOFood);

        System.out.println("Path:");
        for (int node : path) {
            System.out.print(node+"->");
            if(node==path.size()) {
                System.out.print(path.get(0));
                break;
            }
        }
        System.out.println();
    }
   private int nodes;
   private List<Integer>[] adjList;
   
   public foodHarvesting(int nodes){
       this.nodes = nodes;
       adjList = new List[nodes + 1];
       
       for(int i=1; i <= nodes; i++){
           adjList[i] = new ArrayList<>();
       }
   }
   
   public void addEdge(int out, int in){
       adjList[out].add(in);
       adjList[in].add(out);
   }
   
   public List<Integer> findPath (int nodeWOFood){
       List<Integer> path = new ArrayList<>();
       boolean[] visited = new boolean[nodes + 1];
       
       dfs(1,nodeWOFood, visited, path);
       
       path.add(1);
       return path;
   }
   
   private boolean dfs (int currentNode, int nodeWOFood, boolean[] visited, List<Integer> path){
       visited[currentNode] = true;
       path.add(currentNode);
       
       boolean isAllVisited = true;
       for(int i = 2; i <= nodes; i++){
           if(i != nodeWOFood && !visited[i]){
               isAllVisited = false;
               break;
           }
       }
       if(isAllVisited){
           return true;
       }
       for(int adj : adjList[currentNode]) {
            if (!visited[adj]) {
                if (adj == nodeWOFood) {
                    continue;
                }

                if (dfs(adj, nodeWOFood, visited, path)) {
                    return true;
                }
            }
        }

        visited[currentNode] = false;
        path.remove(path.size() - 1);
        return false;
    }
}
