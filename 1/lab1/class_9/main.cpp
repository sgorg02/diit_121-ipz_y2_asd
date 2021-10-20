#include <iostream>
#include <Windows.h>
#include "matrix.h"

int main() {
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	int rows, cols, menu1, menu2;
	std::cout << "Кількість студентів: ";
	std::cin >> rows;
	std::cout << "Кількість предметів: ";
	std::cin >> cols;
	
	matrix array = Create(rows, cols);
	matrix &a = array;

	do {
		std::system("cls");
		std::cout << "1.Заповнити матрицю" << std::endl;
		std::cout << "2.Вивести матрицю" << std::endl;
		std::cout << "3.Виконати підрахунки" << std::endl;
		std::cout << "4.Вихід" << std::endl;
		std::cin >> menu1;

		switch (menu1) {
		case 1: {
			do {
				system("cls");
				std::cout << "1.Рандомно" << std::endl;
				std::cout << "2.В ручну" << std::endl;
				std::cout << "3.Вихід в головне меню" << std::endl;
				std::cout << "4.Вихід з програми" << std::endl;
				std::cin >> menu2;
				switch (menu2) {
				case 1: {
					system("cls");
					RandFilling(array);
					Show(array);
					system("pause");
					break;
				}
				case 2: {
					system("cls");
					ManualFilling(array);
					Show(array);
					system("pause");
					break;
				}
				case 4:
					return 0;
				default:
					break;
				}
			} while (menu2 != 3);
			break;
		}
		case 2: {
			system("cls");
			Show(array);
			system("pause");
			break;
		}
		case 3: {
			system("cls");
			Show(array);
			int* Arr = Selection(a);
			ShowMean(Arr, array.x);
			system("pause");
			break;
		}
		case 4:
			Delete(array);
			return 0;
		default:
			break;
		}
	} while (menu1!=4);
}