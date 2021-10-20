#include "matrix.h"

//����� ���: ����� �������
//������ ���: ���������
matrix Create(int Rows, int Cols) {
	matrix tmp;
	tmp.rows = Rows;
	tmp.cols = Cols;
	tmp.arr = new int*[tmp.rows];
	for (int i = 0; i < tmp.rows; i++)
		tmp.arr[i] = new int[tmp.cols];
	return tmp;
}

//����� ���: ���������
//������ ���: ���������
void Delete(matrix & _m) {
	for (int i = 0; i < _m.rows; i++)
		delete[] _m.arr[i];
	delete[] _m.arr;
}

//����� ���: ���������
//������ ���: ���������� �������
void RandFilling(matrix _m) {
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_int_distribution<int> dis(1, 5);
	for (int i = 0; i < _m.rows; i++)
		for (int j = 0; j < _m.cols; j++)
			_m.arr[i][j] = dis(gen);
}

//����� ���: ���������
//������ ���: ���������� �������
void ManualFilling(matrix _m) {
	for (int i = 0; i < _m.rows; i++)
		for (int j = 0; j < _m.cols; j++)
			_m.arr[i][j] = 0;


	for (int i = 0; i < _m.rows; i++)
		for (int j = 0; j < _m.cols; j++) {
			Show(_m);
			std::cin >> _m.arr[i][j];
			system("cls");
		}
}

//����� ���: ���������
//������ ���: ��������� �������
void Show(matrix _m) {
	for (int i = 0; i < _m.rows; i++) {
		std::cout << i + 1 << "��.\t";
		for (int j = 0; j < _m.cols; j++)
			std::cout << _m.arr[i][j] << "\t";
		std::cout << std::endl;
	}
}

//����� ���: ���������
//������ ���: ��������� �������
void ShowMean(int *_m, int x) {
	std::cout << std::endl << "�������� ���������: " << std::endl;
	for (int i = 0; i < x; i++)
		std::cout << "������� ����� " << _m[i] << std::endl;
}

//����� ���: ���������
//������ ���: ������ ��������
int* Selection(matrix &_m) {
	bool check = true;
	int tmp = 0;
	int SIZE = 0; //����� ������ ���������� �������� 
	for (int i = 0; i < _m.rows; check = true, i++) {
		for (int j = 0; j < _m.cols && check == true; j++) {
			if (_m.arr[i][j] < 3)
				check = false;
		}
		if (check == true)
			SIZE++;
	}
	
	double *mean = new double[SIZE];//������� ��������
	int *number = new int[SIZE];//����� ��������

	int k = 0;
	for (int i = 0; i < _m.rows; tmp = 0, check = true, i++) {
		for (int j = 0; j < _m.cols && check == true; j++) {
			if (_m.arr[i][j] > 2) 
				tmp += _m.arr[i][j];
			else
				check = false;
		}
		if (check == true) {
			mean[k] = (double)tmp / _m.cols;//������� ���
			number[k] = i + 1;//������������ ����� ��������
			k++;
		}
	}
	
	/*std::cout << "�� ³�����������" << std::endl;
	for (int i = 0; i < SIZE; i++)
		std::cout << "������� ����� " << number[i] << " �� ������� �����: " << mean[i] << std::endl;*/

	int temp, item;//��� ������ mean
	int temp_, item_;//��� ������ number
	for (int counter = 1; counter < SIZE; counter++) {
		temp_ = number[counter];
		item_ = counter - 1; // ���������� ������ ����������� �������� �������
		temp = mean[counter]; // �������������� ��������� ���������� ������� ��������� �������� �������
		item = counter - 1; // ���������� ������ ����������� �������� �������
		while (item >= 0 && mean[item] < temp) {// ���� ������ �� ����� 0 � ���������� ������� ������� ������ ��������
			mean[item + 1] = mean[item];
			mean[item] = temp;
			number[item + 1] = number[item];
			number[item] = temp_;
			item--;
		}
	}
	/*std::cout << "³�����������" << std::endl;
	for (int i = 0; i < SIZE; i++)
		std::cout << "������� ����� " << number[i] << " �� ������� �����: " << mean[i] << std::endl;*/

	_m.x = (SIZE * 40) / 100;
	/*std::cout << "x = " << _m.x << std::endl;
	std::cout << "�������� ���������: " << std::endl;
	for (int i = 0; i < _m.x; i++)
		std::cout << "������� ����� " << number[i] << " �� ������� �����: " << mean[i] << std::endl;
	std::cout << std::endl;*/


	return number;
}