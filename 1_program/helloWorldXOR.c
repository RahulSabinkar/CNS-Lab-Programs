/*
 * Question 1: Write a C program that contains a string (char pointer) with a value ‘Hello
 * world’. The program should XOR each character in this string with 0 and displays the result.
 *
 * AIM: Write a C program that contains a string (char pointer) with a value 'Hello World’.
 * The program should XOR each character in this string with 0 and display the result.
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
    int i, len;
    len = strlen(str);
    for (i = 0; i < len; i++)
    {
        str1[i] = str[i] ^ 0;
        printf("%c", str1[i]);
    }
    printf("\n");
}
/*
 * Output:
 * Hello World
 * Hello World
 */