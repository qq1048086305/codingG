package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2022/2/6 17:23
 * @Version 1.0
 * @description:
 */

import java.util.*;


class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}

public class TopSolution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        //拓扑排序结果
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        //记录每个相连点的入度
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }
        //BFS做拓扑排序
        Queue<DirectedGraphNode> queue = new ArrayDeque<>();
        //遍历起点(入度为0)
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
                order.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            //找到下一个入度为0点
            for (DirectedGraphNode neighbor : node.neighbors) {
                //将当前节点出图 所连节点入度减1
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                //找到入度为0点入队
                if (indegree.get(neighbor) == 0) {
                    order.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }
}