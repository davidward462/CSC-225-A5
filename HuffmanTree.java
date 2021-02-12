/*
 * A Huffman Tree.
 * Huffman Trees are built with Huffman Nodes (HNodes)
 
 Name: David Ward
 Vnum: V00920409
 
 */
public class HuffmanTree 
{
	HNode root;
	
	public HuffmanTree(HNode root) {
		this.root = root;
	}
	
	/*
	 * Purpose: Decode the sequence of bits and return the associated string
	 * Parameters: BitQueue input - the input sequence of bits
	 * Returns: String - the decoded text
	 * Example:
	 *   For decoding an input, every time a 0-bit is read, 
	 *   the associated letter is found in the left subtree.
	 *   Every time a 1-bit is read, the associated letter
	 *   is found in the right subtree.
	 *
	 *   When a leaf node is detected, a letter can be added
	 *   to the output String. To decode the next sequence of 
	 *   bits, start traversing the tree from the root.
	 *
	 *   See the lecture exercise for more details.
	 */
	public String decode(BitQueue input) {
		try {
			return decodeRecursive(root, input);
		} catch (DecodeException e) {
			System.out.println(e);
		}
		return "Invalid coding";
	}
	
	public String decodeRecursive(HNode cur, BitQueue input) throws DecodeException 
	{
		// TODO: implement this
		
		//base case: current node is a leaf
		if(cur.left==null && cur.right==null)
		{
			return cur.letter + decodeRecursive(root, input);
		}
		
		//not a leaf, so get the next bit
		if(input.isEmpty())//if queue is empty, end
		{
			return "";
		}
		else//not empty
		{
			String s = input.dequeue();
			if(s.compareTo("0")==0)//left
			{
				return "" + decodeRecursive(cur.left, input);//decode left subtree
			}
			else if(s.compareTo("1")==0)//right
			{
				return "" + decodeRecursive(cur.right, input);//decode right subtree
			}
		}
		return "";
		
	}
}



