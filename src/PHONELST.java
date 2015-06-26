import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PHONELST {
	static final char[] alphabet = "0123456789".toCharArray();
	//A trie is a tree where each
	//node represents a word or a prefix
	//the root represents the empty string ""
	//only the characters in the alphabet array
	//are supported
	static class TrieNode{
		//to indicate whether this node represents
		//a complete word or only a prefix
		int words;
		TrieNode edges[];
		public TrieNode(){
			this.words = 0;
			//initially all edges are null
			this.edges= new TrieNode[alphabet.length];
		}
	}
	static class Trie{
		TrieNode root;
		
		public Trie(){
			this.root= new TrieNode();
		}
		//return false if it's the prefix of some existing word
		//or some existing word is its prefix
		//otherwise, add the new word w to the trie and return true
		boolean addWord(String w){
			char chars[]= w.toCharArray();
			TrieNode cur = this.root;
			//making sure none of the existing words it its prefix!
			for (int i = 0; i < chars.length-1; i++) {
				int index = chars[i] - alphabet[0];
				if(cur.edges[index]==null){
					cur.edges[index]= new TrieNode();
				}
				else{
					//node already isn't null
					if(cur.edges[index].words>0){
						return false;
					}
				}
				cur = cur.edges[index];
			}
			//making sure it is NOT the prefix of an existing word
			int index = chars[chars.length-1] - alphabet[0];
			if(cur.edges[index]!=null){
				return false;
			}
			cur.edges[index]= new TrieNode();
			cur.edges[index].words++;
			return true;

		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		while(t-->0){
			int n = new Integer(br.readLine());
			Trie trie = new Trie();
			boolean ans = true;
			while(n-->0){
				String next = br.readLine();
				if(ans){
					ans&= trie.addWord(next);
				}
			}
			if(ans)
				out.append("YES");
			else
				out.append("NO");
			out.append('\n');
		}
		System.out.print(out);
	}
}
