package old.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class WareHouse
{
    static class Graph
    {
        int V;
        Vector<Details>[] adj;

        Graph(int V)
        {
            this.V = V;
            this.adj = new Vector[2 * V];

            for (int i = 0; i < 2 * V; i++)
                this.adj[i] = new Vector<>();
        }

        public void addEdge(int v, int w, int weight)
        {
          adj[v].add(new Details(w, weight));
        }



        private List<Details> getAllVerticesCovered(int vertex) {
            List<Details> detailsList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if(vertex != i) {
                    int data = findShortestPath(i, vertex);
                    if (data != -1)
                        detailsList.add(new Details(i, data));
                    else
                        return Collections.emptyList();
                }
            }
            return detailsList;
        }


        public int findShortestPath(int src, int dest) {
            boolean visited[] = new boolean[V];
            return DFSUtil(src, dest,visited);
        }

        int DFSUtil(int v,int w,boolean visited[])
        {
            if(v == w)
                return 1;
            visited[v] = true;

            Iterator<Details> i = adj[v].listIterator();

            while (i.hasNext())
            {
                int datas = -1;
                Details n = i.next();
                if (!visited[n.source]) {
                    datas = DFSUtil(n.source, w, visited);
                    if(datas >= 0)
                        return datas * n.weigth;
                }
            }
            return -1;
        }


    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vertices[] = reader.readLine().split(",");
        Map<String, Integer> verticesIndex = getVerticesIndexMap(vertices);
        int numberOfVertices = vertices.length;
        Graph g2 = new Graph(numberOfVertices);
        for (int i = 0; i < numberOfVertices-1; i++) {
            String details = reader.readLine();
            addEdges(g2, details, verticesIndex);
        }

        Map<Integer, String> indexVerticesMap = getIndexVerticesMap(verticesIndex);
        for(int i=0; i<numberOfVertices; i++){
            List<Details> detailsList = g2.getAllVerticesCovered(verticesIndex.get(vertices[i]));
            if(detailsList.size() == numberOfVertices-1){
                Collections.sort(detailsList, (v1, v2) -> v2.weigth < v1.weigth ? 1 : -1);

                int maxValue = detailsList.get(detailsList.size()-1).weigth;
                for (int j = detailsList.size()-1; j >= 0; j--) {
                    int weight = maxValue / detailsList.get(j).weigth;
                    String vertex = indexVerticesMap.get(detailsList.get(j).source);
                    System.out.print(weight+vertex+ " = ");
                }
                System.out.print(maxValue+vertices[i]);
                break;
            }
        }
    }

    private static Map<Integer, String> getIndexVerticesMap(Map<String, Integer> verticesIndex) {
        Map<Integer, String> map = new HashMap<>();
        for(Map.Entry<String, Integer> data: verticesIndex.entrySet()){
            map.put(data.getValue(), data.getKey());
        }
        return map;
    }


    private static Map<String, Integer> getVerticesIndexMap(String[] vertices) {
        Map<String, Integer> verticesIndex = new HashMap<>();
        for(int i=0; i<vertices.length; i++)
            verticesIndex.put(vertices[i], i);
        return verticesIndex;
    }

    private static void addEdges(Graph g2, String details, Map<String, Integer> verticesIndex) {
        String valueDetail[] = details.split(" = ");
        String source = valueDetail[0];
        String destination = valueDetail[1].substring(valueDetail[1].indexOf(' ')+1);
        int weigth = Integer.parseInt(valueDetail[1].substring(0, valueDetail[1].indexOf(' ')));

        int sourceIndex = verticesIndex.get(source);
        int destinationIndex = verticesIndex.get(destination);
        g2.addEdge(sourceIndex, destinationIndex, weigth);
    }
}

class Details{
    int source;
    int weigth;

    public Details(int source, int weigth) {
        this.source = source;
        this.weigth = weigth;
    }
}