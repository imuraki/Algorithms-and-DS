import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class WeightedGraph {

    private Map<String, Node> nodes = new HashMap<>();

    class Node{
        String label;
        ArrayList<Edge> edges;
        public Node(String label) {
            this.label = label;
            edges = new ArrayList<>();
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(to, weight));
        }

        @Override
        public String toString() {
            return label;
        }
    }

    class Edge{
        Node to;
        int weight;

        public Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    class NodeEntry{
        Node node;
        int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    void addEdge(String from, String to, int weight ){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        for(Edge edge : fromNode.edges){
            if(edge.to.label.equals(to))
                return;
        }

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    void print(){
        for(Node n : nodes.values())
            if(!n.edges.isEmpty())
                System.out.println(n+" is connected to " + n.edges);

    }

    int getShortestPath(String from, String to){
        Map<Node, Integer>distances = new HashMap<>();
        Map<Node, Node>path = new HashMap<>();
        Set<Node>visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(ne -> ne.priority));
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        for(Node node : nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
            path.put(node, null);
        }

        distances.replace(fromNode, 0);
        queue.add(new NodeEntry(fromNode, 0));
        visited.add(fromNode);

        while (!queue.isEmpty()){
            Node node = queue.remove().node;
            visited.add(node);

            for(Edge edge : node.edges){
                if(visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(node) + edge.weight;
                if(newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    path.replace(edge.to, node);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }

            }

        }
        System.out.println(printpath(path, fromNode, toNode));
        return distances.get(toNode);
    }

    String printpath(Map<Node, Node>path, Node fromNode, Node toNode){
        if(fromNode == toNode)
            return fromNode.toString();

        return printpath(path, fromNode, path.get(toNode)) + "--> " + toNode;

    }

    boolean hasCycle(){
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        for(Node node :  nodes.values())
            if(!visited.contains(node) && hasCycleUtil(node, null, visiting, visited))
                return true;

        return false;
    }

    boolean hasCycleUtil(Node node, Node parent, Set<Node>visiting, Set<Node>visited){

        if(visiting.contains(node))
            return true;

        System.out.println(node);
        visiting.add(node);

        for(Edge edge : node.edges){
            if(!visited.contains(edge.to) && edge.to != parent && hasCycleUtil(edge.to, node, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

    String printMinimumSpanningTree(){
        Node node = nodes.get("A");
        PriorityQueue<NodeEntry> queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(node, 0));

        Set<Node>visited = new HashSet<>();

        StringBuffer sb = new StringBuffer();

        while (visited.size() < nodes.size()){
            Node n = queue.remove().node;
            sb.append("-->").append(n);
            visited.add(node);

            for(Edge edge : node.edges){
                if(!visited.contains(edge.to))
                    queue.add(new NodeEntry(edge.to, edge.weight));
            }
        }

        return sb.toString();
    }

/*    void removeNode(String label){

        if(nodes.get(label) == null)
            return;

        for(Node node : nodes.values())
            for(Edge edge : node.edges){
                if()
            }

        nodes.remove(label);

    }

    void removeEdge(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.edges.remove();
        toNode.edges.remove(fromNode);


    }*/



}
