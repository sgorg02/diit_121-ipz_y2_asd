#include "matrix.h"

//Вхідні дані: розмір матриці
//Вихідні дані: структура
matrix Create(int Rows, int Cols) {
	matrix tmp;
	tmp.rows = Rows;
	tmp.cols = Cols;
	tmp.arr = new int*[tmp.rows];
	for (int i = 0; i < tmp.rows; i++)
		tmp.arr[i] = new int[tmp.cols];
	return tmp;
}

//Вхідні дані: структура
//Вихідні дані: видалення
void Delete(matrix & _m) {
	for (int i = 0; i < _m.rows; i++)
		delete[] _m.arr[i];
	delete[] _m.arr;
}

//Вхідні дані: структура
//Вихідні дані: заповнення матриці
void RandFilling(matrix _m) {
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_int_distribution<int> dis(1, 5);
	for (int i = 0; i < _m.rows; i++)
		for (int j = 0; j < _m.cols; j++)
			_m.arr[i][j] = dis(gen);
}

//Вхідні дані: структура
//Вихідні дані: заповнення матриці
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

//Вхідні дані: структура
//Вихідні дані: заповнена матриця
void Show(matrix _m) {
	for (int i = 0; i < _m.rows; i++) {
		std::cout << i + 1 << "ст.\t";
		for (int j = 0; j < _m.cols; j++)
			std::cout << _m.arr[i][j] << "\t";
		std::cout << std::endl;
	}
}

//Вхідні дані: структура
//Вихідні дані: заповнена матриця
void ShowMean(int *_m, int x) {
	std::cout << std::endl << "Степендію отримають: " << std::endl;
	for (int i = 0; i < x; i++)
		std::cout << "Студент номер " << _m[i] << std::endl;
}

//Вхідні дані: структура
//Вихідні дані: номери студентів
int* Selection(matrix &_m) {
	bool check = true;
	int tmp = 0;
	int SIZE = 0; //розмір масива середнього значення 
	for (int i = 0; i < _m.rows; check = true, i++) {
		for (int j = 0; j < _m.cols && check == true; j++) {
			if (_m.arr[i][j] < 3)
				check = false;
		}
		if (check == true)
			SIZE++;
	}
	
	double *mean = new double[SIZE];//середне значення
	int *number = new int[SIZE];//номер студента

	int k = 0;
	for (int i = 0; i < _m.rows; tmp = 0, check = true, i++) {
		for (int j = 0; j < _m.cols && check == true; j++) {
			if (_m.arr[i][j] > 2) 
				tmp += _m.arr[i][j];
			else
				check = false;
		}
		if (check == true) {
			mean[k] = (double)tmp / _m.cols;//середній бал
			number[k] = i + 1;//запамятовуємо номер студента
			k++;
		}
	}
	
	/*std::cout << "До Відсортований" << std::endl;
	for (int i = 0; i < SIZE; i++)
		std::cout << "Студент номер " << number[i] << " із середнім балом: " << mean[i] << std::endl;*/

	int temp, item;//для масиму mean
	int temp_, item_;//для масиву number
	for (int counter = 1; counter < SIZE; counter++) {
		temp_ = number[counter];
		item_ = counter - 1; // запоминаем индекс предыдущего элемента массива
		temp = mean[counter]; // инициализируем временную переменную текущим значением элемента массива
		item = counter - 1; // запоминаем индекс предыдущего элемента массива
		while (item >= 0 && mean[item] < temp) {// пока индекс не равен 0 и предыдущий элемент массива больше текущего
			mean[item + 1] = mean[item];
			mean[item] = temp;
			number[item + 1] = number[item];
			number[item] = temp_;
			item--;
		}
	}
	/*std::cout << "Відсортований" << std::endl;
	for (int i = 0; i < SIZE; i++)
		std::cout << "Студент номер " << number[i] << " із середнім балом: " << mean[i] << std::endl;*/

	_m.x = (SIZE * 40) / 100;
	/*std::cout << "x = " << _m.x << std::endl;
	std::cout << "Степендію отримають: " << std::endl;
	for (int i = 0; i < _m.x; i++)
		std::cout << "Студент номер " << number[i] << " із середнім балом: " << mean[i] << std::endl;
	std::cout << std::endl;*/


	return number;
}