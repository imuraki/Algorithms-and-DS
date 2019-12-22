import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	
	private Map<String, Node> nodes = new HashMap<>();
	private Map<Node, ArrayList<Node>> adjacencylist = new HashMap<>();
	private Set<Node> visited = new HashSet<>();
	private Set<Node> visitedIterative = new HashSet<>();
	private Stack<Node> stack = new Stack<>();
	private Queue<Node> queue = new LinkedList<>();
	
	private class Node{
		private String label;

		public Node(String label) {
			super();
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
			
	}
	
	void addNode(String label){
		
		Node node = new Node(label);
		
		nodes.putIfAbsent(label, node);
		adjacencylist.putIfAbsent(node, new ArrayList<Node>());
		
	}
	
	void addEdge(String from, String to){
		
		if(nodes.get(from) == null || nodes.get(to) == null)
			throw new IllegalArgumentException();
		
		ArrayList<Node> edges = adjacencylist.get(nodes.get(from));
		
		for(Node x : edges)
			if(x.label.equals(to))
				return;
		
		edges.add(nodes.get(to));
	}
	
	void removeEdge(String from, String to){
		
		if(nodes.get(from) == null || nodes.get(to) == null)
			throw new IllegalArgumentException();
		
		adjacencylist.get(nodes.get(from)).remove(nodes.get(to));
	}
	
	void removeNode(String label){
		
		if(nodes.get(label) == null)
			return;
		
		for(Node edge : adjacencylist.keySet())
			adjacencylist.get(edge).remove(nodes.get(label));
		
		adjacencylist.remove(nodes.get(label));
		nodes.remove(label);
		
	}
	
	void print(){
		
		for(Node source : adjacencylist.keySet())
			System.out.println(source + " is connected with" + adjacencylist.get(source));
			
	}
	
	void traverseDFS(String label){
		
		Node node = nodes.get(label);
		
		if(node == null)
			return;
		
		visited.add(node);
		System.out.println(node);
		
		for(Node edge : adjacencylist.get(node)){
			if(!visited.contains(edge))
				traverseDFS(edge.label);
		}
	
	}
	
	void traverseDFSIterative(String label){
		
		Node n = nodes.get(label);
		
		if(n == null)
			return;
		
		stack.push(n);
		
		while(!stack.empty()){
			Node node = stack.pop();
			
			visitedIterative.add(node);
			System.out.println(node);
			
			for(Node x : adjacencylist.get(node))
				if(!visitedIterative.contains(x))
				stack.push(x);
			
		}
	}
	
	void traverseBFS(String label){
		visited.clear();
		
		Node node = nodes.get(label);
		queue.add(node);
		
		while(!queue.isEmpty()){
			
			Node visitednode = queue.poll();
			System.out.println(visitednode);
			
			for(Node edge : adjacencylist.get(visitednode)){
				if(!visited.contains(edge)){
					visited.add(edge);
					queue.add(edge);
				}
			}
		}
		
	}
	
	boolean detectCyclicGraph(){
		
		Set<Node> visiting = new HashSet<>();
		Set<Node> visited = new HashSet<>();
		
		for(Node node : adjacencylist.keySet())
			if(DCGUtil(node, visiting, visited))
				return true;
		
		return false;
	}
	
	boolean DCGUtil(Node node, Set<Node>visiting, Set<Node>visited){
		
		if(visiting.contains(node))
			return true;
		
		visiting.add(node);
		System.out.println(node);
		
		for(Node edges : adjacencylist.get(node))
			if(!visited.contains(edges)&& DCGUtil(edges,visiting, visited))
				return true;
				
		
		visiting.remove(node);
		visited.add(node);
		return false;
	}
	
	public static void main(String[] argv){
		
		Graph graph = new Graph();
		
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addNode("E");
		graph.addNode("F");
		
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("A", "C");
		graph.addEdge("D", "A");
		graph.addEdge("D", "E");
		graph.addEdge("E", "F");
		graph.addEdge("F", "D");
		
		/*graph.addEdge("A", "B");
		graph.addEdge("A", "E");
		graph.addEdge("B", "E");
		graph.addEdge("C", "A");
		graph.addEdge("C", "B");
		graph.addEdge("C", "D");
		graph.addEdge("D", "E");*/
		
		
		//graph.print();
		//graph.traverseDFS("A");
		//graph.traverseDFSIterative("C");
		/*graph.traverseBFS("C");*/
		System.out.println("" + graph.detectCyclicGraph());
		
	}
}
