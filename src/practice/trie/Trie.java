package practice.trie;

public class Trie{

}


class TrieData{
	private TrieData[] trie = new TrieData[26];
	private boolean isEnd = false;

	public TrieData() {
	}

	public TrieData(TrieData[] trie, boolean isEnd) {
		this.trie = trie;
		this.isEnd = isEnd;
	}


	public TrieData(TrieData[] trie) {
		this.trie = trie;
	}

	public TrieData[] getTrie() {
		return trie;
	}

	public void setTrie(TrieData[] trie) {
		this.trie = trie;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean end) {
		isEnd = end;
	}

	public void insert(String key){
		TrieData root = this;
		for(int i=0; i<key.length(); i++){
			int ch = key.charAt(i) - 'a';
			if(root.trie[ch] == null)
				root.trie[ch] = new TrieData();
			root = root.trie[ch];
		}
		root.isEnd = true;
	}

	public boolean search(String key){
		TrieData root = this;
		for(int i=0; i<key.length(); i++){
			int ch = key.charAt(i) - 'a';
			if(root.trie[ch] == null)
				return false;
			root = root.trie[ch];
		}
		return  root.isEnd;
	}

	public boolean delete(TrieData root, String key, int index){
		if(index == key.length()){
			root.isEnd = false;
			return !isAnyKeyPresent(root);
		}
		TrieData trieData = root.trie[key.charAt(index)-'a'];
		if(trieData != null){
			boolean isDeleted = delete(trieData, key, index+1);
			if(isDeleted)
				root.trie[key.charAt(index)-'a'] = null;
		}
		return true;
	}

	private boolean isAnyKeyPresent(TrieData root) {
		for(int i=0; i<26; i++){
			if(root.trie[i] != null)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		final TrieData trieData = new TrieData();
		trieData.insert("bishal");
		trieData.insert("bishaljaiswal");
		trieData.insert("bishaljais");
		trieData.insert("bish");
		trieData.insert("abc");
		System.out.println(trieData.search("bishal"));
		System.out.println(trieData.search("bishak"));
		System.out.println(trieData.search("bishaljais"));
		System.out.println(trieData.search("bishaljai"));
		System.out.println(trieData.search("bishaljaiswal"));
		System.out.println(trieData.search("bishalja"));
		System.out.println(trieData.search("abc"));
		System.out.println(trieData.search("abcd"));
		System.out.println("-----------------Delete-------------------");
		System.out.println(trieData.search("bishal"));
		System.out.println(trieData.delete(trieData, "bishal", 0));
		System.out.println(trieData.search("bishal"));


		final TrieData trieData2 = new TrieData();
		int arr[][] = {
				{1,1,0},
				{1,1,0},
				{0,0,1},
				{0,0,1}
		};
	}
}


