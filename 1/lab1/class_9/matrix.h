#ifndef __MATRIX_H__
#define __MATRIX_H__
#include <random>
#include <iostream>
struct matrix {
	int x;
	int rows;
	int cols;
	int** arr;
};

matrix Create(int Rows, int Cols);//створення структури
void Delete(matrix& _m);//видалення матриці
void RandFilling(matrix _m);//заповнення рандомно
void ManualFilling(matrix _m);//заповнення вручну
void Show(matrix _m);//вивід матриці
void ShowMean(int* _m, int x);//вивід студениів на степендію
int* Selection(matrix &_m);//виповнення завдання

#endif