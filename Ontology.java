

package onto; 

import java.io.*;
import java.util.*;

public class Ontology {
	private static TopicNode _topics;
	private static HashMap<String, TopicNode> _map;
	

	public static void makeTree(String flat) {
		LinkedList<String> flatArray = new LinkedList<String>(Arrays.asList(flat.split(" ")));
		if (flatArray.size() >= 1) {
			_topics = makeTreeHelper(flatArray);
			//System.out.println(_topics.toString());
		}
	}

	private static TopicNode makeTreeHelper(LinkedList<String> arraySoFar) {
		TopicNode treeRoot = new TopicNode(arraySoFar.remove());

		// collect children
		if (arraySoFar.get(0).equals("(")) {
			arraySoFar.remove();
			while (!arraySoFar.get(0).equals(")")) {
				treeRoot.addChild(makeTreeHelper(arraySoFar));
			}
			arraySoFar.remove();
		}

		_map.put(treeRoot.data, treeRoot);
		return treeRoot;
	}

	public static class TopicNode {
	    String data;
	    HashSet<TopicNode> parents;
	    HashSet<TopicNode> children;

	    public TopicNode(String rootData) {
	        this.data = rootData;
	        this.parents = new HashSet<TopicNode>();
	        this.children = new HashSet<TopicNode>();
	    }

	    public void addParent(TopicNode p) {
	    	parents.add(p);
	    }

        public void addChild(TopicNode child) {
			children.add(child);
        	Iterator<TopicNode> iter = child.children.iterator();
        	while (iter.hasNext()) {
        		children.add(iter.next());
        	}

        	addChildHelper(this, child);
        }

        public void addChildHelper(TopicNode parent, TopicNode child) {
        	child.addParent(parent);
        	Iterator<TopicNode> iter = child.children.iterator();
        	while (iter.hasNext()) {
        		addChildHelper(parent, iter.next());
        	}
        }
        
        
	}

	

	public static void main(String args[] ) throws Exception {
		// long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    // line 1			int N
	    int n = Integer.parseInt(reader.readLine());
	    // line 2			
	    _map = new HashMap<String, TopicNode>();
	    makeTree(reader.readLine());
	    
    }
}
