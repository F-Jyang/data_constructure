package Array;

import java.util.Arrays;

public class array {

    /**
     * #Description
     * 数组的增加与减少（指定index）：
     * 1、定义一个数组
     * 2、定义要改变的数组的长度
     * 3、将改变后的元素赋值给新数组
     * 4、新数组赋值给旧数组
     *
     * @param
     * @return
     * @author jiongyang
     * #Date 2021/8/19
     */
    public static void main(String[] args) {
//        //增加一个元素
//        //1、定义两个数组
//        int[] array={1,2,3,4,5};
//        int[] newarray=new int[array.length+2];
//        System.out.println("增加前："+ Arrays.toString(array));
//        //2、在末尾增加两个元素
//        int element1=6;
//        int element2=7;
//        //3、将改变后的元素赋值给新数组
//        for (int i = 0; i < array.length; i++) {
//            newarray[i]=array[i];
//        }
//        newarray[array.length]=element1;
//        newarray[array.length+1]=element2;
//        array=newarray;
//        System.out.println("增加后："+Arrays.toString(array));
        //数组减少一个数字：
        // * 1、定义一个数组
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] newarray = new int[array.length - 1];
        System.out.println("减少前：" + Arrays.toString(array));
        // * 2、减掉第三个数字
        int index = 3;
        // * 3、将改变后的元素赋值给新数组,这段是重点！！！！！！
        for (int i = 0; i < newarray.length; i++) {//赋值给newarray,所以是它的长度
            if (i < (index - 1)) {//第三个数字的索引为index-1
                newarray[i] = array[i];
            } else {
                //在小于index前直接遍历就行，
                // 大于index后，直接两个数组index相差1（去掉了index那个），补上解决
                newarray[i] = array[i + 1];
            }
        }
        // * 4、新数组赋值给旧数组
        array = newarray;
        System.out.println("减少后：" + Arrays.toString(array));

    }
}
