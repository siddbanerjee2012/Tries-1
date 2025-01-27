// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        String[] splitString=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<splitString.length;i++){
            if(i!=0){
                result.append(" ");
            }
            String word=splitString[i];
            StringBuilder sb=new StringBuilder();
            TrieNode curr=root;
            for (int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr=curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(sb.toString());
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }
}