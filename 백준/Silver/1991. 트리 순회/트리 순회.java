import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        private Map<Character, Node> nodes = new HashMap<>();
        private Node root;

        public void setRoot() {
            root = nodes.get('A');
        }

        public void addNode(char data, char leftData, char rightData) {
            // 현재 노드가 이미 존재하는지 확인하고 없으면 생성
            nodes.putIfAbsent(data, new Node(data));
            Node current = nodes.get(data);

            // 왼쪽 자식
            if (leftData != '.') {
                nodes.putIfAbsent(leftData, new Node(leftData));
                current.leftChild = nodes.get(leftData);
            }

            // 오른쪽 자식
            if (rightData != '.') {
                nodes.putIfAbsent(rightData, new Node(rightData));
                current.rightChild = nodes.get(rightData);
            }
        }

        // 전위 순회
        public void preorder(Node node) {
            if (node == null) return;
            System.out.print(node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }

        // 중위 순회
        public void inorder(Node node) {
            if (node == null) return;
            inorder(node.leftChild);
            System.out.print(node.data);
            inorder(node.rightChild);
        }

        // 후위 순회
        public void postorder(Node node) {
            if (node == null) return;
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            char data = input[0].charAt(0);
            char leftChild = input[1].charAt(0);
            char rightChild = input[2].charAt(0);
            tree.addNode(data, leftChild, rightChild);
        }

        tree.setRoot(); // 'A'를 루트로 설정

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);

        br.close();
    }
}