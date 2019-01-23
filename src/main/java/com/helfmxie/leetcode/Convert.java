package com.helfmxie.leetcode;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-23 18:31
 * @Description: Z 字形变换
 */
public class Convert {

    public String convert(String s, int numRows) {
        if (s == null || s.equals("")) {
            return "";
        }
        if (s.length() == 1||numRows ==1) {
            return s;
        }
        //每一个单元的列数量
        int numUnitColumn = 1 + (numRows - 2);
        //每一个单元的字符数量
        int numUnitChar = numRows + (numRows - 2);

        //先求出二维数组的列数
        int numColumns = 0;
        if (s.length() % numUnitChar == 0) {
            numColumns = (s.length() / numUnitChar) * numUnitColumn;
        } else if (s.length() % numUnitChar <= numRows) {
            numColumns = (s.length() / numUnitChar) * numUnitColumn + 1;
        } else {
            numColumns = (s.length() / numUnitChar) * numUnitColumn + s.length() % numUnitChar;
        }
        if (numColumns == 0) {
            return null;
        }
        char[][] stringArray = new char[numRows][numColumns];
        int abscissa = 0;
        int ordinate = 0;
        boolean isUp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringArray[abscissa][ordinate] = c;
            if (isUp) {
                //上升阶段,横坐标-1,纵坐标+1;
                abscissa--;
                ordinate++;
                if (abscissa == 0) {
                    isUp = false;
                }
            } else {
                //下降阶段,横坐标+1,纵坐标不变;
                abscissa++;
                if (abscissa == numRows - 1) {
                    isUp = true;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                if (stringArray[i][j] != 0) {
                    stringBuilder.append(stringArray[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
