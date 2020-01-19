package lesson9;

import java.util.*;

/**
 * 两两相邻单词比较每一对应位置的字母，确定字母顺序，构建邻接表
 * 对邻接表进行拓扑排序
 * 按照拓扑排序的顺序输出字母顺序列表
 */
public class MarsDictionary2 {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"z", "x", "z"};
//        String[] words = {"z", "x", "x"};
        String charOrders = alienOrder(words);
        System.out.println(charOrders);
    }

    private static String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        if (words.length == 1) {
            return words[0];
        }

        // 构建邻接表
        Map<Character, List<Character>> adjList = new HashMap<>();
        for (int i=0; i<words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int n1 = w1.length();
            int n2 = w2.length();

            boolean found = false;

            for (int j=0; j<Math.max(n1, n2); j++) {
                Character c1 = j < n1 ? w1.charAt(j) : null;
                Character c2 = j < n2 ? w2.charAt(j) : null;

                if(c1 != null && !adjList.containsKey(c1)) {
                    adjList.put(c1, new ArrayList<Character>());
                }

                if(c2 != null && !adjList.containsKey(c2)) {
                    adjList.put(c2, new ArrayList<Character>());
                }

                if(c1 != null && c2 != null && c1 != c2 && !found) {
                    adjList.get(c1).add(c2);
                    found = true;
                }
            }
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> loop = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        topologicalSort(adjList, words[0].charAt(0), visited, loop, stack);

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Character c = stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }

    static boolean topologicalSort(Map<Character, List<Character>> adjList, char u,
                                   Set<Character> visited, Set<Character> loop, Stack<Character> stack) {
        visited.add(u);
        loop.add(u);

        if (adjList.containsKey(u)) {
            for (int i=0; i<adjList.get(u).size(); i++) {
                char v = adjList.get(u).get(i);
                if (loop.contains(v)) {
                    // 有环
                    return false;
                }

                if (!visited.contains(v)) {
                    if (!topologicalSort(adjList, v, visited, loop, stack)) {
                        // 有环
                        return false;
                    }
                }
            }
        }

        loop.remove(u);
        stack.push(u);
        return true;
    }
}
