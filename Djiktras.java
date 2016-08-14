

class  AdjListNode
{
    int dest;
    int weight;
    AdjListNode next;
    
    public AdjListNode(){
    	
    }
}

class AdjList
{
     AdjListNode head; 
     
     public AdjList(){
    	 
     }
}


public class graph {
	
	int V;
    AdjList array[];
    
     AdjListNode newAdjListNode(int dest, int weight)
     {
         	AdjListNode newNode = new AdjListNode(); 
	        newNode.dest = dest;
	        newNode.weight = weight;
	        newNode.next = null;
	        return newNode;
     }
     
      graph createGraph(int V)
      {
         graph graph = new graph();
         graph.V = V;
      
         // Create an array of adjacency lists.  Size of array will be V
         graph.array = new AdjList[V];
         for(int i=0;i<graph.array.length;i++)
        	 graph.array[i] = new AdjList();
      
          // Initialize each adjacency list as empty by making head as NULL
         for (int i = 0; i<V; ++i)
             graph.array[i].head = null;
      
         return graph;
      }
      
      void addEdge( graph graph, int src, int dest, int weight)
      {
          // Add an edge from src to dest.  A new node is added to the adjacency
          // list of src.  The node is added at the begining
           AdjListNode newNode = newAdjListNode(dest, weight);
           newNode.next = graph.array[src].head;
           graph.array[src].head = newNode;
       
          // Since graph is undirected, add an edge from dest to src also
	       newNode = newAdjListNode(src, weight);
	       newNode.next = graph.array[dest].head;
	       graph.array[dest].head = newNode;
      }
      
      class MinHeapNode
      {
          int  v;
          int dist;
          
          public MinHeapNode(){
        	  
          }
      }
       
      // Structure to represent a min heap
      class MinHeap
      {
          int size;      // Number of heap nodes present currently
          int capacity;  // Capacity of min heap
          int pos[];     // This is needed for decreaseKey()
          MinHeapNode array[];
      }
      
      MinHeapNode newMinHeapNode(int v, int dist)
      {
          MinHeapNode minHeapNode = new MinHeapNode();
                 
          minHeapNode.v = v;
          minHeapNode.dist = dist;
          return minHeapNode;
      }
      
      MinHeap createMinHeap(int capacity)
      {
          MinHeap minHeap = new MinHeap();
               
          minHeap.pos = new int[capacity];
          minHeap.size = 0;
          minHeap.capacity = capacity;
          minHeap.array = new MinHeapNode[capacity];
          return minHeap;
      }
       
      // A utility function to swap two nodes of min heap. Needed for min heapify
      void swapMinHeapNode(MinHeapNode a,  MinHeapNode b)
      {
           MinHeapNode t = new MinHeapNode();
           
           t.dist =a.dist;
           t.v =a.v;
           
           a.dist = b.dist;
           a.v = b.v;
           
           b.dist = t.dist;
           b.v = t.v;
      }
      
      
      void minHeapify( MinHeap minHeap, int idx)
      {
          int smallest, left, right;
          smallest = idx;
          left = 2 * idx + 1;
          right = 2 * idx + 2;
       
          if (left < minHeap.size &&
              minHeap.array[left].dist < minHeap.array[smallest].dist )
            smallest = left;
       
          if (right < minHeap.size &&
              minHeap.array[right].dist < minHeap.array[smallest].dist )
            smallest = right;
       
          if (smallest != idx)
          {
              // The nodes to be swapped in min heap
              MinHeapNode smallestNode = minHeap.array[smallest];
              MinHeapNode idxNode = minHeap.array[idx];
       
              // Swap positions
              minHeap.pos[smallestNode.v] = idx;
              minHeap.pos[idxNode.v] = smallest;
       
              // Swap nodes
              swapMinHeapNode(minHeap.array[smallest], minHeap.array[idx]);
       
              minHeapify(minHeap, smallest);
          }
      }
      
      int isEmpty( MinHeap minHeap)
      {
          if (minHeap.size == 0)
        	  return 1;
          else
        	  return 0;
      }
      
      
       MinHeapNode extractMin( MinHeap minHeap)
      {
          if (isEmpty(minHeap)==1)
              return null;
       
          // Store the root node
           MinHeapNode root = minHeap.array[0];
       
          // Replace root node with last node
           MinHeapNode lastNode = minHeap.array[minHeap.size - 1];
           minHeap.array[0] = lastNode;
       
          // Update position of last node
          minHeap.pos[root.v] = minHeap.size-1;
          minHeap.pos[lastNode.v] = 0;
       
          // Reduce heap size and heapify root
          --minHeap.size;
          minHeapify(minHeap, 0);
       
          return root;
      }
       
       void decreaseKey( MinHeap minHeap, int v, int dist)
       {
           // Get the index of v in  heap array
           int i = minHeap.pos[v];
        
           // Get the node and update its dist value
           minHeap.array[i].dist = dist;
        
           // Travel up while the complete tree is not hepified.
           // This is a O(Logn) loop
           while ((i!=0) && minHeap.array[i].dist < minHeap.array[(i - 1) / 2].dist)
           {
               // Swap this node with its parent
               minHeap.pos[minHeap.array[i].v] = (i-1)/2;
               minHeap.pos[minHeap.array[(i-1)/2].v] = i;
               swapMinHeapNode(minHeap.array[i],  minHeap.array[(i - 1) / 2]);
        
               // move to parent index
               i = (i - 1) / 2;
           }
       }
       
       
       boolean isInMinHeap( MinHeap minHeap, int v)
       {
          if (minHeap.pos[v] < minHeap.size)
            return true;
          return false;
       }
        
       // A utility function used to print the solution
       void printArr(int dist[], int n)
       {
           System.out.print("Vertex   Distance from Source\n");
           for (int i = 0; i < n; ++i)
        	   System.out.print( i + "\t \t"+ dist[i]+"\n");
       }
       
       void dijkstra( graph graph, int src)
       {
           int V = graph.V;// Get the number of vertices in graph
           int dist[] = new int[V];      // dist values used to pick minimum weight edge in cut
        
           // minHeap represents set E
            MinHeap minHeap = createMinHeap(V);
        
           // Initialize min heap with all vertices. dist value of all vertices 
           for (int v = 0; v < V; ++v)
           {
               dist[v] = 9999;
               minHeap.array[v] = newMinHeapNode(v, dist[v]);
               minHeap.pos[v] = v;
           }
        
           // Make dist value of src vertex as 0 so that it is extracted first
           minHeap.array[src] = newMinHeapNode(src, dist[src]);
           minHeap.pos[src]   = src;
           dist[src] = 0;
           decreaseKey(minHeap, src, dist[src]);
        
           // Initially size of min heap is equal to V
           minHeap.size = V;
        
           // In the followin loop, min heap contains all nodes
           // whose shortest distance is not yet finalized.
           while (isEmpty(minHeap)!=1)
           {
               // Extract the vertex with minimum distance value
               MinHeapNode minHeapNode = extractMin(minHeap);
               int u = minHeapNode.v; // Store the extracted vertex number
        
               // Traverse through all adjacent vertices of u (the extracted
               // vertex) and update their distance values
               AdjListNode pCrawl = graph.array[u].head;
               while (pCrawl != null)
               {
                   int v = pCrawl.dest;
        
                   // If shortest distance to v is not finalized yet, and distance to v
                   // through u is less than its previously calculated distance
                   if (isInMinHeap(minHeap, v) && dist[u] != 9999 && 
                                                 pCrawl.weight + dist[u] < dist[v])
                   {
                       dist[v] = dist[u] + pCrawl.weight;
        
                       // update distance value in min heap also
                       decreaseKey(minHeap, v, dist[v]);
                   }
                   pCrawl = pCrawl.next;
               }
           }
        
           // print the calculated shortest distances
           printArr(dist, V);
       }
       
       public static void main(String args[]){
    	   
    	   int V = 9;
    	     graph graph = new graph();
    	     graph g = new graph();
    	     g=graph.createGraph(V);
    	     graph.addEdge(g, 0, 1, 4);
    	     graph.addEdge(g, 0, 7, 8);
    	     graph.addEdge(g, 1, 2, 8);
    	     graph.addEdge(g, 1, 7, 11);
    	     graph.addEdge(g, 2, 3, 7);
    	     graph.addEdge(g, 2, 8, 2);
    	     graph.addEdge(g, 2, 5, 4);
    	     graph.addEdge(g, 3, 4, 9);
    	     graph.addEdge(g, 3, 5, 14);
    	     graph.addEdge(g, 4, 5, 10);
    	     graph.addEdge(g, 5, 6, 2);
    	     graph.addEdge(g, 6, 7, 1);
    	     graph.addEdge(g, 6, 8, 6);
    	     graph.addEdge(g, 7, 8, 7);
    	 
    	     graph.dijkstra(g, 7);
       }
        
        

}
