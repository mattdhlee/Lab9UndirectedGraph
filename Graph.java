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
        if(!adjList[u].contains(v)) {
            adjList[u].add(v);
        }
        if(!adjList[v].contains(u)){
            adjList[v].add(u);
        }
    }

    public boolean IsConnected()
    {

        if(BFS(0)){
        }
        else {
            System.out.println("no");
            return false;
        }
        return true;
    }

    public boolean BFS (Integer vertex) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[adjList.length];

        //adding count,vertex,and boolean for the starting point.
        int count = 1;
        int n; //next vertex in a list
        queue.add(vertex);
        visited[vertex] = true;


        Iterator<Integer> iterator;
        while (!queue.isEmpty()) {
            vertex = queue.remove();
            iterator = adjList[vertex].iterator();

            while(iterator.hasNext()) {
                n = iterator.next();
                if(visited[n] == true || queue.contains(n)) {
                    continue;
                }
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
        //check first property: connectivity
        if(!(IsConnected())){
            return false;
        }

        //check second property: each vertex must have two vertices
        for(int i=0; i < vNum; i++) {
            //System.out.println(i);
            //System.out.println(Arrays.toString(adjList[i].toArray()));
            if(adjList[i].size() != 2) {
                return false;
            }
        }
        return true;
    }


}
