package lcs

// func largestArea(grid []string) int {
// 	cache := make([][]int, len(grid))
// 	for i := range cache {
// 		cache[i] = make([]int, len(grid[i]))
// 	}
// 	for i := 0; i < len(grid); i++ {
// 		for j := 0; j < len(grid[i]); j++ {
// 			cache[i][j] = int(grid[i][j] - '0')
// 		}
// 	}
// 	for i := 0; i < len(grid); i++ {
// 		for j := 0; j < len(grid[i]); j++ {
// 			helper(cache, i, j)
// 		}
// 	}
// 	for _, i := range []int{0, len(grid) - 1} {
// 		for j := 0; j < len(grid[i]); j++ {
// 			if cache[i][j] >= 1 && cache[i][j] <= 5 {
// 				cache[i][j] += 10
// 				helper(cache, i, j)
// 			}
// 		}
// 	}
//
// 	for i := 0; i < len(grid); i++ {
// 		for _, j := range []int{0, len(grid[i]) - 1} {
// 			if cache[i][j] >= 1 && cache[i][j] <= 5 {
// 				cache[i][j] += 10
// 				helper(cache, i, j)
// 			}
// 		}
// 	}
//
// 	max := 0
// 	for i := 0; i < len(grid); i++ {
// 		for j := 0; j < len(grid[i]); j++ {
// 			m := count(cache, i, j)
// 			if m > max {
// 				max = m
// 			}
// 		}
// 	}
// 	return max
// }
//
// var arr = [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
//
// func helper(cache [][]int, i int, j int) {
// 	if cache[i][j] >= 1 && cache[i][j] <= 5 {
// 		return
// 	}
// 	if cache[i][j] == 0 {
// 		for k := range arr {
// 			ia := i + arr[k][0]
// 			ja := j + arr[k][1]
// 			if ia >= 0 && ia < len(cache) && ja >= 0 && ja < len(cache[ia]) {
// 				if cache[ia][ja] >= 1 && cache[ia][ja] <= 5 {
// 					cache[ia][ja] += 10
// 					helper(cache, ia, ja)
// 				}
// 			}
// 		}
//
// 	} else if cache[i][j] > 10 {
// 		for k := range arr {
// 			if i+arr[k][0] >= 0 && i+arr[k][0] < len(cache) && j+arr[k][1] >= 0 && j+arr[k][1] < len(cache[i+arr[k][0]]) {
// 				if cache[i][j] == cache[i+arr[k][0]][j+arr[k][1]]+10 {
// 					cache[i+arr[k][0]][j+arr[k][1]] += 10
// 					helper(cache, i+arr[k][0], j+arr[k][1])
// 				}
// 			}
// 		}
// 	}
// }
//
// func count(cache [][]int, i int, j int) int {
// 	if cache[i][j] == 0 || cache[i][j] > 5 {
// 		return 0
// 	}
// 	c := 1
// 	cache[i][j] += 20
// 	for k := range arr {
// 		if i+arr[k][0] >= 0 && i+arr[k][0] < len(cache) && j+arr[k][1] >= 0 && j+arr[k][1] < len(cache) {
// 			if cache[i][j] == cache[i+arr[k][0]][j+arr[k][1]]+20 {
// 				c += count(cache, i+arr[k][0], j+arr[k][1])
// 			}
// 		}
// 	}
// 	return c
// }

var flag bool = false
var count int = 0

func largestArea(grid []string) int {
	arr := make([][]uint8, len(grid))
	for i := range grid {
		arr[i] = make([]uint8, len(grid[i]))
		for j := range grid[i] {
			arr[i][j] = grid[i][j]
		}
	}

	n := len(arr)
	res := 0
	for i := 0; i < n; i++ {
		for j := 0; j < len(arr[i]); j++ {
			flag = true
			count = 0
			if arr[i][j] >= '1' && arr[i][j] <= '5' {
				helper(arr, i, j, arr[i][j])
				if flag && count > res {
					res = count
				}
			}
		}
	}
	return res
}

func helper(arr [][]uint8, x int, y int, ch uint8) {
	if x < 0 || x >= len(arr) || y < 0 || y >= len(arr[x]) || arr[x][y] == '0' {
		flag = false
		return
	}
	if arr[x][y] != ch {
		return
	}
	arr[x][y] = '6'
	count++
	helper(arr, x+1, y, ch)
	helper(arr, x-1, y, ch)
	helper(arr, x, y+1, ch)
	helper(arr, x, y-1, ch)
}
