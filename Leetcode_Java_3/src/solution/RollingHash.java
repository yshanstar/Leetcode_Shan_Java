package solution;

import java.math.BigInteger;
import java.util.Random;

/******************************************************************************
 *  Compilation:  javac RollingHash.java
 *  Execution:    java RollingHash pat txt
 *  Dependencies: StdOut.java
 *
 *  Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using the
 *  Las Vegas version of the Rabin-Karp algorithm.
 *
 *  pattern: abracadabra
 *  text:    abacadabrabracabracadabrabrabracad 
 *  match:                 abracadabra          
 *
 *  pattern: rab
 *  text:    abacadabrabracabracadabrabrabracad 
 *  match:           rab                         
 *
 *  pattern: bcara
 *  text:         abacadabrabracabracadabrabrabracad 
 *
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                        rabrabracad
 *
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern: abacad
 *
 *
 *http://algs4.cs.princeton.edu/53substring/RabinKarp.java.html
 *http://stackoverflow.com/questions/6109624/need-help-in-understanding-rolling-hash-computation-in-constant-time-for-rabin-k
 *
 ******************************************************************************/

public class RollingHash {
	private String pattern;
	private long patternHash;
	private int M; //pattern length;
	private long Q; // large prime
	private int R; // radix
	private long RM; // R^(m-1)
	
	public RollingHash(String pattern){
		this.pattern = pattern;
		R = 256;
		M = pattern.length();
		Q = longRandomPrime();

		RM = 1;
		for (int i = 1; i <= M - 1; i++) {
			RM = (R * RM) % Q;
		}
		
		System.out.println("Q: " + Q);
		System.out.println("RM: " + RM);
		patternHash = hash(pattern, M);
	}
	
	 /**
     * Returns the index of the first occurrrence of the pattern string
     * in the text string.
     *
     * @param  txt the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; N if no such match
     * 1) (a*b) % p = ((a % p) * (b % p)) % p
     * 2) a % p = (a + p) % p
     */
    public int search(String txt) {
        int N = txt.length(); 
        if (N < M) return N;
        long txtHash = hash(txt, M); 

        // check for match at offset 0
        if ((patternHash == txtHash) && check(txt, 0))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = M; i < N; i++) {
			// Remove leading digit, add trailing digit, check for match.
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;

            // match
            int offset = i - M + 1;
            if ((patternHash == txtHash) && check(txt, offset))
                return offset;
        }

        // no match
        return N;
    }
	
	// Compute hash for key[0..M-1].
	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		System.out.println(key + ": " + h);
		return h;
	}
	
	
	// Las Vegas version: does pat[] match txt[i..i-M+1] ?
	private boolean check(String txt, int i) {
		for (int j = 0; j < M; j++)
			if (pattern.charAt(j) != txt.charAt(i + j)){
				return false;
			}
		return true;
	}
	
	// a random 31-bit prime
	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}
	
	
	public static void main(String[] args) {
        String pat = "abracadabra";
        String txt = "abacadabrabracabracadabrabrabracad";

        RollingHash searcher = new RollingHash(pat);
        int offset = searcher.search(txt);

        // print results
        System.out.println("text:    " + txt);

        // from brute force search method 1
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++)
        	System.out.print(" ");
        System.out.println(pat);
    }

}
