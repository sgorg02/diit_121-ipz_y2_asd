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

matrix Create(int Rows, int Cols);//��������� ���������
void Delete(matrix& _m);//��������� �������
void RandFilling(matrix _m);//���������� ��������
void ManualFilling(matrix _m);//���������� ������
void Show(matrix _m);//���� �������
void ShowMean(int* _m, int x);//���� �������� �� ��������
int* Selection(matrix &_m);//���������� ��������

#endif