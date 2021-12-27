package de.pschiessle.showcase.utils;

public class ArrayHelper {
  public static boolean is1DIndexInRange(Object[] arr, int x){
    return arr.length > x && x >= 0;
  }
  public static boolean is2DIndexInRange(Object[][] arr, int x, int y){
    return arr.length > x && x >= 0
        && arr[x].length > y && y >= 0;
  }
}
