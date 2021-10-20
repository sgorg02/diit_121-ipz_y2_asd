#include <iostream>
#include <Windows.h>
#include "matrix.h"

int main() {
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	int rows, cols, menu1, menu2;
	std::cout << "ʳ������ ��������: ";
	std::cin >> rows;
	std::cout << "ʳ������ ��������: ";
	std::cin >> cols;
	
	matrix array = Create(rows, cols);
	matrix &a = array;

	do {
		std::system("cls");
		std::cout << "1.��������� �������" << std::endl;
		std::cout << "2.������� �������" << std::endl;
		std::cout << "3.�������� ���������" << std::endl;
		std::cout << "4.�����" << std::endl;
		std::cin >> menu1;

		switch (menu1) {
		case 1: {
			do {
				system("cls");
				std::cout << "1.��������" << std::endl;
				std::cout << "2.� �����" << std::endl;
				std::cout << "3.����� � ������� ����" << std::endl;
				std::cout << "4.����� � ��������" << std::endl;
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