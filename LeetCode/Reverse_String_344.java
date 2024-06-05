/*@AUTHOR Ian Mendes
*Código criado a fim de resolver o desafio 344 LeetCode.
* 100% mais rápido que a média em response time.
* 49.50 MB de memória.
* @VERSION 1.0
* @DATE 03-06-2024
*/

class resp {
    public void reverseString(char[] s) {
        char temp;
        int k = s.length - 1;

        for (int i = 0; i <= (s.length-1)/2; i++)
        {
            temp = s[k];
            s[k] = s[i];
            s[i] = temp;
            k--;
        }

    }
}
