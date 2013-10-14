// O(logm + logn)

public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int low = 0;
    int high = rows * cols - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (matrix[mid/cols][mid%cols] == target)
            return true;
        else if (matrix[mid/cols][mid%cols] < target)
            low = mid + 1;
        else if (matrix[mid/cols][mid%cols] > target)
            high = mid - 1;
    }
    return false;
}
