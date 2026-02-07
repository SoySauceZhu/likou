
def bubble(arr):
    for i in range(len(arr)):
        for j in range(i, len(arr) - 1):
            if (arr[j] > arr[j + 1]):
                t = arr[i+1]
                arr[j+1] = arr[j]
                arr[j+1] = t


def main():
    ls = [5,2,1,3,4,]
    bubble(ls)
    print(ls)
    
