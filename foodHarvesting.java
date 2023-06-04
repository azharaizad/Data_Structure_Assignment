package Data_Structure_Assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author Asus
 */
public class foodHarvesting {
   /* private static List<Integer> path;
    private static boolean[] visited;*/

//set nodes as paths
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2,3, 6, 10));
        graph.put(2, List.of(4));
        graph.put(3, List.of(4,7));
        graph.put(4, List.of(5));
        graph.put(5, List.of(6,7));
        graph.put(6, List.of(7,8));
        graph.put(7, List.of(8,9));
        graph.put(8, List.of(9,10));
        graph.put(9, List.of(10));
        
        //set starting node & node without food
        int startNode = 1;
        System.out.println("Enter node without food: ");
        Scanner sc = new Scanner(System.in);
        int nodeWOFood = sc.nextInt();
        
        List<Integer> path = findPath(graph,startNode, startNode, nodeWOFood);
        
        /*path = new ArrayList<>();
        visited = new boolean[graph.size() + 1];
        
        findPath(graph,startNode,nodeWOFood);*/
        
        System.out.println("Path: ");
        for (int node:path){
            System.out.println(" "+node+" -> ");
        }
        System.out.println("1");
    }
    public static List<Integer> findPath(Map<Integer, List<Integer>> graph, int currentNode, int startNode, int nodeWOFood){
    
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.size() +1];
        
        return findPathDFS(graph, currentNode, startNode,nodeWOFood,path,visited);
    }
    
    //use depth first search
private static List<Integer> findPathDFS(Map<Integer, List<Integer>> graph,int currentNode, int startNode, int nodeWOFood, List<Integer> path, boolean[] visited){
        visited[currentNode] = true;
        
        if (currentNode != startNode && currentNode != nodeWOFood){
            path.add(currentNode);
            if(path.size() == graph.size() && currentNode != nodeWOFood){
                return path;
            }
        }
        List<Integer> adjs = graph.get(currentNode);
        for (int adj : adjs){
            if(!visited[adj]){
                List<Integer> subPath = findPathDFS(graph, adj, startNode, nodeWOFood, path, visited);
                if(subPath != null && subPath.size() == graph.size()){
                    return subPath;
                }   
            }
        }
        visited[currentNode] = false;
        return null;
    }
}
