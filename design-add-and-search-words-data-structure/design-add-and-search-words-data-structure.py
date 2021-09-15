class Trie:
    def __init__(self):
        self.child = [None]*26
        self.isEnd = False
    def search(self, word) -> bool:
        if(len(word) == 0): return self.isEnd
        conv = ord(word[0]) - ord('a')
        next = word[1:]
        if(word[0] == '.'):
            for c in range(0,26):
                if self.child[c] and self.child[c].search(next): return True
        else: 
            if(self.child[conv]): 
                return self.child[conv].search(next)
        
        return False
        
        
class WordDictionary:
    def __init__(self):
        self.root = Trie()
        """
        Initialize your data structure here.
        """
        

    def addWord(self, word: str) -> None:
        now = self.root
        for c in word:
            conv = ord(c) - ord('a')
            if now.child[conv] == None:
                now.child[conv] = Trie()
            now = now.child[conv]
            
        now.isEnd = True
        
    def search(self, word: str) -> bool:
        return self.root.search(word)
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)