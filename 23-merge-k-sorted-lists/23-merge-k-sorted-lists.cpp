/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
ListNode* merge(ListNode* a, ListNode*b){
    ListNode temp;
    ListNode *cur = &temp;
    int v1, v2;
    while(a || b){
        v1 = a ? a->val : 0x3f3f3f3f;
        v2 = b ? b->val : 0x3f3f3f3f;
        if(v1 < v2) {
            cur->next = a;
            cur = a;
            a = a->next;
        }
        else {
            cur->next = b;
            cur = b;
            b = b->next;
        }
    }
    return temp.next;
}

ListNode* mergesort(vector<ListNode*>& l, int i, int j){
    if(i >= j) {
        return 0;
    }
    if(i+1 == j) {
        return l[i];
    }
    int m = (i+j)/2;
    ListNode* a = mergesort(l, i,m);
    ListNode* b = mergesort(l,m,j);
    return merge(a,b);
}
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        return mergesort(lists, 0, lists.size());
    }
};