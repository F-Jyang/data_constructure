//package helper;
//
//import com.google.common.base.Strings;
//
//import java.io.*;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * User: Shawn cao
// * Date: 14-5-6
// * Time: PM5:58
// */
//public class StreamUtil {
//
//    public static Integer[] readAllInts(InputStream in){
//        BufferedReader  br = new BufferedReader(new InputStreamReader(in));
//        List<Integer> tmp = new LinkedList<>() ;
//        String line="";
//        try {
//            while(!Strings.isNullOrEmpty(line = br.readLine())){
//                tmp.add(Integer.parseInt(line.trim()));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return tmp.toArray(new Integer[tmp.size()]);
//    }
//}
