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

  return 0;
}
