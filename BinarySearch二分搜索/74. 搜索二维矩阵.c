// 二维数组 matrix = [ [1,3,5,7] , [10,11,16,20] , [23,30,34,60] ]
// 每个元素都是一个一维数组，所以matrixSize（元素个数）就是行数
// row行 column列
// 有序查找 = 二分
bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize,
                  int target) {
  while (true) {
    int left = 0;
    int right = matrixSize - 1;
    int mid = (left + right) / 2;
    if (matrix[mid][0] < target) {
      right = mid;
    }
  }
}