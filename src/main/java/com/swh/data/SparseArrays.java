package com.swh.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SparseArrays {


    public static void main(String[] args) throws IOException {
        // 原始数组
        int[][] originalArrays = new int[10][10];
        originalArrays[2][8] = 1;
        originalArrays[3][5] = 2;
        originalArrays[7][2] = 3;
        originalArrays[8][2] = 4;


        System.out.println(JSON.toJSONString(originalArrays));
        // 使用稀疏数组进行压缩  (sparse arrays)
        // step 1  get original arrays size
        int originalArraysSize = 0;
        for (int i = 0; i < originalArrays.length; i++) {
            int[] originalArrayColumn = originalArrays[i];
            for (int j = 0; j < originalArrayColumn.length; j++) {
                if (originalArrayColumn[j] != 0) {
                    originalArraysSize +=1;
                }
            }
        }
        int[][] sparseArrays = new int[originalArraysSize+1][3];
        sparseArrays[0][0] = originalArrays.length;
        sparseArrays[0][1] = originalArrays[0].length;
        sparseArrays[0][2] = originalArraysSize;
        int length = 1;
        for (int i = 0; i < originalArrays.length; i++) {
            int[] originalArrayColumn = originalArrays[i];
            for (int j = 0; j < originalArrayColumn.length; j++) {
                if (originalArrayColumn[j] != 0) {
                    sparseArrays[length][0]=i;
                    sparseArrays[length][1]=j;
                    sparseArrays[length][2]=originalArrayColumn[j];
                    length +=1;
                }
            }
        }
        System.out.println(JSON.toJSONString(sparseArrays));

        byte[] bytes = JSON.toJSONString(sparseArrays).getBytes();

        new FileOutputStream(new File("E:\\sparseArrays")).write(bytes);
        byte[] bytes1 = new byte[2];
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\sparseArrays"));
        int len = 0;
        String inputFile ="";
        while ((len=fileInputStream.read(bytes1))!=-1){
            inputFile=inputFile+new String(bytes1,0,len);
        }
        List list = JSON.parseObject(inputFile, List.class);
        sparseArrays =new int[list.size()][3];

        for (int i=0;i<list.size();i++) {
            JSONArray  jsonArray = (JSONArray) list.get(i);
            for (int j=0;j<jsonArray.size();j++){
                sparseArrays[i][j]= (int) jsonArray.get(j);
            }
        }


        //还原数组
        int[][] reductionArrays = new int[sparseArrays[0][0]][sparseArrays[0][1]];
        for (int i=1;i<sparseArrays.length;i++) {
            int[] sparseArray = sparseArrays[i];
            reductionArrays[sparseArray[0]][sparseArray[1]] = sparseArray[2];
        }
        System.out.println(JSON.toJSONString(reductionArrays));
    }
}
