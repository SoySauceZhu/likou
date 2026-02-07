
def bubble(arr):
    for i in range(len(arr) - 1, -1, -1):
        for j in range(i, len(arr) - 1):
            if (arr[j] > arr[j + 1]):
                t = arr[j+1]
                arr[j+1] = arr[j]
                arr[j] = t


def selection(arr):
    for i in range(len(arr)):
        m = arr[i]
        idx = i
        for j in range(i, len(arr)):
            if m > arr[j]:
                idx = j
                m = arr[idx]

        t = arr[i]
        arr[i] = arr[idx]
        arr[idx] = t


def quickSort(arr):
    def quickHelper(l, r):
        if (l >= r or r - l == 1):
            return
        else:
            pivot = arr[r-1]

            l_idx = l   # i is (will be) the last idx whose element is less than pivot

            for i in range(l, r - 1):
                if (arr[i] < pivot):
                    arr[i], arr[l_idx] = arr[l_idx], arr[i]
                    l_idx+=1
                
            arr[r-1] = arr[l_idx]
            arr[l_idx] = pivot

            quickHelper(l, l_idx)
            quickHelper(l_idx + 1, r)

    quickHelper(0, len(arr))


def main():
    ls = [5, 2, 1, 3, 4]
    quickSort(ls)
    print(ls)


main()
