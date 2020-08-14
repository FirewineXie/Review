package com.study.smallgame;

/**
 * Description:
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 */
public class ArrayUtils
{
	public static int search(String[] array, String target)
	{
		for (int i = 0 ; i < array.length ; i++ )
		{
			if (array[i] != null && array[i].equals(target))
			{
				return i;
			}
		}
		return -1;
	}
}
