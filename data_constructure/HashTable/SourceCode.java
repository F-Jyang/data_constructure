package HashTable;

import java.util.HashSet;

public class SourceCode {
   /*
   String:哈希码为string取一半长度，然后h=31*h+getChar(value,i)

   public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            hash = h = isLatin1() ? StringLatin1.hashCode(value)
                    : StringUTF16.hashCode(value);
        }
        return h;
    }
    */
    /*
    StringUTF16:

    public static int hashCode(byte[] value) {
        int h = 0;
        int length = value.length >> 1;
        for (int i = 0; i < length; i++) {
            h = 31 * h + getChar(value, i);
        }
        return h;
    }
     */
}
