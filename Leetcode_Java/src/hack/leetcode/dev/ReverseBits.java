package hack.leetcode.dev;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, 
 * 	given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * 	return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int i=0;
        int reverseVal =0;
        while(i<=31){
            int temp=1<<i;

            int bitNum=temp&n;

            if(bitNum!=0){
                reverseVal=(reverseVal<<1)+1;
            }else{
                reverseVal=reverseVal<<1;
            }

            i++;

        }

        return reverseVal;
	}
}
