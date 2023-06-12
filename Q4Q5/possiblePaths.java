package Q4Q5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class possiblePaths {
    public static List<List<Integer>> bestPaths(HashMap<Integer, List<Integer>> graph, int startNode, int enemyBase){
        Queue<List<Integer>> queue = new LinkedList<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        HashMap<Integer, List<List<Integer>>> bestPaths = new HashMap<>();

        queue.add(new ArrayList<>(List.of(startNode)));
        distances.put(startNode, 0);
        bestPaths.put(startNode, new ArrayList<>(Arrays.asList(Arrays.asList(startNode))));

        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int currentNode = path.get(path.size() - 1);

            if(currentNode == enemyBase){
                continue;
            }
            int currentDistance = distances.get(currentNode);
            List<Integer> adjacentNodes = graph.getOrDefault(currentNode,new ArrayList<>());
            for(int node : adjacentNodes){
                int newDistance = currentDistance + 1;
                if(!distances.containsKey(node) || newDistance < distances.get(node)){
                    distances.put(node, newDistance);
                    List<List<Integer>> newPaths = new ArrayList<>();
                    for(List<Integer> bestPath : bestPaths.get(currentNode)){
                        List<Integer> newPath = new ArrayList<>(bestPath);
                        newPath.add(node);
                        newPaths.add(newPath);
                    }
                    bestPaths.put(node,newPaths);
                    queue.add(newPaths.get(0));
                }
                else if(newDistance == distances.get(node)){
                    for(List<Integer> bestPath : bestPaths.get(currentNode)){
                        List<Integer> newPath = new ArrayList<>(bestPath);
                        newPath.add(node);
                        bestPaths.get(node).add(newPath);
                        queue.add(newPath);
                    }
                }
            }
            //return bestPaths.getOrDefault(enemyBase, new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> paths = bestPaths.getOrDefault(enemyBase,new ArrayList<>());
        for (List<Integer> path : paths){
            if(path.get(path.size() - 1) == enemyBase){
                result.add(path);
            }
        }
        return result;
    }

    private static String pathToString(List<Integer> path){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.size(); i++){
            if (i > 0){
                sb.append(" -> ");
            }
            sb.append(path.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2,3, 6, 10));
        graph.put(2, List.of(4));
        graph.put(3, List.of(4,7));
        graph.put(4, List.of(5));
        graph.put(5, List.of(6,7));
        graph.put(6, List.of(7,8));
        graph.put(7, List.of(8,9));
        graph.put(8, List.of(9,10));
        graph.put(9, List.of(10));

        //set starting node & enemy base camp
        int startNode = 1;
        System.out.print("Enter the base camp for the enemy base camp: ");
        int enemyBase = sc.nextInt();

        List<List<Integer>> paths = bestPaths(graph,startNode,enemyBase);

        //output (best paths)
        System.out.println("Best path(s): ");
        for (List<Integer> path : paths){
            System.out.println(pathToString(path));
        }
    }

}

