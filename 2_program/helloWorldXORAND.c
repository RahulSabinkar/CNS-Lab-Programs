/*
 * Question 2: Write a C program that contains a string (char pointer) with a value ‘Hello world’.
 * The program should AND or and XOR each character in this string with 127 and display the result.
 *
 * AIM: Write a C program that contains a string (char pointer) with a value 'Hello World’.
 * The program should AND or and XOR each character in this string with 127 and display the result.
 *
 * PROGRAM:
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void main()
{
    char str[] = "Hello World";
    char str1[11];
    char str2[11];
    int i, len;
    len = strlen(str);
    for (i = 0; i < len; i++)
    {
        str1[i] = str[i] & 127;
        printf("%c", str1[i]);
    }
    printf("\n");
    for (i = 0; i < len; i++)
    {
        str2[i] = str[i] ^ 127;
        printf("%c", str2[i]);
    }
    printf("\n");
}
/*
 * Output:
 * Hello World
 * Hello World
 * Hello World
 */