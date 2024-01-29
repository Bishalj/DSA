package practice.trie;

class TrieData2{
	private TrieData2[] trie = new TrieData2[26];
	private boolean isEnd = false;

	public TrieData2() {
	}

	public TrieData2(TrieData2[] trie, boolean isEnd) {
		this.trie = trie;
		this.isEnd = isEnd;
	}


	public TrieData2(TrieData2[] trie) {
		this.trie = trie;
	}

	public TrieData2[] getTrie() {
		return trie;
	}

	public void setTrie(TrieData2[] trie) {
		this.trie = trie;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean end) {
		isEnd = end;
	}

	public void insert(String key){
		TrieData2 root = this;
		for(int i=0; i<key.length(); i++){
			int ch = key.charAt(i) - '0';
			if(root.trie[ch] == null)
				root.trie[ch] = new TrieData2();
			root = root.trie[ch];
		}
		root.isEnd = true;
	}

	public boolean search(String key){
		TrieData2 root = this;
		for(int i=0; i<key.length(); i++){
			int ch = key.charAt(i) - 'a';
			if(root.trie[ch] == null)
				return false;
			root = root.trie[ch];
		}
		return  root.isEnd;
	}

	public boolean delete(TrieData2 root, String key, int index){
		if(index == key.length()){
			root.isEnd = false;
			return !isAnyKeyPresent(root);
		}
		TrieData2 trieData = root.trie[key.charAt(index)-'a'];
		if(trieData != null){
			boolean isDeleted = delete(trieData, key, index+1);
			if(isDeleted)
				root.trie[key.charAt(index)-'a'] = null;
		}
		return true;
	}

	private boolean isAnyKeyPresent(TrieData2 root) {
		for(int i=0; i<26; i++){
			if(root.trie[i] != null)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		final TrieData2 trieData2 = new TrieData2();
		int[][] arr = {
				{1,1,0},
				{1,0,1}
		};
		for (int[] row : arr) {
			final StringBuilder sb = new StringBuilder();
			for (int anInt : row) sb.append(anInt);
			trieData2.insert(sb.toString());
		}
		System.out.println(trieData2.distinctCount(trieData2));
	}

	private int distinctCount(TrieData2 trieData2) {
		if(trieData2 == null)
			return 0;
		int count = trieData2.isEnd ? 1:0;
		for(int i=0; i<trieData2.trie.length; i++){
			count += distinctCount(trieData2.trie[i]);
		}
		return count;
	}
}