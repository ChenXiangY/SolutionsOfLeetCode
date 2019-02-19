package com.test;


import edu.princeton.cs.algs4.Graph;

/**
 * @author Chen Xiangyu
 * @version 1.0
 * @classname Graph
 * @date 2019/2/16
 */
public class GraphAlgorithm {

    private boolean[] marked;
    private int count;
    public void dfs(Graph graph, int v){
        marked[v] = true;
        count++;
        for (int w :
                graph.adj(v)) {
            if (!marked[w]){
                dfs(graph, w);
            }
        }
    }
}
