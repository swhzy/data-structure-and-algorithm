package com.swh.data.sort;

public class SignBreak {

    public static void main(String[] args) {

        /**
         * 单层for循环的break
         *  直接跳出for循环  之后的循环都不执行
         */
        for (int i = 0; i < 10; i++) {
            // 这个循环在循环到第五次时进行了break，后面的五次循环就不会再执行
            // 只会输出 0,1,2,3,4  这五个数字
            if(i>=5){
                break;
            }
            //System.out.println(i);
        }

        /**
         * 单层for循环的continue
         *  跳出本次for循环  之后的循环还会继续执行
         */
        for (int i = 0; i < 10; i++) {
            // 这个循环在循环到第五次时进行了continue，下面的输出语句不会进行输出，for循环执行完毕之后会输出
            // 除5之外的所有值
            if(i==5){
               continue;
            }
            System.out.println(i);
        }

        /**
         *  这种双重循环不带标记的break  只会终止内部for循环 不会终止外部for循环
         *
         *  0-->0
         * 0-->1
         * 0-->2
         * 1-->0
         * 1-->1
         * 1-->2
         * 2-->0
         * 2-->1
         * 2-->2
         * 3-->0
         * 3-->1
         * 3-->2
         * 4-->0
         * 4-->1
         * 4-->2
         */

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j==3)break ;
                System.out.println(i+"-->"+j);
            }
        }
        /**
         *  这种双重循环带标记的break  会终止内部for循环 同时外部循环也会被终止掉
         *      本案例中外部循环只会执行一次就会被中断
         *  代码执行结果:
         *  0-->0
         * 0-->1
         * 0-->2
         * 0-->3
         * 0-->4
         */

        out:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==5)break out;
                System.out.println(i+"-->"+j);
            }
        }


        /**
         *  这种双重循环不带标记的continue  只会跳出内部本次for循环 不会影响外部for循环
         *
         *  0-->0
         * 0-->1
         * 0-->2
         * 0-->4
         * 1-->0
         * 1-->1
         * 1-->2
         * 1-->4
         * 2-->0
         * 2-->1
         * 2-->2
         * 2-->4
         * 3-->0
         * 3-->1
         * 3-->2
         * 3-->4
         * 4-->0
         * 4-->1
         * 4-->2
         * 4-->4
         *
         *
         */

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j==3)continue;
                System.out.println(i+"-->"+j);
            }
        }
        /**
         *  这种双重循环带标记的continue  当内部循环执行到j==5的时候就会中断直接跳到外部循环，然后外部循环会进行下一次循环
         *  代码执行结果:
         *      0-->0
         * 0-->1
         * 0-->2
         * 1-->0
         * 1-->1
         * 1-->2
         * 2-->0
         * 2-->1
         * 2-->2
         * 3-->0
         * 3-->1
         * 3-->2
         * 4-->0
         * 4-->1
         * 4-->2
         *
         */

        out:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j==3)continue out;
                System.out.println(i+"-->"+j);
            }
        }
    }

}
