/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
unordered_map<Node*, Node*> chk;

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(!node) return 0;
        if(chk[node]) return chk[node];
        Node* nn = chk[node] = new Node(node->val, vector<Node*>(node->neighbors.size()));
        for(int i = 0; i < node->neighbors.size(); ++i){
            nn->neighbors[i] = cloneGraph(node->neighbors[i]);
        }
        return nn;
    }
};