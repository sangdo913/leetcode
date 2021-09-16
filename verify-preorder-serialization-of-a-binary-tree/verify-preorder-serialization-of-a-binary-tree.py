'''
간단하게 노드를 스플릿 해주고, 노드를 하나씩 증가시키면서 #이 아닌 경우는 left와 right가 만들어지는지 재귀함수를 타면서 증명해보면 됩니닷
'''

class Solution:
    def validate(self, nodes, idx):
        if(idx[0] == len(nodes)): return -1
        idx[0]+=1
        if nodes[idx[0]-1] != '#':
            ret = self.validate(nodes, idx)
            if ret == -1: return -1
            ret = self.validate(nodes, idx)
            if ret == -1: return -1
        return idx[0]
        
    def isValidSerialization(self, preorder: str) -> bool:
        string = preorder.split(",")
        return self.validate(string, [0]) == len(string)