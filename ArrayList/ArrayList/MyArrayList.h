#pragma once
#include <cstdlib>
template <class T>
class MyArrayList
{
public:


	T& operator[](int i)
	{
		return array[i%count];
	}



	void add(T element)
	{
		if (count < size)
		{
			array[count++] = element;
		}
		else
		{
			array = (T*)realloc(array, (++size)*sizeof(T));
			array[count++] = element;
		}
	}

	void remove()
	{
		count--;
	}



	T getSP()
	{

		if (count>0) return array[count - 1];
	}

	int getCount()
	{
		return count;
	}

private:
	T *array = (T*)calloc(2, sizeof(T));
	int size = 2;
	int count = 0;

};

