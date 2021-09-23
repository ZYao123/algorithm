package lcs03

func largestArea(grid []string) int {
	cache := make([][]int, len(grid))
	for i := range cache {
		cache[i] = make([]int, len(grid[i]))
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			cache[i][j] = int(grid[i][j] - '0')
		}
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			helper(cache, i, j)
		}
	}
	for _, i := range []int{0, len(grid) - 1} {
		for j := 0; j < len(grid[i]); j++ {
			if cache[i][j] >= 1 && cache[i][j] <= 5 {
				cache[i][j] += 10
				helper(cache, i, j)
			}
		}
	}

	for i := 0; i < len(grid); i++ {
		for _, j := range []int{0, len(grid[i]) - 1} {
			if cache[i][j] >= 1 && cache[i][j] <= 5 {
				cache[i][j] += 10
				helper(cache, i, j)
			}
		}
	}

	max := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			m := count(cache, i, j)
			if m > max {
				max = m
			}
		}
	}
	return max
}

var arr = [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

func helper(cache [][]int, i int, j int) {
	if cache[i][j] >= 1 && cache[i][j] <= 5 {
		return
	}
	if cache[i][j] == 0 {
		for k := range arr {
			ia := i + arr[k][0]
			ja := j + arr[k][1]
			if ia >= 0 && ia < len(cache) && ja >= 0 && ja < len(cache[ia]) {
				if cache[ia][ja] >= 1 && cache[ia][ja] <= 5 {
					cache[ia][ja] += 10
					helper(cache, ia, ja)
				}
			}
		}

	} else if cache[i][j] > 10 {
		for k := range arr {
			if i+arr[k][0] >= 0 && i+arr[k][0] < len(cache) && j+arr[k][1] >= 0 && j+arr[k][1] < len(cache[i+arr[k][0]]) {
				if cache[i][j] == cache[i+arr[k][0]][j+arr[k][1]]+10 {
					cache[i+arr[k][0]][j+arr[k][1]] += 10
					helper(cache, i+arr[k][0], j+arr[k][1])
				}
			}
		}
	}
}

func count(cache [][]int, i int, j int) int {
	if cache[i][j] == 0 || cache[i][j] > 5 {
		return 0
	}
	c := 1
	cache[i][j] += 20
	for k := range arr {
		if i+arr[k][0] >= 0 && i+arr[k][0] < len(cache) && j+arr[k][1] >= 0 && j+arr[k][1] < len(cache) {
			if cache[i][j] == cache[i+arr[k][0]][j+arr[k][1]]+20 {
				c += count(cache, i+arr[k][0], j+arr[k][1])
			}
		}
	}
	return c
}
