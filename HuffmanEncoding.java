class MinHeapNode
{
    char data;  // One of the input characters
    int freq;  // Frequency of the character
    MinHeapNode left, right; // Left and right child of this node
    
    public MinHeapNode() {
		// TODO Auto-generated constructor stub
    	left = null;
    	right =null;
    	//data = '\t';
    	freq = -1;
	}
}
public class MinHeap {

	int size;    // Current size of min heap
    int capacity;   // capacity of min heap
    MinHeapNode [] array; 
    
    public MinHeap() {
		// TODO Auto-generated constructor stub
    	array = null;
    	size = -1;
    	capacity = -1;
	}
    
    static MinHeapNode newNode(char data, int freq)
    {
        MinHeapNode temp = new MinHeapNode();
        temp.left = temp.right = null;
        temp.data = data;
        temp.freq = freq;
        return temp;
    }
    
    static MinHeap createMinHeap(int capacity)
    {
         MinHeap minHeap = new MinHeap();
         minHeap.size = 0;  // current size is 0
         minHeap.capacity = capacity;
         minHeap.array =new MinHeapNode [capacity];
        
        return minHeap;
    }
    
    static void swapMinHeapNode(MinHeapNode a,  MinHeapNode b)
    {
        MinHeapNode t = new MinHeapNode();
        
        t.data = a.data;
        t.freq = a.freq;
        t.left = a.left;
        t.right = a.right;
        
        
        
        a.data = b.data;
        a.freq = b.freq;
        a.left = b.left;
        a.right = b.right;
        
        
        
        b.data = t.data;
        b.freq = t.freq;
        b.left = t.left;
        b.right = t.right;
    }
    
    static void minHeapify(MinHeap minHeap, int idx)
    {
        int smallest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
     
        if ((left < minHeap.size) &&
            (minHeap.array[left].freq < minHeap.array[smallest].freq))
          smallest = left;
     
        if ((right < minHeap.size) &&
            (minHeap.array[right].freq < minHeap.array[smallest].freq))
          smallest = right;
     
        if (smallest != idx)
        {
            swapMinHeapNode(minHeap.array[smallest], minHeap.array[idx]);
            minHeapify(minHeap, smallest);
        }
    }
    
    static int isSizeOne(MinHeap minHeap)
    {
        if(minHeap.size == 1)
        	return 1;
        else
        	return 0;
    }
    
    static MinHeapNode extractMin( MinHeap minHeap)
    {
         MinHeapNode temp = new MinHeapNode();
         temp = minHeap.array[0];
        minHeap.array[0] = minHeap.array[minHeap.size - 1];
        --minHeap.size;
        minHeapify(minHeap, 0);
        return temp;
    }
     
     static void insertMinHeap( MinHeap minHeap,  MinHeapNode minHeapNode)
     {
         ++minHeap.size;
         int i = minHeap.size - 1;
         while ((i!=0) && (minHeapNode.freq < minHeap.array[(i - 1)/2].freq))
         {
             minHeap.array[i] = minHeap.array[(i - 1)/2];
             i = (i - 1)/2;
         }
         minHeap.array[i] = minHeapNode;
     }
     
     
     static void buildMinHeap( MinHeap minHeap)
     {
         int n = minHeap.size - 1;
         int i;
         for (i = (n - 1) / 2; i >= 0; --i)
             minHeapify(minHeap, i);
     }
     
     static void printArr(int arr[], int n)
     {
         int i;
         for (i = 0; i < n; ++i)
             System.out.print( arr[i]);
         System.out.println();
         
     }
     
     static int isLeaf( MinHeapNode root)
     {
          if((root.left ==null) && (root.right==null))
        	  return 1;
          else
        	  return 0;
     }
     
     static MinHeap createAndBuildMinHeap(char data[], int freq[], int size)
     {
         MinHeap minHeap = new MinHeap();
         minHeap = createMinHeap(size);
         for (int i = 0; i < size; ++i)
             minHeap.array[i] = newNode(data[i], freq[i]);
         minHeap.size = size;
         buildMinHeap(minHeap);
         return minHeap;
     }
      
      static MinHeapNode buildHuffmanTree(char data[], int freq[], int size)
      {
           MinHeapNode left, right, top;
           left = new MinHeapNode();
           right = new MinHeapNode();
           top = new MinHeapNode();
       
          
           MinHeap minHeap = new MinHeap();
           minHeap = createAndBuildMinHeap(data, freq, size);
       
          
          while (isSizeOne(minHeap)!=1)
          {
              
              left = extractMin(minHeap);
              right = extractMin(minHeap);
       
              
              top = newNode('$', left.freq + right.freq);
              top.left = left;
              top.right = right;
              insertMinHeap(minHeap, top);
          }
       
          
          return extractMin(minHeap);
      }
       
       
       static void printCodes( MinHeapNode root, int arr[], int top)
       {
           
           if (root.left!=null)
           {
               arr[top] = 0;
               printCodes(root.left, arr, top + 1);
           }
        
           
           if (root.right!=null)
           {
               arr[top] = 1;
               printCodes(root.right, arr, top + 1);
           }
        
           
           if (isLeaf(root)==1)
           {
               System.out.print(root.data +":");
               printArr(arr, top);
           }
       }
       
       
       static void HuffmanCodes(char data[], int freq[], int size)
       {
          
           MinHeapNode root = new MinHeapNode();
           root = buildHuffmanTree(data, freq, size);
        
          
          int arr[]= new int[100];int top = 0;
          printCodes(root, arr, top);
       }
       
       public static void main (String args[]){

    	    char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
    	    int freq[] = {5, 9, 12, 13, 16, 45};
    	    int size = arr.length;
    	    HuffmanCodes(arr, freq, size);
    	    
       }
       
}
