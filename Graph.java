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
        //TODO: think about why...
        //adjList[v].add(u); // didn't have to do this... why...
    }

    public boolean IsConnected()
    {
        System.out.println(adjList.length);


        if(BFS(0)){
            System.out.println(0);
            System.out.println("pass");
        }
        else {
            System.out.println("no");
            return false;
        }
        return true;
    }

    public boolean BFS (Integer vertice) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[adjList.length];

        //adding count,vertex,and boolean for the starting point.
        int count = 1;
        int n; //next vertice in a list
        queue.add(vertice);
        visited[vertice] = true;


        Iterator<Integer> iterator;
        while (!queue.isEmpty()) {
            vertice = queue.remove();
            iterator = adjList[vertice].iterator();

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
