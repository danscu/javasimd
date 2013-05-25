#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void filldata(int *A, int n, int lim) {
  int i;
  for (i = 0; i < n; i ++)
    A[i] = rand() % lim;
}

int foo(int *A, int *B, int n) {
  unsigned sum = 0;
  int i;
  for (i = 0; i < n; ++i)
    if (A[i] > B[i])
      sum += A[i] + 5;
  return sum;
}

void foo2(int a1, int a2, int b1, int b2, int *A) {
  A[0] = a1*(a1 + b1)/b1 + 50*b1/a1;
  A[1] = a2*(a2 + b2)/b2 + 50*b2/a2;
}

int main()
{
  const int T = 100;
  const int N = 10000;
  int *A = malloc(sizeof(int) * N);
  int *B = malloc(sizeof(int) * N);

  if (!A || !B) {
    printf("No memory\n");
    return -1;
  }

  srand(time(NULL));

  filldata(A, N, 1000);
  filldata(B, N, 1000);

  int sum = foo(A, B, N);
  printf("sum: %d\n", sum);

  foo2(10, 10, 40, 50, A);

  return 0;
}
