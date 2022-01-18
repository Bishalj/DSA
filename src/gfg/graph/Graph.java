package gfg.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  private LinkedList<Integer>[] adjLists;
  private int vertex;

  Graph(int size) {
    this.vertex = size;
    adjLists = new LinkedList[vertex];
    for (int i = 0; i < vertex; i++) {
      adjLists[i] = new LinkedList();
    }
  }

  public void insert(int src, int des) {
    adjLists[src].add(des);
    //    adjLists[des].add(src);
  }

  public void bfs() {
    boolean visited[] = new boolean[vertex];
    for (int i = 0; i < vertex; i++) {
      if (!visited[i]) bfs(i, visited);
    }
  }

  private void bfs(int source, boolean visited[]) {
    Queue<Integer> queue = new LinkedList();
    queue.add(source);
    visited[source] = true;
    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      System.out.print(vertex + " ");
      LinkedList<Integer> aAdjList = adjLists[vertex];
      for (int linkedVertex : aAdjList) {
        if (!visited[linkedVertex]) {
          queue.add(linkedVertex);
          visited[linkedVertex] = true;
        }
      }
    }
    System.out.println();
  }

  public void shortestPath() {
    boolean visited[] = new boolean[vertex];
    for (int i = 0; i < vertex; i++) {
      if (!visited[i]) shortestPath(i, visited);
    }
  }

  private void shortestPath(int source, boolean visited[]) {
    Queue<Integer> queue = new LinkedList();
    queue.add(source);
    visited[source] = true;
    int count = 0;
    System.out.print(count + " ");
    while (!queue.isEmpty()) {
      int size = queue.size();
      count++;
      while (size-- > 0) {
        int vertex = queue.poll();
        LinkedList<Integer> aAdjList = adjLists[vertex];
        for (int linkedVertex : aAdjList) {
          if (!visited[linkedVertex]) {
            System.out.print(count + " ");
            queue.add(linkedVertex);
            visited[linkedVertex] = true;
          }
        }
      }
    }
    System.out.println();
  }

  public void dfs() {
    boolean visited[] = new boolean[vertex];
    for (int i = 0; i < vertex; i++) {
      if (visited[i] == false) dfs(i, visited);
    }
  }

  private void dfs(int source, boolean[] visited) {
    System.out.print(source + " ");
    visited[source] = true;
    LinkedList<Integer> aAdjList = adjLists[source];
    while (aAdjList.isEmpty() == false) {
      int vertex = aAdjList.poll();
      if (visited[vertex] == false) dfs(vertex, visited);
    }
  }

  private boolean detectACycle(int source, boolean[] visited) {
    System.out.print(source + " ");
    visited[source] = true;
    LinkedList<Integer> aAdjList = adjLists[source];
    while (aAdjList.isEmpty() == false) {
      int vertex = aAdjList.poll();
      if (visited[vertex] == false) return detectACycle(vertex, visited);
      else if (vertex != source) return true;
    }
    return false;
  }

  private void topologicalSort(int source, boolean[] visited, Stack<Integer> stack) {
    visited[source] = true;
    LinkedList<Integer> linkedList = adjLists[source];
    while (linkedList.isEmpty() == false) {
      int vertex = linkedList.poll();
      if (visited[vertex] == false) {
        topologicalSort(vertex, visited, stack);
      }
    }
    stack.push(source);
  }

  private void topologicalSort() {
    boolean visited[] = new boolean[vertex];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < vertex; i++) {
      if (visited[i] == false) topologicalSort(i, visited, stack);
    }

    while (stack.isEmpty() == false) {
      System.out.print(stack.pop() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.insert(0, 1);
    graph.insert(0, 2);
    graph.insert(2, 3);
    graph.insert(2, 4);
    graph.bfs();
    graph.dfs();

    System.out.println();
    Graph graph2 = new Graph(4);
    graph2.insert(0, 1);
    graph2.insert(0, 2);
    graph2.insert(1, 2);
    graph2.insert(1, 3);
    graph2.insert(2, 3);
    graph2.bfs();
    graph2.dfs();
    System.out.println();

    Graph graph3 = new Graph(4);
    graph3.insert(0, 1);
    graph3.insert(1, 2);
    graph3.insert(2, 3);
    graph3.insert(0, 2);
    graph3.insert(1, 3);

    System.out.println("---------------- Shortest Path -------------------");
    graph3.shortestPath();

    Graph graph4 = new Graph(6);
    graph4.insert(0, 1);
    graph4.insert(0, 2);
    graph4.insert(0, 4);
    graph4.insert(1, 3);
    graph4.insert(2, 3);
    graph4.insert(2, 4);
    graph4.insert(3, 5);
    graph4.insert(4, 5);

    System.out.println("---------------- Shortest Path -------------------");
    graph4.shortestPath();

    Graph graph5 = new Graph(6);
    graph5.insert(2, 3);
    graph5.insert(3, 1);
    graph5.insert(4, 0);
    graph5.insert(4, 1);
    graph5.insert(5, 0);
    graph5.insert(5, 2);

    System.out.println("---------------- Topological Sort -------------------");
    graph5.topologicalSort();
  }
}

/*
 * root in stack
 * visited array to avoid re-traversal
 *
 * */
