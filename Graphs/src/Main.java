public class Main {

    public static void main(String[] args) {
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 5);
        graph.addEdge("B", "E", 1);
        graph.addEdge("E", "F", 1);
        graph.addEdge("F", "G", 1);
        //graph.addEdge("G", "D", 1);
        graph.addEdge("D", "C", 1);
        //graph.addEdge("A", "D", 2);
        //graph.addEdge("A", "C", 4);

        System.out.println(graph.getShortestPath("A", "G"));
        graph.print();
        System.out.println(graph.printMinimumSpanningTree());
        System.out.println("Cyclic Graph ? : " + graph.hasCycle());
    }
}
