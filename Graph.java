import java.awt.*;
import java.util.*;

class Graph
{
    int vNum;
    LinkedList<Integer>[] adjList;


    public Graph()
    {
        vNum = 0;
    }

    public void SetNumVertices(int n)
    {
        vNum = n; //set up number of vertices
        adjList = new LinkedList[n];
        for(int i=0; i<adjList.length; i++) { //initializing a linkedList for each index
            adjList[i] = new LinkedList<Integer>();
        }

    }

    public void AddEdge(int u, int v)
    {
        //add the edges both ways since we are working with undirected graphs.
        adjList[u].add(v);
        //TODO: think about why...
        //adjList[v].add(u); // didn't have to do this... why...
    }

    public boolean IsConnected()
    {   
        for(int i=0; i<adjList.length; i++) {

            if(BFS(i)){
                System.out.println("pass");
            }
            else {
                System.out.println("no");
                return false;
            }
        }
        return true;
    }

    public boolean BFS (Integer vertex) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[adjList.length];

        //adding count,vertex,and boolean for the starting point.
        int count = 1;
        queue.add(vertex);
        visited[vertex] = true;


        while (queue.size() != 0) {
            vertex = queue.remove();
            Iterator<Integer> iterator = adjList[vertex].listIterator();

            while(iterator.hasNext()) {
                int n = iterator.next();
                if(visited[n]==false) {
                    visited[n] = true;
                    queue.add(n);
                    count++;
                }
            }
        }
        //check if the count equals the length.
        return (count == vNum);
    }


    public boolean IsCycle()
    {
        //check each vertex, does it ahve 2 neighbors
        for(int i=0; i < vNum; i++) {
            System.out.println(vNum);
            System.out.println(Arrays.toString(adjList[i].toArray()));
            if(adjList[i].size() != 2) {
                return false;
            }
        }
        return true;
    }


}
